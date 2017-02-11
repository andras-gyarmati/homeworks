package xyz.codingmentor.jpaweb.rest;

import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaweb.api.TrailerCRUDResource_;
import xyz.codingmentor.jpaweb.api.TrailerCRUDService_;
import xyz.codingmentor.jpaweb.entity.TrailerEntity;
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

    public TrailerCRUD(TrailerCRUDService_ trailerCRUDService) {
        this.trailerCRUDService = trailerCRUDService;
    }
    
    @Override
    public Response createEntity(TrailerEntity trailer) throws RepoException {
        trailerCRUDService.createEntity(trailer);
        return Response.ok(trailer, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response getEntityById(Long Id) throws RepoException {
        return Response.ok(trailerCRUDService.getEntityById(Id), MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response updateEntity(TrailerEntity trailer) throws RepoException {
        trailerCRUDService.updateEntity(trailer);
        return Response.ok(trailer, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response deleteEntityById(Long Id) throws RepoException {
        trailerCRUDService.deleteEntity(Id);
        return Response.ok().build();
    }

}
