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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "elevators")
public class Elevators implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "serial_nb")
    private Integer serial_nb;
    @Column(name = "elevator_type")
    private String elevator_type;
    @Column(name = "elevator_status")
    private String elevator_status;
    @Column(name = "date_commissioning")
    private LocalDateTime date_commissioning;
    @Column(name = "date_last_inspection")
    private LocalDateTime date_last_inspection;
    @Column(name = "certificate_inspection")
    private String certificate_inspection;
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
    @JoinColumn(name = "column_id")
    @JsonIgnore
    private Columns columns;
    @OneToMany(mappedBy = "elevators", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Interventions> interventions = new ArrayList();
}
