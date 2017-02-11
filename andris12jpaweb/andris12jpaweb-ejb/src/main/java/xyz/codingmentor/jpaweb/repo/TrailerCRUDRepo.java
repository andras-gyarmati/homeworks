package xyz.codingmentor.jpaweb.repo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jpaweb.entity.TrailerEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.api.TrailerCRUDRepo_;

/**
 *
 * @author brianelete
 */
@Stateless
public class TrailerCRUDRepo implements TrailerCRUDRepo_ {

    @PersistenceContext(unitName = "jpawebPU")
    private EntityManager entityManager;

    public TrailerCRUDRepo() {
        //empty
    }

    @Override
    public void persist(TrailerEntity trailer) throws RepoException {
        entityManager.persist(trailer);
    }

    @Override
    public TrailerEntity find(Long Id) throws RepoException {
        return entityManager.find(TrailerEntity.class, Id);
    }

    @Override
    public TrailerEntity merge(TrailerEntity trailer) throws RepoException {
        return entityManager.merge(trailer);
    }

    @Override
    public void remove(Long Id) throws RepoException {
        entityManager.remove(find(Id));
    }
    
}
