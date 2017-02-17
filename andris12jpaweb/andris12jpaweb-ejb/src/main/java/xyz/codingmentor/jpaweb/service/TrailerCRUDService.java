package xyz.codingmentor.jpaweb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.jpaweb.dto.TrailerDTO;
import xyz.codingmentor.jpaweb.entity.TrailerEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.api.ITrailerCRUDService;
import xyz.codingmentor.jpaweb.api.ITrailerCRUDRepo;

/**
 *
 * @author brianelete
 */
@Stateless
public class TrailerCRUDService implements ITrailerCRUDService {

    private final ITrailerCRUDRepo repo;

    public TrailerCRUDService() {
        repo = null;
    }

    @Inject
    public TrailerCRUDService(ITrailerCRUDRepo trailerCRUDRepo) {
        this.repo = trailerCRUDRepo;
    }

    @Override
    public void create(TrailerDTO trailer) throws RepoException {
        repo.create(trailer);
    }

    @Override
    public TrailerEntity read(Long id) throws RepoException {
        return repo.read(id);
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
    public void delete(Long id) throws RepoException {
        repo.delete(id);
    }

}
