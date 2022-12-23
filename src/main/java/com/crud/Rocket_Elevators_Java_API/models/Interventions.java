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

@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "interventions")
public class Interventions implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "author")
    private String author;
    @Column(name = "intervention_begin")
    private LocalDateTime intervention_begin;
    @Column(name = "intervention_end")
    private LocalDateTime intervention_end;
    @Column(name = "result")
    private String result;
    @Column(name = "report")
    private String report;
    @Column(name = "status")
    private String status;
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
//    @JoinColumn(name = "building_id")
//    @JsonIgnore
//    private Building buildings;
//    @ManyToOne
//    @JoinColumn(name = "battery_id")
//    @JsonIgnore
//    private Battery batteries;
//    @ManyToOne
//    @JoinColumn(name = "column_id")
//    @JsonIgnore
//    private Columns columns;
//    @ManyToOne
//    @JoinColumn(name = "elevator_id")
//    @JsonIgnore
//    private Elevators elevators;
//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    @JsonIgnore
//    private Employees employees;
}
