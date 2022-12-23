package com.crud.Rocket_Elevators_Java_API.controller;

import com.crud.Rocket_Elevators_Java_API.models.Buildings;
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
    BuildingsService BuildingsService;
    @Autowired
    public BuildingController(BuildingsService BuildingsService) {
        this.BuildingsService = BuildingsService;
    }
    @GetMapping(value="/buildings")
    public List<Buildings> getAllBuildings(){
        return BuildingsService.getAllBuildings();
    }
    @GetMapping(value="/buildings/{id}")
    public Buildings getBuildingsById(@PathVariable("id") @Min(1) int id) {
        Buildings std = BuildingsService.findById(id)
                .orElseThrow(()->new BuildingsNotFoundException("Building with "+id+" is Not Found!"));
        return std;
    }
    @PostMapping(value="/buildings")
    public Buildings addBuilding(@Valid @RequestBody Buildings std) {
        return BuildingsService.save(std);
    }
    @PutMapping(value="/buildings/{id}")
    public Buildings updateUsers(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Buildings newstd) {
        Buildings stdu = BuildingsService.findById(id)
                .orElseThrow(()->new BuildingsNotFoundException("Building with "+id+" is Not Found!"));
        return BuildingsService.save(stdu);
    }
    @DeleteMapping(value="/buildings/{id}")
    public String deleteBuildings(@PathVariable("id") @Min(1) int id) {
        Buildings std = BuildingsService.findById(id)
                .orElseThrow(()->new BuildingsNotFoundException("Building with "+id+" is Not Found!"));
        BuildingsService.deleteById(std.getId());
        return "Buildings with ID :"+id+" is deleted";
    }
}

