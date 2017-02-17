package xyz.codingmentor.jpaweb.service;

import com.fasterxml.jackson.core.type.TypeReference;
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
import xyz.codingmentor.jpaweb.api.ActorCRUDService_;
import xyz.codingmentor.jpaweb.api.CategoryCRUDService_;
import xyz.codingmentor.jpaweb.api.MovieCRUDService_;
import xyz.codingmentor.jpaweb.api.TrailerCRUDService_;
import xyz.codingmentor.jpaweb.dto.ActorDTO;
import xyz.codingmentor.jpaweb.dto.CategoryDTO;
import xyz.codingmentor.jpaweb.dto.MovieDTO;
import xyz.codingmentor.jpaweb.dto.TrailerDTO;
import xyz.codingmentor.jpaweb.ex.RepoException;

/**
 *
 * @author brianelete
 */
@Singleton
@Startup
public class JsonReader {

    @Inject
    private MovieCRUDService_ movieService;
    @Inject
    private ActorCRUDService_ actorService;
    @Inject
    private CategoryCRUDService_ categoryService;
    @Inject
    private TrailerCRUDService_ trailerService;
    private static final Logger LOGGER = Logger.getLogger(JsonReader.class.getName());

    @PostConstruct
    void init() {
        try {
            readFromJson("actor.json", "category.json", "movie.json", "trailer.json");
        } catch (RepoException e) {
            LOGGER.log(Level.SEVERE, null, e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, null, e);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    private void readFromJson(String actorFileName, String categoryFileName, String movieFileName, String trailerFileName) throws IOException, RepoException {
        ObjectMapper mapper = new ObjectMapper();
        List<ActorDTO> actors = mapper.readValue(new File(getClass().getClassLoader().getResource(actorFileName).getFile()), new TypeReference<List<ActorDTO>>() {});
        List<CategoryDTO> categories = mapper.readValue(new File(getClass().getClassLoader().getResource(categoryFileName).getFile()), new TypeReference<List<CategoryDTO>>() {});
        List<MovieDTO> movies = mapper.readValue(new File(getClass().getClassLoader().getResource(movieFileName).getFile()), new TypeReference<List<MovieDTO>>() {});
        List<TrailerDTO> trailers = mapper.readValue(new File(getClass().getClassLoader().getResource(trailerFileName).getFile()), new TypeReference<List<TrailerDTO>>() {});
        for (ActorDTO actor : actors) {
            actorService.create(actor);
        }
        for (CategoryDTO category : categories) {
            categoryService.create(category);
        }
        for (MovieDTO movie : movies) {
            movieService.create(movie);
        }
        for (TrailerDTO trailer : trailers) {
            trailerService.create(trailer);
        }
    }
}
