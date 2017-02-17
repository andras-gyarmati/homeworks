package xyz.codingmentor.jpaweb.rest;

import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaweb.dto.TrailerDTO;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.api.ITrailerCRUDService;
import xyz.codingmentor.jpaweb.api.ITrailerCRUDResource;

/**
 * REST Web Service
 *
 * @author brianelete
 */
@Path("trailer")
@RequestScoped
public class TrailerCRUD implements ITrailerCRUDResource {

    private final ITrailerCRUDService trailerCRUDService;

    public TrailerCRUD() {
        trailerCRUDService = null;
    }

    @Inject
    public TrailerCRUD(ITrailerCRUDService trailerCRUDService) {
        this.trailerCRUDService = trailerCRUDService;
    }
    
    @Override
    public Response create(TrailerDTO trailer) throws RepoException {
        trailerCRUDService.create(trailer);
        return Response.ok(trailer, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response read(Long id) throws RepoException {
        return Response.ok(trailerCRUDService.read(id), MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response update(TrailerDTO trailer) throws RepoException {
        trailerCRUDService.update(trailer);
        return Response.ok(trailer, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response delete(Long id) throws RepoException {
        trailerCRUDService.delete(id);
        return Response.ok().build();
    }

}
