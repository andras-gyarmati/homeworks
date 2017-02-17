package xyz.codingmentor.jpaweb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.jpaweb.dto.MovieDTO;
import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.api.IMovieCRUDRepo;
import xyz.codingmentor.jpaweb.api.IMovieCRUDService;

/**
 *
 * @author brianelete
 */
@Stateless
public class MovieCRUDService implements IMovieCRUDService {

    private final IMovieCRUDRepo repo;

    public MovieCRUDService() {
        repo = null;
    }

    @Inject
    public MovieCRUDService(IMovieCRUDRepo movieCRUDRepo) {
        this.repo = movieCRUDRepo;
    }

    @Override
    public void create(MovieDTO movie) throws RepoException {
        repo.create(movie);
    }

    @Override
    public MovieEntity read(Long id) throws RepoException {
        return repo.read(id);
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
    public void delete(Long id) throws RepoException {
        repo.delete(id);
    }
    
}
