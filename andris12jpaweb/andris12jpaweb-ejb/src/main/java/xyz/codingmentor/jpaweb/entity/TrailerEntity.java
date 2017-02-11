package xyz.codingmentor.jpaweb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import xyz.codingmentor.jpaweb.enum_.Platform;

/**
 *
 * @author brianelete
 */
@Entity
@Table(name = "trailer")
public class TrailerEntity implements Serializable {

    @Id
    private Long id;
    private String url;
    @Enumerated(EnumType.STRING)
    private Platform platform;
    private String title;
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private MovieEntity movie;

    public TrailerEntity() {
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

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

}
