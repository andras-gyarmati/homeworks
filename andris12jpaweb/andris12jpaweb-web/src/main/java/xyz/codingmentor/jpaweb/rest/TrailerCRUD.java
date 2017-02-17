package xyz.codingmentor.jpaweb.rest;

import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaweb.api.TrailerCRUDResource_;
import xyz.codingmentor.jpaweb.api.TrailerCRUDService_;
import xyz.codingmentor.jpaweb.dto.TrailerDTO;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 * REST Web Service
 *
 * @author brianelete
 */
@Path("trailer")
@RequestScoped
public class TrailerCRUD implements TrailerCRUDResource_ {

    private final TrailerCRUDService_ trailerCRUDService;

    public TrailerCRUD() {
        trailerCRUDService = null;
    }

    @Inject
    public TrailerCRUD(TrailerCRUDService_ trailerCRUDService) {
        this.trailerCRUDService = trailerCRUDService;
    }
    
    @Override
    public Response create(TrailerDTO trailer) throws RepoException {
        trailerCRUDService.create(trailer);
        return Response.ok(trailer, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response read(Long Id) throws RepoException {
        return Response.ok(trailerCRUDService.read(Id), MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response update(TrailerDTO trailer) throws RepoException {
        trailerCRUDService.update(trailer);
        return Response.ok(trailer, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response delete(Long Id) throws RepoException {
        trailerCRUDService.delete(Id);
        return Response.ok().build();
    }

}
