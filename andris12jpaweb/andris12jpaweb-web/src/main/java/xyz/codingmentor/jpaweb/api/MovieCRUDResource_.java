package xyz.codingmentor.jpaweb.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface MovieCRUDResource_ {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response createEntity(MovieEntity movie) throws RepoException;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getEntityById(@PathParam("id") Long Id) throws RepoException;

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateEntity(MovieEntity movie) throws RepoException;

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEntityById(@PathParam("id") Long Id) throws RepoException;
    
}
