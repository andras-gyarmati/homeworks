package xyz.codingmentor.jpaweb.repo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jpaweb.entity.ActorEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.api.ActorCRUDRepo_;

/**
 *
 * @author brianelete
 */
@Stateless
public class ActorCRUDRepo implements ActorCRUDRepo_ {

    @PersistenceContext(unitName = "jpawebPU")
    private EntityManager entityManager;

    public ActorCRUDRepo() {
        //empty
    }

    @Override
    public void persist(ActorEntity actor) throws RepoException {
        entityManager.persist(actor);
    }

    @Override
    public ActorEntity find(Long Id) throws RepoException {
        return entityManager.find(ActorEntity.class, Id);
    }

    @Override
    public ActorEntity merge(ActorEntity actor) throws RepoException {
        return entityManager.merge(actor);
    }

    @Override
    public void remove(Long Id) throws RepoException {
        entityManager.remove(find(Id));
    }
    
}
