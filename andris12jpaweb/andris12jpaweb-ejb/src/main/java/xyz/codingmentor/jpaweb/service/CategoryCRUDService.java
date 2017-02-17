package xyz.codingmentor.jpaweb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.jpaweb.api.CategoryCRUDRepo_;
import xyz.codingmentor.jpaweb.api.CategoryCRUDService_;
import xyz.codingmentor.jpaweb.dto.CategoryDTO;
import xyz.codingmentor.jpaweb.entity.CategoryEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
@Stateless
public class CategoryCRUDService implements CategoryCRUDService_ {

    private final CategoryCRUDRepo_ repo;

    public CategoryCRUDService() {
        repo = null;
    }

    @Inject
    public CategoryCRUDService(CategoryCRUDRepo_ categoryCRUDRepo) {
        this.repo = categoryCRUDRepo;
    }

    @Override
    public void create(CategoryDTO category) throws RepoException {
        repo.create(category);
    }

    @Override
    public CategoryEntity read(Long Id) throws RepoException {
        return repo.read(Id);
    }

    @Override
    public CategoryEntity update(CategoryEntity category) throws RepoException {
        return repo.update(category);
    }

    @Override
    public CategoryEntity update(CategoryDTO category) throws RepoException {
        return repo.update(category);
    }

    @Override
    public void delete(Long Id) throws RepoException {
        repo.delete(Id);
    }
    
}
