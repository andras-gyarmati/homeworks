package xyz.codingmentor.andrisjpa.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import xyz.codingmentor.andrisjpa.enums.Material;

/**
 *
 * @author brianelete
 */
@Entity
@Table(name = "workshop")
public class WorkshopEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Material material;
    @Embedded
    private Address address;
    @ManyToMany(mappedBy = "workshops")
    private List<SculptorEntity> sculptors;

    public WorkshopEntity() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<SculptorEntity> getSculptors() {
        return sculptors;
    }

    public void setSculptors(List<SculptorEntity> sculptors) {
        this.sculptors = sculptors;
    }

}
