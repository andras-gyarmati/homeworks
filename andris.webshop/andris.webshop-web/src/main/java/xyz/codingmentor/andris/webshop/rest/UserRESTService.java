package xyz.codingmentor.andris.webshop.rest;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.andris.webshop.bean.UserEntity;
import xyz.codingmentor.andris.webshop.database.UserDB;
import xyz.codingmentor.andris.webshop.dto.ResultDTO;
import xyz.codingmentor.andris.webshop.dto.ResultType;
import xyz.codingmentor.andris.webshop.exception.AuthenticationFailureException;

/**
 *
 * @author beianelete
 */
@Path("users")
@SessionScoped
public class UserRESTService implements Serializable {

    public static final String USER_KEY = "user";

    @Inject
    private UserDB userDB;

    /**
     * http://localhost:8080/andriswebshop/users/login
     */
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO login(@Context HttpServletRequest request, UserEntity user) throws AuthenticationFailureException {
        UserEntity userEntity = userDB.authenticateUser(user);
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(2000);
        session.setAttribute(USER_KEY, userEntity);
        return new ResultDTO(ResultType.SUCCESS, userEntity);
    }

    @POST
    @Path("/logout")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO logout(@Context HttpServletRequest request) throws AuthenticationFailureException {
        HttpSession session = request.getSession();
        if (null == session.getAttribute(USER_KEY)) {
            throw new IllegalStateException("You are not logged in!");
        }
        UserEntity deletableUser = (UserEntity) session.getAttribute(USER_KEY);
        session.invalidate();
        return new ResultDTO(ResultType.SUCCESS, deletableUser);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO addUser(@Context HttpServletRequest request, UserEntity newUser) throws AuthenticationFailureException {
        HttpSession session = request.getSession();
        if (null == session.getAttribute(USER_KEY)) {
            throw new IllegalStateException("You should log in to add new users!");
        } else if (((UserEntity) session.getAttribute(USER_KEY)).isAdmin()) {
            userDB.addUser(newUser);
            return new ResultDTO(ResultType.SUCCESS, newUser);
        }
        return new ResultDTO(ResultType.ERROR, newUser);
    }
}
