package xyz.codingmentor.andris.webshop.rest;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.andris.webshop.bean.UserEntity;
import xyz.codingmentor.andris.webshop.database.UserDB;
import xyz.codingmentor.andris.webshop.dto.ResultDTO;
import xyz.codingmentor.andris.webshop.dto.ResultType;
import xyz.codingmentor.andris.webshop.exception.NotLoggedInException;
import xyz.codingmentor.andris.webshop.exceptions.AuthenticationFailureException;

/**
 *
 * @author beianelete
 */
@Path("/users")
@SessionScoped
public class UserRESTService implements Serializable {

    public static final String USER_KEY = "user";
    private static final Logger LOGGER = Logger.getLogger(UserRESTService.class.getName());

    @EJB
    private UserDB userDB;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO login(@Context HttpServletRequest request, UserEntity user) {
        try {
            UserEntity userEntity = userDB.authenticateUser(user);
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(2000);
            session.setAttribute(USER_KEY, userEntity);
            return new ResultDTO(ResultType.SUCCESS, userEntity);
        } catch (AuthenticationFailureException e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
        return new ResultDTO(ResultType.ERROR, user);
    }

    @POST
    @Path("/logout")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO logout(@Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserEntity logoutUser = isLoggedIn(session);
        session.invalidate();
        return new ResultDTO(ResultType.SUCCESS, logoutUser);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO addUser(@Context HttpServletRequest request, UserEntity newUser) {
        HttpSession session = request.getSession();
        if (isLoggedIn(session).isAdmin()) {
            UserEntity returnedUser = userDB.addUser(newUser);
            return new ResultDTO(ResultType.SUCCESS, returnedUser);
        }
        return new ResultDTO(ResultType.ERROR, newUser);
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO deleteUser(@Context HttpServletRequest request, UserEntity deleteUser) {
        HttpSession session = request.getSession();
        if (isLoggedIn(session).isAdmin()) {
            userDB.deleteUser(deleteUser);
            return new ResultDTO(ResultType.SUCCESS, deleteUser);
        }
        return new ResultDTO(ResultType.ERROR, deleteUser);
    }
    
    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserEntity getUser(@PathParam("username") String username) {
        return userDB.getUser(username);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserEntity> getAllUser() {
        return userDB.getAllUser();
    }
    
    private static UserEntity isLoggedIn(HttpSession session) {
        if (session.getAttribute(UserRESTService.USER_KEY) == null) {
            throw new NotLoggedInException("You should log in first!");
        }
        return (UserEntity) session.getAttribute(USER_KEY);
    }
}
