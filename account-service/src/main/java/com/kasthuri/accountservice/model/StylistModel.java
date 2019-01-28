package com.kasthuri.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StylistModel {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String stylistId;
    private String email;
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
}
