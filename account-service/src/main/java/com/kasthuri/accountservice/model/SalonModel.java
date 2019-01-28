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
public class SalonModel {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String salonId;
    private String email;
    private String salonName;
    private String ownerName;
    private String country;
    private String state;
    private String city;
    private String street;
    private int zip;
    private String telephoneNo;
    private String tagLine;
    private String website;
}

