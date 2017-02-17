package xyz.codingmentor.jpaweb.repo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jpaweb.entity.TrailerEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.dto.TrailerDTO;
import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.api.ITrailerCRUDRepo;

/**
 *
 * @author brianelete
 */
@Stateless
public class TrailerCRUDRepo implements ITrailerCRUDRepo {

    @PersistenceContext(unitName = "jpawebPU")
    private EntityManager entityManager;

    public TrailerCRUDRepo() {
        //empty
    }

    @Override
    public void create(TrailerDTO trailer) throws RepoException {
        entityManager.persist(buildTrailer(trailer));
    }

    @Override
    public TrailerEntity read(Long id) throws RepoException {
        return entityManager.find(TrailerEntity.class, id);
    }

    @Override
    public TrailerEntity update(TrailerEntity trailer) throws RepoException {
        return entityManager.merge(trailer);
    }

    @Override
    public TrailerEntity update(TrailerDTO trailer) throws RepoException {
        return entityManager.merge(buildTrailer(trailer));
    }

    @Override
    public void delete(Long id) throws RepoException {
        entityManager.remove(read(id));
    }

    private TrailerEntity buildTrailer(TrailerDTO trailerDTO) {
        TrailerEntity trailer = entityManager.find(TrailerEntity.class, trailerDTO.getId());
        if (null == trailer) {
            trailer = new TrailerEntity();
        }
        trailer.setId(trailerDTO.getId());
        trailer.setUrl(trailerDTO.getUrl());
        trailer.setPlatform(trailerDTO.getPlatform());
        trailer.setTitle(trailerDTO.getTitle());
        trailer.setReleaseDate(trailerDTO.getReleaseDate());
        MovieEntity movieEntity = entityManager.find(MovieEntity.class, trailerDTO.getMovie());
        if (null != movieEntity) {
            movieEntity.getTrailers().add(trailer);
            trailer.setMovie(movieEntity);
        }

        return trailer;
    }

}
