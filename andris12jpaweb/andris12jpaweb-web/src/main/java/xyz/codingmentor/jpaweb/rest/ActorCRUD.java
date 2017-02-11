package xyz.codingmentor.jpaweb.rest;

import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaweb.api.ActorCRUDResource_;
import xyz.codingmentor.jpaweb.api.ActorCRUDService_;
import xyz.codingmentor.jpaweb.entity.ActorEntity;
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

    public ActorCRUD(ActorCRUDService_ actorCRUDService) {
        this.actorCRUDService = actorCRUDService;
    }
    
    @Override
    public Response createEntity(ActorEntity actor) throws RepoException {
        actorCRUDService.createEntity(actor);
        return Response.ok(actor, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response getEntityById(Long Id) throws RepoException {
        return Response.ok(actorCRUDService.getEntityById(Id), MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response updateEntity(ActorEntity actor) throws RepoException {
        actorCRUDService.updateEntity(actor);
        return Response.ok(actor, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response deleteEntityById(Long Id) throws RepoException {
        actorCRUDService.deleteEntity(Id);
        return Response.ok().build();
    }

}
