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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "batteries")
public class Battery implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "battery_type")
    private String battery_type;
    @Column(name = "status")
    private String status;
    @Column(name = "date_commissioning")
    private LocalDateTime date_commissioning;
    @Column(name = "date_last_inspection")
    private LocalDateTime date_last_inspection;
    @Column(name = "certificate_operations")
    private String certificate_operations;
    @Column(name = "information")
    private String information;
    @Column(name = "notes")
    private String notes;
    @Column(name = "created_at")
    private LocalDateTime created_at;
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    //  Relations between tables
    @ManyToOne
    @JoinColumn(name="building_id")
    @JsonIgnore
    private Building buildings;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employees employees;
    @OneToMany(mappedBy = "batteries", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Columns> columns = new ArrayList();
    @OneToMany(mappedBy = "batteries", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Interventions> interventions = new ArrayList();
}