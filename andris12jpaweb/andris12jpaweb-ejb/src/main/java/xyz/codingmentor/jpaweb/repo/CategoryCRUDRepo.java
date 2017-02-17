package xyz.codingmentor.jpaweb.repo;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jpaweb.entity.CategoryEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.dto.CategoryDTO;
import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.api.ICategoryCRUDRepo;

/**
 *
 * @author brianelete
 */
@Stateless
public class CategoryCRUDRepo implements ICategoryCRUDRepo {

    @PersistenceContext(unitName = "jpawebPU")
    private EntityManager entityManager;

    public CategoryCRUDRepo() {
        //empty
    }

    @Override
    public void create(CategoryDTO category) throws RepoException {
        entityManager.persist(buildCategory(category));
    }

    @Override
    public CategoryEntity read(Long id) throws RepoException {
        return entityManager.find(CategoryEntity.class, id);
    }

    @Override
    public CategoryEntity update(CategoryEntity category) throws RepoException {
        return entityManager.merge(category);
    }
    
    @Override
    public CategoryEntity update(CategoryDTO category) throws RepoException {
        return entityManager.merge(buildCategory(category));
    }

    @Override
    public void delete(Long id) throws RepoException {
        entityManager.remove(read(id));
    }
    
    private CategoryEntity buildCategory(CategoryDTO categoryDTO) {
        CategoryEntity category = entityManager.find(CategoryEntity.class, categoryDTO.getId());
        if (null == category) {
            category = new CategoryEntity();
            category.setMovies(new ArrayList<>());
        }
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        for (Long movie : categoryDTO.getMovies()) {
           MovieEntity movieEntity = entityManager.find(MovieEntity.class, movie);
            if (null != movieEntity) {
                movieEntity.setCategory(category);
                category.getMovies().add(movieEntity);
            }
        }
        return category;
    }
    
}
