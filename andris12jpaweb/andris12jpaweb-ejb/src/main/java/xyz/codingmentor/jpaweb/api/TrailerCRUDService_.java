package xyz.codingmentor.jpaweb.api;

import xyz.codingmentor.jpaweb.dto.TrailerDTO;
import xyz.codingmentor.jpaweb.entity.TrailerEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface TrailerCRUDService_ {

    void create(TrailerDTO trailer) throws RepoException;

    TrailerEntity read(Long Id) throws RepoException;

    TrailerEntity update(TrailerEntity trailer) throws RepoException;

    TrailerEntity update(TrailerDTO trailer) throws RepoException;

    void delete(Long Id) throws RepoException;
}
