package xyz.codingmentor.jpaweb.api;

import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface MovieCRUDRepo_ {

    void create(MovieEntity movie) throws RepoException;

    MovieEntity read(Long Id) throws RepoException;

    MovieEntity update(MovieEntity movie) throws RepoException;

    void delete(Long Id) throws RepoException;
}
