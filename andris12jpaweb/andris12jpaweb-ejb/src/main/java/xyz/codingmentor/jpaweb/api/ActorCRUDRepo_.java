package xyz.codingmentor.jpaweb.api;

import xyz.codingmentor.jpaweb.entity.ActorEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface ActorCRUDRepo_ {

    void create(ActorEntity actor) throws RepoException;

    ActorEntity read(Long Id) throws RepoException;

    ActorEntity update(ActorEntity actor) throws RepoException;

    void delete(Long Id) throws RepoException;
}
