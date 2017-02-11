package xyz.codingmentor.jpaweb.service;

import javax.ejb.Stateless;
import xyz.codingmentor.jpaweb.api.MovieCRUDService_;
import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.repo.MovieCRUDRepo;

/**
 *
 * @author brianelete
 */
@Stateless
public class MovieCRUDService implements MovieCRUDService_ {

    private final MovieCRUDRepo repo;

    public MovieCRUDService() {
        repo = null;
    }

    public MovieCRUDService(MovieCRUDRepo movieCRUDRepo) {
        this.repo = movieCRUDRepo;
    }

    @Override
    public void createEntity(MovieEntity movie) throws RepoException {
        repo.persist(movie);
    }

    @Override
    public MovieEntity getEntityById(Long Id) throws RepoException {
        return repo.find(Id);
    }

    @Override
    public MovieEntity updateEntity(MovieEntity movie) throws RepoException {
        return repo.merge(movie);
    }

    @Override
    public void removeEntity(Long Id) throws RepoException {
        repo.remove(Id);
    }
    
}
