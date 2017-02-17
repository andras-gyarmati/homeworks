package xyz.codingmentor.jpaweb.rest;

import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaweb.api.MovieCRUDResource_;
import xyz.codingmentor.jpaweb.api.MovieCRUDService_;
import xyz.codingmentor.jpaweb.dto.MovieDTO;
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

    public MovieCRUD() {
        movieCRUDService = null;
    }

    @Inject
    public MovieCRUD(MovieCRUDService_ movieCRUDService) {
        this.movieCRUDService = movieCRUDService;
    }
    
    @Override
    public Response create(MovieDTO movie) throws RepoException {
        movieCRUDService.create(movie);
        return Response.ok(movie, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response read(Long Id) throws RepoException {
        return Response.ok(movieCRUDService.read(Id), MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response update(MovieDTO movie) throws RepoException {
        movieCRUDService.update(movie);
        return Response.ok(movie, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response delete(Long Id) throws RepoException {
        movieCRUDService.delete(Id);
        return Response.ok().build();
    }

}
