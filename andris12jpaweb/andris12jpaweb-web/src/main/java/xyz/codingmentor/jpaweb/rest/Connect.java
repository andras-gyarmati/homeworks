package xyz.codingmentor.jpaweb.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.service.ConnectEntities;

/**
 *
 * @author brianelete
 */
@Path("connect")
public class Connect {

    private ConnectEntities connectEntities;

    public Connect() {
        //empty
    }

    @Inject
    public Connect(ConnectEntities connectEntities) {
        this.connectEntities = connectEntities;
    }

    @GET
    @Path("movieandactor")
    public Response connectMovieAndActor(@QueryParam("movieId") Long movieId, @QueryParam("actorId") Long actorId) throws RepoException {
        connectEntities.connectMovieAndActor(movieId, actorId);
        return Response.ok().build();
    }

    @GET
    @Path("movieandcategory")
    public Response connectMovieAndCategory(@QueryParam("movieId") Long movieId, @QueryParam("categoryId") Long categoryId) throws RepoException {
        connectEntities.connectMovieAndCategory(movieId, categoryId);
        return Response.ok().build();
    }

    @GET
    @Path("movieandtrailer")
    public Response connectMovieAndTrailer(@QueryParam("movieId") Long movieId, @QueryParam("trailerId") Long trailerId) throws RepoException {
        connectEntities.connectMovieAndTrailer(movieId, trailerId);
        return Response.ok().build();
    }

}
