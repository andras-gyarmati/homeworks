package xyz.codingmentor.jpaweb.api;

import xyz.codingmentor.jpaweb.entity.CategoryEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface CategoryCRUDService_ {
    
    void createEntity(CategoryEntity category) throws RepoException;

    CategoryEntity getEntityById(Long Id) throws RepoException;

    CategoryEntity updateEntity(CategoryEntity category) throws RepoException;

    void deleteEntity(Long Id) throws RepoException;
}
