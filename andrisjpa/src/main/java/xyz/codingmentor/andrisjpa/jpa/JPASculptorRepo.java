package xyz.codingmentor.andrisjpa.jpa;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import xyz.codingmentor.andrisjpa.api.RepositoryException;
import xyz.codingmentor.andrisjpa.entity.SculptorEntity;
import xyz.codingmentor.andrisjpa.entity.SculptorId;
import xyz.codingmentor.andrisjpa.entity.SculptureEntity;
import xyz.codingmentor.andrisjpa.entity.WorkshopEntity;

/**
 *
 * @author brianelete
 */
@Stateless
public class JPASculptorRepo {

    private final EntityManagerFactory factory;
    private final EntityManager entityManager;

    public JPASculptorRepo() {
        factory = Persistence.createEntityManagerFactory("andrisjpaPU");
        entityManager = factory.createEntityManager();
    }

    public SculptorEntity createSculptor(Date birthDate, String name) throws RepositoryException {
        SculptorEntity sculptor = new SculptorEntity();
        sculptor.setName(name);
        sculptor.setBirthDate(birthDate);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(sculptor);
        tx.commit();
        return sculptor;
    }

    public SculptorEntity findSculptor(Date birthDate, String name) throws RepositoryException {
        SculptorId id = new SculptorId(birthDate, name);
        SculptorEntity sculptor = entityManager.find(SculptorEntity.class, id);
        if (null != sculptor) {
            return sculptor;
        }
        return null;
    }

    public void updateSculptor(SculptorEntity upToDateSculptor) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(upToDateSculptor);
        tx.commit();
    }

    public void deleteSculptor(Date birthDate, String name) throws RepositoryException {
        SculptorId id = new SculptorId(birthDate, name);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        SculptorEntity sculptor = entityManager.find(SculptorEntity.class, id);
        if (null != sculptor) {
            entityManager.remove(sculptor);
        }
        tx.commit();
    }

    public List<SculptorEntity> getAllSculptor() throws RepositoryException {
        String selectQuery = "SELECT s FROM SculptorEntity s";
        TypedQuery<SculptorEntity> query = entityManager.createQuery(selectQuery, SculptorEntity.class);
        return query.getResultList();
    }

    public List<SculptorEntity> findSculptorByName(String name) throws RepositoryException {
        String selectQuery = "SELECT s FROM SculptorEntity s WHERE s.name LIKE :name";
        TypedQuery<SculptorEntity> query = entityManager.createQuery(selectQuery, SculptorEntity.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    public List<WorkshopEntity> findWorkshopsBySculptor(String name) throws RepositoryException {
        String selectQuery = "SELECT s FROM SculptorEntity s WHERE s.name = :name";
        TypedQuery<SculptorEntity> query = entityManager.createQuery(selectQuery, SculptorEntity.class);
        query.setParameter("name", name);
        List<SculptorEntity> sculptors = query.getResultList();
        return sculptors.get(0).getWorkshops();
    }

    public List<SculptorEntity> findSculptorsByWorkshop(WorkshopEntity workshop) throws RepositoryException {
        String selectQuery = "SELECT s FROM SculptorEntity s WHERE :workshop MEMBER OF s.workshops";
        TypedQuery<SculptorEntity> query = entityManager.createQuery(selectQuery, SculptorEntity.class);
        query.setParameter("workshop", workshop);
        return query.getResultList();
    }

    public List<SculptureEntity> findSculpturesBySculptor(String name) throws RepositoryException {
        String selectQuery = "SELECT s FROM SculptorEntity s WHERE s.name = :name";
        TypedQuery<SculptorEntity> query = entityManager.createQuery(selectQuery, SculptorEntity.class);
        query.setParameter("name", name);
        List<SculptorEntity> sculptors = query.getResultList();
        return sculptors.get(0).getSculptures();
    }

    public void close() {
        factory.close();
        entityManager.close();
    }

}
