package xyz.codingmentor.jpaweb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.jpaweb.dto.ActorDTO;
import xyz.codingmentor.jpaweb.entity.ActorEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.api.IActorCRUDRepo;
import xyz.codingmentor.jpaweb.api.IActorCRUDService;

/**
 *
 * @author brianelete
 */
@Stateless
public class ActorCRUDService implements IActorCRUDService {

    private final IActorCRUDRepo repo;

    public ActorCRUDService() {
        repo = null;
    }

    @Inject
    public ActorCRUDService(IActorCRUDRepo actorCRUDRepo) {
        this.repo = actorCRUDRepo;
    }

    @Override
    public void create(ActorDTO actor) throws RepoException {
        repo.create(actor);
    }

    @Override
    public ActorEntity read(Long id) throws RepoException {
        return repo.read(id);
    }

    @Override
    public ActorEntity update(ActorEntity actor) throws RepoException {
        return repo.update(actor);
    }
    
    @Override
    public ActorEntity update(ActorDTO actor) throws RepoException {
        return repo.update(actor);
    }

    @Override
    public void delete(Long id) throws RepoException {
        repo.delete(id);
    }
    
}
