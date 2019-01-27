package com.kasthuri.accountservice.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class StylistModel {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String stylistId;
    private String firstName;
    private String lastName;
    private String country;
    private String state;
    private String city;
    private String street;
    private int zip;
    private String telephoneNumber;
    private String linkedin;
    private String skill;
    private String rate;
    private String tagline;
    private String description;
    private String experience;


    public StylistModel() {
    }

    public StylistModel(String firstName, String lastName, String country, String state, String city,
                        String street, int zip, String telephoneNumber, String linkedin, String skill,
                        String rate, String tagline, String description, String experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.telephoneNumber = telephoneNumber;
        this.linkedin = linkedin;
        this.skill = skill;
        this.rate = rate;
        this.tagline = tagline;
        this.description = description;
        this.experience = experience;
    }

    public String getStylistId() {
        return stylistId;
    }

    public void setStylistId(String stylistId) {
        this.stylistId = stylistId;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
