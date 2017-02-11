package xyz.codingmentor.jpaweb.rest;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import xyz.codingmentor.jpaweb.entity.ActorEntity;
import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.entity.TrailerEntity;
import xyz.codingmentor.jpaweb.service.JPQLService;

/**
 * REST Web Service
 *
 * @author brianelete
 */
@Path("query")
@RequestScoped
public class Query {

    private JPQLService jpqlService;

    public Query() {
        //empty
    }

    @Inject
    public Query(JPQLService jpqlService) {
        this.jpqlService = jpqlService;
    }

    @GET
    @Path("movie")
    public List<MovieEntity> getMovieByCategoryAndOrName(@QueryParam("title") String title, @QueryParam("categoryId") Long categoryId) {
        return jpqlService.getMovieByCategoryAndOrName(categoryId, title);
    }

    @GET
    @Path("actor")
    public List<ActorEntity> getActorByMovieAndOrName(@QueryParam("movieId") Long movieId, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName) {
        return jpqlService.getActorByMovieAndOrName(movieId, firstName, lastName);
    }

    @GET
    @Path("actor/{nationality}")
    public List<ActorEntity> getActorByNationality(@PathParam("nationality") String nat) {
        return jpqlService.getActorByNationality(nat);
    }

    @GET
    @Path("trailer")
    public List<TrailerEntity> getTrailerByMovie(@QueryParam("movieId") Long movieId) {
        return jpqlService.getTrailerByMovie(movieId);
    }

}
