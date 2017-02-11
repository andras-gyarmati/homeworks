package xyz.codingmentor.jpaweb.service;

import javax.ejb.Stateless;
import xyz.codingmentor.jpaweb.api.ActorCRUDService_;
import xyz.codingmentor.jpaweb.entity.ActorEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.repo.ActorCRUDRepo;

/**
 *
 * @author brianelete
 */
@Stateless
public class ActorCRUDService implements ActorCRUDService_ {

    private final ActorCRUDRepo repo;

    public ActorCRUDService() {
        repo = null;
    }

    public ActorCRUDService(ActorCRUDRepo actorCRUDRepo) {
        this.repo = actorCRUDRepo;
    }

    @Override
    public void createEntity(ActorEntity actor) throws RepoException {
        repo.persist(actor);
    }

    @Override
    public ActorEntity getEntityById(Long Id) throws RepoException {
        return repo.find(Id);
    }

    @Override
    public ActorEntity updateEntity(ActorEntity actor) throws RepoException {
        return repo.merge(actor);
    }

    @Override
    public void removeEntity(Long Id) throws RepoException {
        repo.remove(Id);
    }
    
}
