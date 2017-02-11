package xyz.codingmentor.jpaweb.api;

import xyz.codingmentor.jpaweb.entity.TrailerEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface TrailerCRUDRepo_ {

    void persist(TrailerEntity trailer) throws RepoException;

    TrailerEntity find(Long Id) throws RepoException;

    TrailerEntity merge(TrailerEntity trailer) throws RepoException;

    void remove(Long Id) throws RepoException;
}
