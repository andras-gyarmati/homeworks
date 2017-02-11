package xyz.codingmentor.jpaweb.api;

import xyz.codingmentor.jpaweb.entity.ActorEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface ActorCRUDService_ {

    void createEntity(ActorEntity actor) throws RepoException;

    ActorEntity getEntityById(Long Id) throws RepoException;

    ActorEntity updateEntity(ActorEntity actor) throws RepoException;

    void deleteEntity(Long Id) throws RepoException;
}
