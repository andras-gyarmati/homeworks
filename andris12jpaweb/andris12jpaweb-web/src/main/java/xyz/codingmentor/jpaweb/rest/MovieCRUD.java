package xyz.codingmentor.jpaweb.rest;

import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaweb.dto.MovieDTO;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.api.IMovieCRUDService;
import xyz.codingmentor.jpaweb.api.IMovieCRUDResource;

/**
 * REST Web Service
 *
 * @author brianelete
 */
@Path("movie")
@RequestScoped
public class MovieCRUD implements IMovieCRUDResource {

    private final IMovieCRUDService movieCRUDService;

    public MovieCRUD() {
        movieCRUDService = null;
    }

    @Inject
    public MovieCRUD(IMovieCRUDService movieCRUDService) {
        this.movieCRUDService = movieCRUDService;
    }
    
    @Override
    public Response create(MovieDTO movie) throws RepoException {
        movieCRUDService.create(movie);
        return Response.ok(movie, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response read(Long id) throws RepoException {
        return Response.ok(movieCRUDService.read(id), MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response update(MovieDTO movie) throws RepoException {
        movieCRUDService.update(movie);
        return Response.ok(movie, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response delete(Long id) throws RepoException {
        movieCRUDService.delete(id);
        return Response.ok().build();
    }

}
