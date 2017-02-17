package xyz.codingmentor.jpaweb.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import xyz.codingmentor.jpaweb.entity.ActorEntity;
import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.entity.TrailerEntity;
import xyz.codingmentor.jpaweb.ex.EmptyParametersException;

/**
 *
 * @author brianelete
 */
@Stateless
public class JPQLService {

    @PersistenceContext(unitName = "jpawebPU")
    private EntityManager entityManager;

    public List<MovieEntity> getMovieByCategoryAndOrName(Long categoryId, String title) {
        if (null != categoryId && null != title) {
            String selectQuery = "SELECT m FROM MovieEntity m WHERE m.category.id = :categoryId AND m.title = :title";
            TypedQuery<MovieEntity> query = entityManager.createQuery(selectQuery, MovieEntity.class);
            query.setParameter("categoryId", categoryId);
            query.setParameter("title", title);
            return query.getResultList();
        } else if (null != categoryId || null != title) {
            String selectQuery = "SELECT m FROM MovieEntity m WHERE m.category.id = :categoryId OR m.title = :title";
            TypedQuery<MovieEntity> query = entityManager.createQuery(selectQuery, MovieEntity.class);
            query.setParameter("categoryId", categoryId);
            query.setParameter("title", title);
            return query.getResultList();
        }
        throw new EmptyParametersException("Error! Empty input");
    }

    public List<ActorEntity> getActorByMovieAndOrName(Long movieId, String firstName, String lastName) {
        if (null != firstName && null != lastName && null != movieId) {
            String selectQuery = "SELECT a FROM ActorEntity a INNER JOIN a.movies m WHERE m.id = :movieId AND a.firstName = :firstName AND a.lastName = :lastName";
            TypedQuery<ActorEntity> query = entityManager.createQuery(selectQuery, ActorEntity.class);
            query.setParameter("movieId", movieId);
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);
            return query.getResultList();
        } else if ((null != firstName && null != lastName) || null != movieId) {
            String selectQuery = "SELECT a FROM ActorEntity a INNER JOIN a.movies m WHERE (a.firstName = :firstName AND a.lastName = :lastName) OR m.id = :movieId";
            TypedQuery<ActorEntity> query = entityManager.createQuery(selectQuery, ActorEntity.class);
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);
            query.setParameter("movieId", movieId);
            return query.getResultList();
        }
        throw new EmptyParametersException("Error! Empty input");
    }

    public List<ActorEntity> getActorByNationality(String nationality) {
        if (null != nationality) {
            String selectQuery = "SELECT a FROM ActorEntity a WHERE a.nationality = :nationality";
            TypedQuery<ActorEntity> query = entityManager.createQuery(selectQuery, ActorEntity.class);
            query.setParameter("nationality", nationality);
            return query.getResultList();
        }
        throw new EmptyParametersException("Error! Empty input");
    }

    public List<TrailerEntity> getTrailerByMovie(Long movieId) {
        if (null != movieId) {
            String selectQuery = "SELECT t FROM TrailerEntity t WHERE t.movie.id = :movieId";
            TypedQuery<TrailerEntity> query = entityManager.createQuery(selectQuery, TrailerEntity.class);
            query.setParameter("movieId", movieId);
            return query.getResultList();
        }
        throw new EmptyParametersException("Error! Empty input");
    }
}
