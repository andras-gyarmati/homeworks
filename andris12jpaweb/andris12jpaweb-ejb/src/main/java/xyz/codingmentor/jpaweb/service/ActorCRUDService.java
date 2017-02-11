package xyz.codingmentor.jpaweb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.jpaweb.api.ActorCRUDRepo_;
import xyz.codingmentor.jpaweb.api.ActorCRUDService_;
import xyz.codingmentor.jpaweb.entity.ActorEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
@Stateless
public class ActorCRUDService implements ActorCRUDService_ {

    private final ActorCRUDRepo_ repo;

    public ActorCRUDService() {
        repo = null;
    }

    @Inject
    public ActorCRUDService(ActorCRUDRepo_ actorCRUDRepo) {
        this.repo = actorCRUDRepo;
    }

    @Override
    public void createEntity(ActorEntity actor) throws RepoException {
        repo.create(actor);
    }

    @Override
    public ActorEntity getEntityById(Long Id) throws RepoException {
        return repo.read(Id);
    }

    @Override
    public ActorEntity updateEntity(ActorEntity actor) throws RepoException {
        return repo.update(actor);
    }

    @Override
    public void deleteEntity(Long Id) throws RepoException {
        repo.delete(Id);
    }
    
}
