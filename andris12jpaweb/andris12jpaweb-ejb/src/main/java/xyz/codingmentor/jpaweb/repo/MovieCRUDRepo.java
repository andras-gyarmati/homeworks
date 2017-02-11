package xyz.codingmentor.jpaweb.repo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.api.MovieCRUDRepo_;

/**
 *
 * @author brianelete
 */
@Stateless
public class MovieCRUDRepo implements MovieCRUDRepo_ {

    @PersistenceContext(unitName = "jpawebPU")
    private EntityManager entityManager;

    public MovieCRUDRepo() {
        //empty
    }

    @Override
    public void create(MovieEntity movie) throws RepoException {
        entityManager.persist(movie);
    }

    @Override
    public MovieEntity read(Long Id) throws RepoException {
        return entityManager.find(MovieEntity.class, Id);
    }

    @Override
    public MovieEntity update(MovieEntity movie) throws RepoException {
        return entityManager.merge(movie);
    }

    @Override
    public void delete(Long Id) throws RepoException {
        entityManager.remove(read(Id));
    }
    
}
