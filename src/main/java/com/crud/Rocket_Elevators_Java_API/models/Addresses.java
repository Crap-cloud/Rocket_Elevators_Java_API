package com.crud.Rocket_Elevators_Java_API.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "buildings")
public class Addresses implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "type_address")
    private String type_address;
    @Column(name = "status")
    private String status;
    @Column(name = "entity")
    private String entity;
    @Column(name = "number_and_street")
    private String number_and_street;
    @Column(name = "suit_or_apartment")
    private String suit_or_apartment;
    @Column(name = "city")
    private String city;
    @Column(name = "postal_code")
    private String postal_code;
    @Column(name = "country")
    private String country;
    @Column(name = "notes")
    private String notes;
    @Column(name = "latitude")
    private DecimalFormat latitude;
    @Column(name = "longitude")
    private DecimalFormat longitude;
    @Column(name = "created_at")
    private LocalDateTime created_at;
    @Column(name = "updated_at")
    private LocalDateTime updated_at;


    //  Relations between tables
    @OneToMany(mappedBy = "addresses")
    private List<Building> buildings = new ArrayList();
}

