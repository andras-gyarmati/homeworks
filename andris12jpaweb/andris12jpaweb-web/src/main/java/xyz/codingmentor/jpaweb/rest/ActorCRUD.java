package xyz.codingmentor.jpaweb.rest;

import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaweb.api.ActorCRUDResource_;
import xyz.codingmentor.jpaweb.api.ActorCRUDService_;
import xyz.codingmentor.jpaweb.dto.ActorDTO;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 * REST Web Service
 *
 * @author brianelete
 */
@Path("actor")
@RequestScoped
public class ActorCRUD implements ActorCRUDResource_ {

    private final ActorCRUDService_ actorCRUDService;

    public ActorCRUD() {
        actorCRUDService = null;
    }
    
    @Inject
    public ActorCRUD(ActorCRUDService_ actorCRUDService) {
        this.actorCRUDService = actorCRUDService;
    }
    
    @Override
    public Response createEntity(ActorDTO actor) throws RepoException {
        actorCRUDService.create(actor);
        return Response.ok(actor, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response getEntityById(Long Id) throws RepoException {
        return Response.ok(actorCRUDService.read(Id), MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response updateEntity(ActorDTO actor) throws RepoException {
        actorCRUDService.update(actor);
        return Response.ok(actor, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response deleteEntityById(Long Id) throws RepoException {
        actorCRUDService.delete(Id);
        return Response.ok().build();
    }

}
