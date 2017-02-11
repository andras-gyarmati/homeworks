package xyz.codingmentor.jpaweb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.jpaweb.api.MovieCRUDRepo_;
import xyz.codingmentor.jpaweb.api.MovieCRUDService_;
import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
@Stateless
public class MovieCRUDService implements MovieCRUDService_ {

    private final MovieCRUDRepo_ repo;

    public MovieCRUDService() {
        repo = null;
    }

    @Inject
    public MovieCRUDService(MovieCRUDRepo_ movieCRUDRepo) {
        this.repo = movieCRUDRepo;
    }

    @Override
    public void createEntity(MovieEntity movie) throws RepoException {
        repo.create(movie);
    }

    @Override
    public MovieEntity getEntityById(Long Id) throws RepoException {
        return repo.read(Id);
    }

    @Override
    public MovieEntity updateEntity(MovieEntity movie) throws RepoException {
        return repo.update(movie);
    }

    @Override
    public void deleteEntity(Long Id) throws RepoException {
        repo.delete(Id);
    }
    
}
