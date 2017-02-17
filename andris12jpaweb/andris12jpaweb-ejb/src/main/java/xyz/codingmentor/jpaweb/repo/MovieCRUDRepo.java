package xyz.codingmentor.jpaweb.repo;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.dto.MovieDTO;
import xyz.codingmentor.jpaweb.entity.ActorEntity;
import xyz.codingmentor.jpaweb.entity.CategoryEntity;
import xyz.codingmentor.jpaweb.entity.TrailerEntity;
import xyz.codingmentor.jpaweb.api.IMovieCRUDRepo;

/**
 *
 * @author brianelete
 */
@Stateless
public class MovieCRUDRepo implements IMovieCRUDRepo {

    @PersistenceContext(unitName = "jpawebPU")
    private EntityManager entityManager;

    public MovieCRUDRepo() {
        //empty
    }

    @Override
    public void create(MovieDTO movie) throws RepoException {
        entityManager.persist(buildMovie(movie));
    }

    @Override
    public MovieEntity read(Long id) throws RepoException {
        return entityManager.find(MovieEntity.class, id);
    }

    @Override
    public MovieEntity update(MovieEntity movie) throws RepoException {
        return entityManager.merge(movie);
    }

    @Override
    public MovieEntity update(MovieDTO movie) throws RepoException {
        return entityManager.merge(buildMovie(movie));
    }

    @Override
    public void delete(Long id) throws RepoException {
        entityManager.remove(read(id));
    }

    private MovieEntity buildMovie(MovieDTO movieDTO) {
        MovieEntity movie = entityManager.find(MovieEntity.class, movieDTO.getId());
        if (null == movie) {
            movie = new MovieEntity();
            movie.setActors(new ArrayList<>());
            movie.setTrailers(new ArrayList<>());
        }
        movie.setId(movieDTO.getId());
        movie.setTitle(movieDTO.getTitle());
        movie.setCategory(entityManager.find(CategoryEntity.class, movieDTO.getCategory()));
        for (Long actor : movieDTO.getActors()) {
            ActorEntity actorEntity = entityManager.find(ActorEntity.class, actor);
            if (null != actorEntity) {
                actorEntity.getMovies().add(movie);
                movie.getActors().add(actorEntity);
            }
        }
        for (Long trailer : movieDTO.getTrailers()) {
            TrailerEntity trailerEntity = entityManager.find(TrailerEntity.class, trailer);
            if (null != trailerEntity) {
                trailerEntity.setMovie(movie);
                movie.getTrailers().add(trailerEntity);
            }
        }
        return movie;
    }

}
