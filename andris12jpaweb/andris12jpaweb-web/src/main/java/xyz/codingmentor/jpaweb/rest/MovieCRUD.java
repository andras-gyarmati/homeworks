package xyz.codingmentor.jpaweb.rest;

import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaweb.api.MovieCRUDResource_;
import xyz.codingmentor.jpaweb.api.MovieCRUDService_;
import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 * REST Web Service
 *
 * @author brianelete
 */
@Path("movie")
@RequestScoped
public class MovieCRUD implements MovieCRUDResource_ {

    private final MovieCRUDService_ movieCRUDService;

    public MovieCRUD(MovieCRUDService_ movieCRUDService) {
        this.movieCRUDService = movieCRUDService;
    }
    
    @Override
    public Response createEntity(MovieEntity movie) throws RepoException {
        movieCRUDService.createEntity(movie);
        return Response.ok(movie, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response getEntityById(Long Id) throws RepoException {
        return Response.ok(movieCRUDService.getEntityById(Id), MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response updateEntity(MovieEntity movie) throws RepoException {
        movieCRUDService.updateEntity(movie);
        return Response.ok(movie, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response deleteEntityById(Long Id) throws RepoException {
        movieCRUDService.removeEntity(Id);
        return Response.ok().build();
    }

}
