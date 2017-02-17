package xyz.codingmentor.jpaweb.dto;

import java.util.Date;
import xyz.codingmentor.jpaweb.enums.Platform;

/**
 *
 * @author brianelete
 */
    public class TrailerDTO {

    private Long id;
    private String url;
    private Platform platform;
    private String title;
    private Date releaseDate;
    private Long movieId;

    public TrailerDTO() {
        //empty
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getMovie() {
        return movieId;
    }

    public void setMovie(Long movieId) {
        this.movieId = movieId;
    }

}
