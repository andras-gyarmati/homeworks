package xyz.codingmentor.jpaweb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author brianelete
 */
@Entity
@Table(name = "category")
public class CategoryEntity implements Serializable {

    @Id
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    @XmlTransient
    private List<MovieEntity> movies;

    public CategoryEntity() {
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

    public List<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }
    
    
}
