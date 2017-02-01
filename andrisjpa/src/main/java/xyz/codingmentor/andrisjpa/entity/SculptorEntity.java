package xyz.codingmentor.andrisjpa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import xyz.codingmentor.andrisjpa.enums.Sex;

/**
 *
 * @author brianelete
 */
@Entity
@IdClass(SculptorId.class)
@Table(name = "sculptor")
public class SculptorEntity implements Serializable {

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @Id
    private String name;
    private Sex sex;
    @OneToMany(mappedBy = "creator")
    private List<SculptureEntity> sculptures;
    @ManyToMany
    private List<WorkshopEntity> workshops;

    public SculptorEntity() {
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<SculptureEntity> getSculptures() {
        return sculptures;
    }

    public void setSculptures(List<SculptureEntity> sculptures) {
        this.sculptures = sculptures;
    }

    public List<WorkshopEntity> getWorkshops() {
        return workshops;
    }

    public void setWorkshops(List<WorkshopEntity> workshops) {
        this.workshops = workshops;
    }

}
