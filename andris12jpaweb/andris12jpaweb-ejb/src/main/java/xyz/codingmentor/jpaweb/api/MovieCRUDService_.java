package xyz.codingmentor.jpaweb.api;

import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface MovieCRUDService_ {
    
    void createEntity(MovieEntity movie) throws RepoException;

    MovieEntity getEntityById(Long Id) throws RepoException;

    MovieEntity updateEntity(MovieEntity movie) throws RepoException;

    void removeEntity(Long Id) throws RepoException;
}
