package xyz.codingmentor.jpaweb.api;

import xyz.codingmentor.jpaweb.dto.CategoryDTO;
import xyz.codingmentor.jpaweb.entity.CategoryEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
public interface CategoryCRUDRepo_ {

    void create(CategoryDTO category) throws RepoException;

    CategoryEntity read(Long Id) throws RepoException;

    CategoryEntity update(CategoryEntity category) throws RepoException;

    CategoryEntity update(CategoryDTO category) throws RepoException;

    void delete(Long Id) throws RepoException;
}
