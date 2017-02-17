package xyz.codingmentor.jpaweb.repo;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jpaweb.entity.ActorEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;
import xyz.codingmentor.jpaweb.api.ActorCRUDRepo_;
import xyz.codingmentor.jpaweb.dto.ActorDTO;
import xyz.codingmentor.jpaweb.entity.MovieEntity;

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
    public void create(ActorDTO actor) throws RepoException {
        entityManager.persist(buildActor(actor));
    }

    @Override
    public ActorEntity read(Long Id) throws RepoException {
        return entityManager.find(ActorEntity.class, Id);
    }

    @Override
    public ActorEntity update(ActorEntity actor) throws RepoException {
        return entityManager.merge(actor);
    }

    @Override
    public ActorEntity update(ActorDTO actor) throws RepoException {
        return entityManager.merge(buildActor(actor));
    }

    @Override
    public void delete(Long Id) throws RepoException {
        entityManager.remove(read(Id));
    }

    private ActorEntity buildActor(ActorDTO actorDTO) {
        ActorEntity actor = entityManager.find(ActorEntity.class, actorDTO.getId());
        if (null == actor) {
            actor = new ActorEntity();
            actor.setMovies(new ArrayList<>());
        }
        actor.setId(actorDTO.getId());
        actor.setFirstName(actorDTO.getFirstName());
        actor.setLastName(actorDTO.getLastName());
        actor.setNationality(actorDTO.getNationality());
        for (Long movie : actorDTO.getMovies()) {
            MovieEntity movieEntity = entityManager.find(MovieEntity.class, movie);
            if (null != movieEntity) {
                movieEntity.getActors().add(actor);
                actor.getMovies().add(movieEntity);
            }
        }
        return actor;
    }

}
