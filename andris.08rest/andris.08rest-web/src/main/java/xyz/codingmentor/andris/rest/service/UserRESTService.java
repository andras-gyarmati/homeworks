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
    
    @GET
    public Collection<UserEntity> getUsers() {
        return USERS.values();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public UserEntity addUser(UserEntity user) {
        user.setId(UUID.randomUUID().toString());
        USERS.put(user.getId(), user);
        return user;
    }

    @GET
    @Path("/{id}")
    public UserEntity getUserById(@PathParam("id") String id) {
        return USERS.get(id);
    }

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

    @DELETE
    @Path("/{id}")
    public UserEntity deleteUser(@PathParam("id") String id) {
        return USERS.remove(id);
    }

}
