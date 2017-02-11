package xyz.codingmentor.jpaweb.service;

import javax.ejb.Stateless;
import xyz.codingmentor.jpaweb.api.CategoryCRUDService_;
import xyz.codingmentor.jpaweb.entity.CategoryEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.repo.CategoryCRUDRepo;

/**
 *
 * @author brianelete
 */
@Stateless
public class CategoryCRUDService implements CategoryCRUDService_ {

    private final CategoryCRUDRepo repo;

    public CategoryCRUDService() {
        repo = null;
    }

    public CategoryCRUDService(CategoryCRUDRepo categoryCRUDRepo) {
        this.repo = categoryCRUDRepo;
    }

    @Override
    public void createEntity(CategoryEntity category) throws RepoException {
        repo.persist(category);
    }

    @Override
    public CategoryEntity getEntityById(Long Id) throws RepoException {
        return repo.find(Id);
    }

    @Override
    public CategoryEntity updateEntity(CategoryEntity category) throws RepoException {
        return repo.merge(category);
    }

    @Override
    public void removeEntity(Long Id) throws RepoException {
        repo.remove(Id);
    }
    
}
