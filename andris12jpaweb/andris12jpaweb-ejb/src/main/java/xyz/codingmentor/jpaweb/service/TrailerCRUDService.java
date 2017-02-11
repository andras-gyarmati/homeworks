package xyz.codingmentor.jpaweb.service;

import javax.ejb.Stateless;
import xyz.codingmentor.jpaweb.api.TrailerCRUDService_;
import xyz.codingmentor.jpaweb.entity.TrailerEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.repo.TrailerCRUDRepo;

/**
 *
 * @author brianelete
 */
@Stateless
public class TrailerCRUDService implements TrailerCRUDService_ {

    private final TrailerCRUDRepo repo;

    public TrailerCRUDService() {
        repo = null;
    }

    public TrailerCRUDService(TrailerCRUDRepo trailerCRUDRepo) {
        this.repo = trailerCRUDRepo;
    }

    @Override
    public void createEntity(TrailerEntity trailer) throws RepoException {
        repo.persist(trailer);
    }

    @Override
    public TrailerEntity getEntityById(Long Id) throws RepoException {
        return repo.find(Id);
    }

    @Override
    public TrailerEntity updateEntity(TrailerEntity trailer) throws RepoException {
        return repo.merge(trailer);
    }

    @Override
    public void removeEntity(Long Id) throws RepoException {
        repo.remove(Id);
    }

}
