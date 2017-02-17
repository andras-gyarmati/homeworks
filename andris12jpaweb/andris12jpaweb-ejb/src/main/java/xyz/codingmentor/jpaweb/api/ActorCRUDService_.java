package xyz.codingmentor.jpaweb.api;

import xyz.codingmentor.jpaweb.dto.ActorDTO;
import xyz.codingmentor.jpaweb.entity.ActorEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface ActorCRUDService_ {

    void create(ActorDTO actor) throws RepoException;

    ActorEntity read(Long Id) throws RepoException;

    ActorEntity update(ActorEntity actor) throws RepoException;

    ActorEntity update(ActorDTO actor) throws RepoException;

    void delete(Long Id) throws RepoException;
}
