package xyz.codingmentor.jpaweb.api;

import xyz.codingmentor.jpaweb.entity.TrailerEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface TrailerCRUDRepo_ {

    void create(TrailerEntity trailer) throws RepoException;

    TrailerEntity read(Long Id) throws RepoException;

    TrailerEntity update(TrailerEntity trailer) throws RepoException;

    void delete(Long Id) throws RepoException;
}
