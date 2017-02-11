package xyz.codingmentor.jpaweb.api;

import xyz.codingmentor.jpaweb.entity.CategoryEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface CategoryCRUDRepo_ {

    void persist(CategoryEntity category) throws RepoException;

    CategoryEntity find(Long Id) throws RepoException;

    CategoryEntity merge(CategoryEntity category) throws RepoException;

    void remove(Long Id) throws RepoException;
}
