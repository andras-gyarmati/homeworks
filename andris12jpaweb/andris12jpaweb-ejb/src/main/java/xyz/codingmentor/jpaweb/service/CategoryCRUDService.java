package xyz.codingmentor.jpaweb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.jpaweb.api.CategoryCRUDRepo_;
import xyz.codingmentor.jpaweb.api.CategoryCRUDService_;
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
    public void createEntity(CategoryEntity category) throws RepoException {
        repo.create(category);
    }

    @Override
    public CategoryEntity getEntityById(Long Id) throws RepoException {
        return repo.read(Id);
    }

    @Override
    public CategoryEntity updateEntity(CategoryEntity category) throws RepoException {
        return repo.update(category);
    }

    @Override
    public void deleteEntity(Long Id) throws RepoException {
        repo.delete(Id);
    }
    
}
