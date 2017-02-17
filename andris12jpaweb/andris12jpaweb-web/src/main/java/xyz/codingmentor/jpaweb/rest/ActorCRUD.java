package xyz.codingmentor.jpaweb.rest;

import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaweb.dto.ActorDTO;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.api.IActorCRUDService;
import xyz.codingmentor.jpaweb.api.IActorCRUDResource;

/**
 * REST Web Service
 *
 * @author brianelete
 */
@Path("actor")
@RequestScoped
public class ActorCRUD implements IActorCRUDResource {

    private final IActorCRUDService actorCRUDService;

    public ActorCRUD() {
        actorCRUDService = null;
    }
    
    @Inject
    public ActorCRUD(IActorCRUDService actorCRUDService) {
        this.actorCRUDService = actorCRUDService;
    }
    
    @Override
    public Response createEntity(ActorDTO actor) throws RepoException {
        actorCRUDService.create(actor);
        return Response.ok(actor, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response getEntityById(Long id) throws RepoException {
        return Response.ok(actorCRUDService.read(id), MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response updateEntity(ActorDTO actor) throws RepoException {
        actorCRUDService.update(actor);
        return Response.ok(actor, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response deleteEntityById(Long id) throws RepoException {
        actorCRUDService.delete(id);
        return Response.ok().build();
    }

}
