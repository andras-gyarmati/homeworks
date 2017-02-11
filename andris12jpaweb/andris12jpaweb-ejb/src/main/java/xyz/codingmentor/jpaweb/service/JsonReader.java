package xyz.codingmentor.jpaweb.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import com.fasterxml.jackson.core.type.TypeReference;
import xyz.codingmentor.jpaweb.entity.ActorEntity;
import xyz.codingmentor.jpaweb.entity.CategoryEntity;
import xyz.codingmentor.jpaweb.entity.MovieEntity;
import xyz.codingmentor.jpaweb.entity.TrailerEntity;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
@Singleton
@Startup
public class JsonReader {

    @Inject
    private MovieCRUDService movieService;
    @Inject
    private ActorCRUDService actorService;
    @Inject
    private CategoryCRUDService categoryService;
    @Inject
    private TrailerCRUDService trailerService;
    private static final Logger LOGGER = Logger.getLogger(JsonReader.class.getName());

    @PostConstruct
    void init() {
        try {
            readFromJson(".json");

        } catch (RepoException e) {
            LOGGER.log(Level.SEVERE, null, e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, null, e);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    private void readFromJson(String filename) throws IOException, RepoException {
        ObjectMapper mapper = new ObjectMapper();
        List<ActorEntity> actors = mapper.readValue(new File(getClass().getClassLoader().getResource(filename).getFile()), new TypeReference<List<ActorEntity>>() {});
        List<CategoryEntity> categories = mapper.readValue(new File(getClass().getClassLoader().getResource(filename).getFile()), new TypeReference<List<CategoryEntity>>() {});
        List<MovieEntity> movies = mapper.readValue(new File(getClass().getClassLoader().getResource(filename).getFile()), new TypeReference<List<MovieEntity>>() {});
        List<TrailerEntity> trailers = mapper.readValue(new File(getClass().getClassLoader().getResource(filename).getFile()), new TypeReference<List<TrailerEntity>>() {});
        for (ActorEntity actor : actors) {
            actorService.createEntity(actor);
        }
        for (CategoryEntity category : categories) {
            categoryService.createEntity(category);
        }
        for (MovieEntity movie : movies) {
            movieService.createEntity(movie);
        }
        for (TrailerEntity trailer : trailers) {
            trailerService.createEntity(trailer);
        }
    }
}
