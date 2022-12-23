package com.crud.Rocket_Elevators_Java_API.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

// This tells Hibernate to make a table out of this class
@Getter
@Setter
@Entity
@Table(name="buildings")
public class Buildings implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "addressBuilding")
    private String addressBuilding;
    @Column(name = "FullNameBuildingAdmin")
    private String FullNameBuildingAdmin;
    @Column(name = "EmailAdminBuilding")
    private String EmailAdminBuilding;
    @Column(name = "PhoneNumberBuildingAdmin")
    private String PhoneNumberBuildingAdmin;
    @Column(name = "FullNameTechContact")
    private String FullNameTechContact;
    @Column(name = "TechContactEmail")
    private String TechContactEmail;
    @Column(name = "TechContactPhone")
    private String TechContactPhone;
    @Column(name = "created_at")
    private LocalDateTime created_at;
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    //  Relations between tables
//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    @JsonIgnore
//    private Customers customers;
//    @ManyToOne
//    @JoinColumn(name = "address_id")
//    @JsonIgnore
//    private Addresses address_id;
//    @OneToMany(mappedBy = "buildings", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Battery> battery_id= new ArrayList();
//    @OneToMany(mappedBy = "buildings", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Interventions> interventions = new ArrayList();
}
