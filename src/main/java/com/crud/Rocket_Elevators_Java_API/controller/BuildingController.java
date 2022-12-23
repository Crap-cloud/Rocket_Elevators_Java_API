package com.crud.Rocket_Elevators_Java_API.controller;

import com.crud.Rocket_Elevators_Java_API.models.Building;
import com.crud.Rocket_Elevators_Java_API.services.BuildingsService;

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
import com.crud.Rocket_Elevators_Java_API.exceptions.BuildingsNotFoundException;

@RestController // This means that this class is a RestController
@RequestMapping(path="/api") // This means URL's start with /api (after Application path)
public class BuildingController {
    BuildingsService buildingsService;
    @Autowired
    public BuildingController(BuildingsService buildingsService) {
        this.buildingsService = buildingsService;
    }
    @GetMapping(value="/buildings")
    public List<Building> getAllBuildings(){
        return buildingsService.getAllBuildings();
    }
    @GetMapping(value="/buildings/{id}")
    public Building getBuildingsById(@PathVariable("id") @Min(1) int id) {
        Building std = buildingsService.findById(id)
                .orElseThrow(()->new BuildingsNotFoundException("Building with "+id+" is Not Found!"));
        return std;
    }
    @PostMapping(value="/buildings")
    public Building addBuilding(@Valid @RequestBody Building std) {
        return buildingsService.save(std);
    }
    @PutMapping(value="/buildings/{id}")
    public Building updateUsers(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Building newstd) {
        Building stdu = buildingsService.findById(id)
                .orElseThrow(()->new BuildingsNotFoundException("Building with "+id+" is Not Found!"));
        return buildingsService.save(stdu);
    }
    @DeleteMapping(value="/buildings/{id}")
    public String deleteBuildings(@PathVariable("id") @Min(1) int id) {
        Building std = buildingsService.findById(id)
                .orElseThrow(()->new BuildingsNotFoundException("Building with "+id+" is Not Found!"));
        buildingsService.deleteById(std.getId());
        return "Building with ID :"+id+" is deleted";
    }
}

