package com.crud.Rocket_Elevators_Java_API.controller;

import com.crud.Rocket_Elevators_Java_API.models.Interventions;
import com.crud.Rocket_Elevators_Java_API.services.InterventionsService;

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
import com.crud.Rocket_Elevators_Java_API.exceptions.InterventionsNotFoundException;

@RestController // This means that this class is a RestController
@RequestMapping(path="/api") // This means URL's start with /api (after Application path)
public class InterventionController {
    InterventionsService InterventionsService;
    @Autowired
    public InterventionController(InterventionsService InterventionsService) {
        this.InterventionsService = InterventionsService;
    }
    @GetMapping(value="/interventions")
    public List<Interventions> getAllInterventions(){
        return InterventionsService.getAllInterventions();
    }
    @GetMapping(value="/interventions/{id}")
    public Interventions getInterventionsById(@PathVariable("id") @Min(1) int id) {
        Interventions std = InterventionsService.findById(id)
                .orElseThrow(()->new InterventionsNotFoundException("Intervention with "+id+" is Not Found!"));
        return std;
    }
    @PostMapping(value="/interventions/new")
    public Interventions addIntervention(@Valid @RequestBody Interventions std) {
        return InterventionsService.save(std);
    }
    @PutMapping(value="/interventions/update/{id}")
    public Interventions updateUsers(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Interventions newstd) {
        Interventions stdu = InterventionsService.findById(id)
                .orElseThrow(()->new InterventionsNotFoundException("Intervention with "+id+" is Not Found!"));
        return InterventionsService.save(stdu);
    }
    @DeleteMapping(value="/interventions/delete/{id}")
    public String deleteInterventions(@PathVariable("id") @Min(1) int id) {
        Interventions std = InterventionsService.findById(id)
                .orElseThrow(()->new InterventionsNotFoundException("Intervention with "+id+" is Not Found!"));
        InterventionsService.deleteById(std.getId());
        return "Intervention with ID :"+id+" is deleted";
    }
}
