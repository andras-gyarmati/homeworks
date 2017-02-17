package xyz.codingmentor.jpaweb.dto;

import java.util.List;

/**
 *
 * @author brianelete
 */
public class ActorDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String nationality;
    private List<Long> movies;

    public ActorDTO() {
        //empty
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Long> getMovies() {
        return movies;
    }

    public void setMovies(List<Long> movies) {
        this.movies = movies;
    }

}
