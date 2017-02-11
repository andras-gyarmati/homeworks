package xyz.codingmentor.jpaweb.api;

import xyz.codingmentor.jpaweb.entity.ActorEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface ActorCRUDRepo_ {

    void persist(ActorEntity actor) throws RepoException;

    ActorEntity find(Long Id) throws RepoException;

    ActorEntity merge(ActorEntity actor) throws RepoException;

    void remove(Long Id) throws RepoException;
}
