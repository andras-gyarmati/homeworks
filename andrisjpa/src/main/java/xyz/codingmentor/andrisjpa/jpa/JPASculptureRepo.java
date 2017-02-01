package xyz.codingmentor.andrisjpa.jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import xyz.codingmentor.andrisjpa.api.RepositoryException;
import xyz.codingmentor.andrisjpa.entity.SculptorEntity;
import xyz.codingmentor.andrisjpa.entity.SculptureEntity;
import xyz.codingmentor.andrisjpa.entity.WorkshopEntity;

/**
 *
 * @author brianelete
 */
@Stateless
public class JPASculptureRepo {

    private final EntityManagerFactory factory;
    private final EntityManager entityManager;

    public JPASculptureRepo() {
        factory = Persistence.createEntityManagerFactory("andrisjpaPU");
        entityManager = factory.createEntityManager();
    }

    public SculptureEntity createSculpture() throws RepositoryException {
        SculptureEntity sculptor = new SculptureEntity();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(sculptor);
        tx.commit();
        return sculptor;
    }

    public SculptureEntity readSculpture(String sculptureId) throws RepositoryException {
        SculptureEntity sculpture = entityManager.find(SculptureEntity.class, sculptureId);
        if (null != sculpture) {
            return sculpture;
        }
        return null;
    }

    public void updateSculpture(SculptureEntity sculpture) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        SculptureEntity entity = entityManager.find(SculptureEntity.class, sculpture.getId());
        entity.setCreationDate(sculpture.getCreationDate());
        entity.setCreator(sculpture.getCreator());
        entity.setMaterial(sculpture.getMaterial());
        entity.setName(sculpture.getName());
        entityManager.merge(entity);
        tx.commit();
    }

    public void deleteSculpture(String id) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        SculptureEntity sculpture = entityManager.find(SculptureEntity.class, id);
        if (null != sculpture) {
            entityManager.remove(sculpture);
        }
        tx.commit();
    }
    
    public List<SculptorEntity> getAllSculptor() throws RepositoryException {
        String selectQuery = "SELECT s FROM sculptor s";
        TypedQuery<SculptorEntity> query = entityManager.createQuery(selectQuery, SculptorEntity.class);
        List<SculptorEntity> result = query.getResultList();
        return result;
    }
    
    public List<SculptorEntity> findSculptorByName(String name) throws RepositoryException {
        String selectQuery = "SELECT s FROM sculptor s WHERE s.name LIKE :name";
        TypedQuery<SculptorEntity> query = entityManager.createQuery(selectQuery, SculptorEntity.class);
        query.setParameter("title", "%" + name + "%");
        List<SculptorEntity> result = query.getResultList();
        return result;
    }
    
    public List<WorkshopEntity> findWorkshopsBySculptor(String name) throws RepositoryException {
        String selectQuery = "SELECT s.workshops FROM sculptor s WHERE s.name = :name";
        TypedQuery<WorkshopEntity> query = entityManager.createQuery(selectQuery, WorkshopEntity.class);
        query.setParameter("name", name);
        List<WorkshopEntity> result = query.getResultList();
        return result;
    }
    
    public List<SculptorEntity> findSculptorsByWorkshop(WorkshopEntity workshop) throws RepositoryException {
        String selectQuery = "SELECT s FROM sculptor s WHERE :workshop MEMBER OF s.workshops";
        TypedQuery<SculptorEntity> query = entityManager.createQuery(selectQuery, SculptorEntity.class);
        query.setParameter("workshop", workshop);
        List<SculptorEntity> result = query.getResultList();
        return result;
    }
    
    public List<SculptureEntity> findSculptorsByWorkshop(String name) throws RepositoryException {
        String selectQuery = "SELECT s.workshops FROM sculptor s WHERE s.name = :name";
        TypedQuery<SculptureEntity> query = entityManager.createQuery(selectQuery, SculptureEntity.class);
        query.setParameter("name", name);
        List<SculptureEntity> result = query.getResultList();
        return result;
    }
    
    public void close() {
        factory.close();
        entityManager.close();
    }

}
