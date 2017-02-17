package xyz.codingmentor.jpaweb.dto;

import java.util.List;

/**
 *
 * @author brianelete
 */
public class CategoryDTO {

    private Long id;
    private String name;
    private List<Long> movies;

    public CategoryDTO() {
        //empty
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getMovies() {
        return movies;
    }

    public void setMovies(List<Long> movies) {
        this.movies = movies;
    }
    
}
