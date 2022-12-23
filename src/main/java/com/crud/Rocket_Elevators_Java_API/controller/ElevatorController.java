package com.crud.Rocket_Elevators_Java_API.controller;

import com.crud.Rocket_Elevators_Java_API.models.Elevators;
import com.crud.Rocket_Elevators_Java_API.services.ElevatorsService;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.Rocket_Elevators_Java_API.exceptions.ElevatorsNotFoundException;

@RestController // This means that this class is a RestController
@RequestMapping(path="/api") // This means URL's start with /api (after Application path)
public class ElevatorController {
    ElevatorsService ElevatorsService;
    @Autowired
    public ElevatorController(ElevatorsService ElevatorsService) {
        this.ElevatorsService = ElevatorsService;
    }
    @GetMapping(value="/elevators")
    public List<Elevators> getAllElevators(){
        return ElevatorsService.getAllElevators();
    }
    @GetMapping(value="/elevators/{id}")
    public Elevators getElevatorsById(@PathVariable("id") @Min(1) int id) {
        Elevators std = ElevatorsService.findById(id)
                .orElseThrow(()->new ElevatorsNotFoundException("Elevator with "+id+" is Not Found!"));
        return std;
    }
    @PostMapping(value="/elevators")
    public Elevators addElevator(@Valid @RequestBody Elevators std) {
        return ElevatorsService.save(std);
    }
    @PutMapping(value="/elevators/{id}")
    public Elevators updateUsers(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Elevators newstd) {
        Elevators stdu = ElevatorsService.findById(id)
                .orElseThrow(()->new ElevatorsNotFoundException("Elevator with "+id+" is Not Found!"));
        return ElevatorsService.save(stdu);
    }
    @DeleteMapping(value="/elevators/{id}")
    public String deleteElevators(@PathVariable("id") @Min(1) int id) {
        Elevators std = ElevatorsService.findById(id)
                .orElseThrow(()->new ElevatorsNotFoundException("Elevator with "+id+" is Not Found!"));
        ElevatorsService.deleteById(std.getId());
        return "Elevator with ID :"+id+" is deleted";
    }
}
