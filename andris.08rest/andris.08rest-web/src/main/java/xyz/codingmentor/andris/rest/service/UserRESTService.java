package xyz.codingmentor.andris.rest.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.andris.rest.dto.UserEntity;
import xyz.codingmentor.andris.rest.exception.IdNotMatchException;

/**
*
* @author brianelete
*/
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserRESTService {

    private static final Map<String, UserEntity> USERS = new HashMap<>();
    
    /**
     * http://localhost:8080/andris.08rest-web/rest/users
     * @return
     */
    @GET
    public Collection<UserEntity> getUsers() {
        return USERS.values();
    }

    /**
     * http://localhost:8080/andris.08rest-web/rest/users
     * @param user
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public UserEntity addUser(UserEntity user) {
        user.setId(UUID.randomUUID().toString());
        USERS.put(user.getId(), user);
        return user;
    }

    /**
     * http://localhost:8080/andris.08rest-web/rest/users/{id}
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    public UserEntity getUserById(@PathParam("id") String id) {
        return USERS.get(id);
    }

    /**
     * http://localhost:8080/andris.08rest-web/rest/users/{id}
     * @param id
     * @param user
     * @return
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public UserEntity updateUser(@PathParam("id") String id, UserEntity user) {
        if (!user.getId().equals(id)) {
            throw new IdNotMatchException("ID error");
        }
        USERS.put(user.getId(), user);
        return user;
    }

    /**
     * http://localhost:8080/andris.08rest-web/rest/users/{id}
     * @param id
     * @return
     */
    @DELETE
    @Path("/{id}")
    public UserEntity deleteUser(@PathParam("id") String id) {
        return USERS.remove(id);
    }

}
