package xyz.codingmentor.jpaweb.api;

import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface MovieCRUDRepo_ {

    void persist(MovieEntity movie) throws RepoException;

    MovieEntity find(Long Id) throws RepoException;

    MovieEntity merge(MovieEntity movie) throws RepoException;

    void remove(Long Id) throws RepoException;
}
