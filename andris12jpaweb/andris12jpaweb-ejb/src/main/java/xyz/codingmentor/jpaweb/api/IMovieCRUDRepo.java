package xyz.codingmentor.jpaweb.api;

import xyz.codingmentor.jpaweb.dto.MovieDTO;
import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface IMovieCRUDRepo {

    void create(MovieDTO movie) throws RepoException;

    MovieEntity read(Long id) throws RepoException;

    MovieEntity update(MovieEntity movie) throws RepoException;

    MovieEntity update(MovieDTO movie) throws RepoException;

    void delete(Long id) throws RepoException;
}
