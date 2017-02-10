package xyz.codingmentor.andrisjpa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import xyz.codingmentor.andrisjpa.enums.Material;

/**
 *
 * @author brianelete
 */
@Entity
@Table(name = "sculpture")
public class SculptureEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Material material;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @ManyToOne
    private SculptorEntity creator;

    public SculptureEntity() {
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

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public SculptorEntity getCreator() {
        return creator;
    }

    public void setCreator(SculptorEntity creator) {
        this.creator = creator;
    }

}
