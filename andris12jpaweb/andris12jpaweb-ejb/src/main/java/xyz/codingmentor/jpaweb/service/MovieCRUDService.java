package xyz.codingmentor.jpaweb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.jpaweb.api.MovieCRUDRepo_;
import xyz.codingmentor.jpaweb.api.MovieCRUDService_;
import xyz.codingmentor.jpaweb.dto.MovieDTO;
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
    public void create(MovieDTO movie) throws RepoException {
        repo.create(movie);
    }

    @Override
    public MovieEntity read(Long Id) throws RepoException {
        return repo.read(Id);
    }

    @Override
    public MovieEntity update(MovieEntity movie) throws RepoException {
        return repo.update(movie);
    }

    @Override
    public MovieEntity update(MovieDTO movie) throws RepoException {
        return repo.update(movie);
    }

    @Override
    public void delete(Long Id) throws RepoException {
        repo.delete(Id);
    }
    
}
