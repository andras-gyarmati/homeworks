package xyz.codingmentor.jpaweb.repo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jpaweb.entity.CategoryEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.api.CategoryCRUDRepo_;

/**
 *
 * @author brianelete
 */
@Stateless
public class CategoryCRUDRepo implements CategoryCRUDRepo_ {

    @PersistenceContext(unitName = "jpawebPU")
    private EntityManager entityManager;

    public CategoryCRUDRepo() {
        //empty
    }

    @Override
    public void persist(CategoryEntity category) throws RepoException {
        entityManager.persist(category);
    }

    @Override
    public CategoryEntity find(Long Id) throws RepoException {
        return entityManager.find(CategoryEntity.class, Id);
    }

    @Override
    public CategoryEntity merge(CategoryEntity category) throws RepoException {
        return entityManager.merge(category);
    }

    @Override
    public void remove(Long Id) throws RepoException {
        entityManager.remove(find(Id));
    }
    
}
