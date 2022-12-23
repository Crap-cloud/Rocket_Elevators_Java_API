package com.crud.Rocket_Elevators_Java_API.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.time.LocalDate;
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
@Table(name = "customers")
public class Customers implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "CustomerCreationDate")
    private LocalDate CustomerCreationDate;
    @Column(name = "CompanyName")
    private String CompanyName;
    @Column(name = "CompanyHeadquarterAdress")
    private String CompanyHeadquarterAdress;
    @Column(name = "FullNameCompanyContact")
    private String FullNameCompanyContact;
    @Column(name = "cCompanyContactPhone")
    private String CompanyContactPhone;
    @Column(name = "EmailCompanyContact")
    private String EmailCompanyContact;
    @Column(name = "CompanyDescription")
    private String CompanyDescription;
    @Column(name = "FullNameServiceTechnicalAuth")
    private String FullNameServiceTechnicalAuth;
    @Column(name = "TechnicalAuthorityPhoneService")
    private String TechnicalAuthorityPhoneService;
    @Column(name = "TechnicalManagerEmailService")
    private String TechnicalManagerEmailService;
    @Column(name = "created_at")
    private LocalDateTime created_at;
    @Column(name = "updated_at")
    private LocalDateTime updated_at;


    //  Relations between tables
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users users;
    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Building> buildings = new ArrayList();
    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Interventions> interventions = new ArrayList();
}
