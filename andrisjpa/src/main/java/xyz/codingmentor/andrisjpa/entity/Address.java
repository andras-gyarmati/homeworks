package xyz.codingmentor.andrisjpa.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author brianelete
 */
@Embeddable
public class Address implements Serializable {

    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String country;

    public Address() {
        //empty
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
