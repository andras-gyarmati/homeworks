package xyz.codingmentor.jpaweb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.jpaweb.api.TrailerCRUDRepo_;
import xyz.codingmentor.jpaweb.api.TrailerCRUDService_;
import xyz.codingmentor.jpaweb.dto.TrailerDTO;
import xyz.codingmentor.jpaweb.entity.TrailerEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
@Stateless
public class TrailerCRUDService implements TrailerCRUDService_ {

    private final TrailerCRUDRepo_ repo;

    public TrailerCRUDService() {
        repo = null;
    }

    @Inject
    public TrailerCRUDService(TrailerCRUDRepo_ trailerCRUDRepo) {
        this.repo = trailerCRUDRepo;
    }

    @Override
    public void create(TrailerDTO trailer) throws RepoException {
        repo.create(trailer);
    }

    @Override
    public TrailerEntity read(Long Id) throws RepoException {
        return repo.read(Id);
    }

    @Override
    public TrailerEntity update(TrailerEntity trailer) throws RepoException {
        return repo.update(trailer);
    }

    @Override
    public TrailerEntity update(TrailerDTO trailer) throws RepoException {
        return repo.update(trailer);
    }

    @Override
    public void delete(Long Id) throws RepoException {
        repo.delete(Id);
    }

}
