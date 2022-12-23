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
@Table(name = "columns")
public class Columns implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "column_type")
    private String column_type;
    @Column(name = "served_floors_nb")
    private Integer served_floors_nb;
    @Column(name = "status")
    private String status;
    @Column(name = "information")
    private String information;
    @Column(name = "notes")
    private String notes;


    //  Relations between tables
//    @ManyToOne
//    @JoinColumn(name = "battery_id")
//    @JsonIgnore
//    private Battery batteries;
//    @OneToMany(mappedBy = "columns", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Elevators> elevators = new ArrayList();
//    @OneToMany(mappedBy = "columns", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Interventions> interventions = new ArrayList();
}
