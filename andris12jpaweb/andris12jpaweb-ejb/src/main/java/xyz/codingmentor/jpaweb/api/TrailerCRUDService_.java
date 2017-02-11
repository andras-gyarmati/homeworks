package xyz.codingmentor.jpaweb.api;

import xyz.codingmentor.jpaweb.entity.TrailerEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface TrailerCRUDService_ {
    
    void createEntity(TrailerEntity trailer) throws RepoException;

    TrailerEntity getEntityById(Long Id) throws RepoException;

    TrailerEntity updateEntity(TrailerEntity trailer) throws RepoException;

    void deleteEntity(Long Id) throws RepoException;
}
