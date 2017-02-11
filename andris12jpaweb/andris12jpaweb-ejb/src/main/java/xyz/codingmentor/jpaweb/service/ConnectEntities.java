package xyz.codingmentor.jpaweb.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.jpaweb.api.ActorCRUDService_;
import xyz.codingmentor.jpaweb.api.CategoryCRUDService_;
import xyz.codingmentor.jpaweb.api.MovieCRUDService_;
import xyz.codingmentor.jpaweb.api.TrailerCRUDService_;
import xyz.codingmentor.jpaweb.entity.ActorEntity;
import xyz.codingmentor.jpaweb.entity.CategoryEntity;
import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.entity.TrailerEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
@Stateless
public class ConnectEntities {

    @Inject
    private Logger logger;
    
    private ActorCRUDService_ actorCRUDService;
    private MovieCRUDService_ movieCRUDService;
    private CategoryCRUDService_ categoryCRUDService;
    private TrailerCRUDService_ traileCRUDService;

    public ConnectEntities() {
        //empty
    }

    @Inject
    public ConnectEntities(ActorCRUDService_ actorCRUDService, MovieCRUDService_ movieCRUDService, CategoryCRUDService_ categoryCRUDService, TrailerCRUDService_ traileCRUDService) {
        this.actorCRUDService = actorCRUDService;
        this.movieCRUDService = movieCRUDService;
        this.categoryCRUDService = categoryCRUDService;
        this.traileCRUDService = traileCRUDService;
    }

    public void connectMovieAndActor(Long movieId, Long actorId) {
        try {
            ActorEntity actor = actorCRUDService.getEntityById(actorId);
            MovieEntity movie = movieCRUDService.getEntityById(movieId);
            if (!actor.getMovies().contains(movie)) {
                actor.getMovies().add(movie);
                actorCRUDService.updateEntity(actor);
            }
        } catch (RepoException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void connectMovieAndCategory(Long movieId, Long categoryId) {
        try {
            CategoryEntity category = categoryCRUDService.getEntityById(categoryId);
            MovieEntity movie = movieCRUDService.getEntityById(movieId);
            movie.setCategory(category);
            movieCRUDService.updateEntity(movie);
        } catch (RepoException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void connectMovieAndTrailer(Long movieId, Long trailerId) {
        try {
            TrailerEntity trailer = traileCRUDService.getEntityById(trailerId);
            MovieEntity movie = movieCRUDService.getEntityById(movieId);
            trailer.setMovie(movie);
            traileCRUDService.updateEntity(trailer);
        } catch (RepoException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

}
