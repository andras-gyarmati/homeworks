package xyz.codingmentor.jpaweb.api;

import xyz.codingmentor.jpaweb.dto.TrailerDTO;
import xyz.codingmentor.jpaweb.entity.TrailerEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface ITrailerCRUDRepo {

    void create(TrailerDTO trailer) throws RepoException;

    TrailerEntity read(Long id) throws RepoException;

    TrailerEntity update(TrailerEntity trailer) throws RepoException;

    TrailerEntity update(TrailerDTO trailer) throws RepoException;

    void delete(Long id) throws RepoException;
}
