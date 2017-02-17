package xyz.codingmentor.jpaweb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.jpaweb.dto.CategoryDTO;
import xyz.codingmentor.jpaweb.entity.CategoryEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.api.ICategoryCRUDRepo;
import xyz.codingmentor.jpaweb.api.ICategoryCRUDService;

/**
 *
 * @author brianelete
 */
@Stateless
public class CategoryCRUDService implements ICategoryCRUDService {

    private final ICategoryCRUDRepo repo;

    public CategoryCRUDService() {
        repo = null;
    }

    @Inject
    public CategoryCRUDService(ICategoryCRUDRepo categoryCRUDRepo) {
        this.repo = categoryCRUDRepo;
    }

    @Override
    public void create(CategoryDTO category) throws RepoException {
        repo.create(category);
    }

    @Override
    public CategoryEntity read(Long id) throws RepoException {
        return repo.read(id);
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
    public void delete(Long id) throws RepoException {
        repo.delete(id);
    }
    
}
