package xyz.codingmentor.jpaweb.dto;

import java.util.List;

/**
 *
 * @author brianelete
 */
public class MovieDTO {

    private Long id;
    private String title;
    private List<Long> actors;
    private List<Long> trailers;
    private Long categoryId;

    public MovieDTO() {
        //empty
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Long> getActors() {
        return actors;
    }

    public void setActors(List<Long> actors) {
        this.actors = actors;
    }

    public List<Long> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Long> trailers) {
        this.trailers = trailers;
    }

    public Long getCategory() {
        return categoryId;
    }

    public void setCategory(Long categoryId) {
        this.categoryId = categoryId;
    }
    
}
