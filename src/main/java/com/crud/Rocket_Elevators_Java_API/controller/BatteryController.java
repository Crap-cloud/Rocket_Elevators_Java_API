package com.crud.Rocket_Elevators_Java_API.controller;

import com.crud.Rocket_Elevators_Java_API.models.Batteries;
import com.crud.Rocket_Elevators_Java_API.services.BatteriesService;

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
import com.crud.Rocket_Elevators_Java_API.exceptions.BatteriesNotFoundException;

@RestController // This means that this class is a RestController
@RequestMapping(path="/api") // This means URL's start with /api (after Application path)
public class BatteryController {
    BatteriesService batteriesService;
    @Autowired
    public BatteryController(BatteriesService batteriesServiceS) {
        this.batteriesService = batteriesServiceS;
    }
    @GetMapping(value="/batteries")
    public List<Batteries> getAllBatteries(){
        return batteriesService.getAllBatteries();
    }
    @GetMapping(value="/batteries/{id}")
    public Batteries getBatteriesById(@PathVariable("id") @Min(1) int id) {
        Batteries std = batteriesService.findById(id)
                .orElseThrow(()->new BatteriesNotFoundException("Battery with "+id+" is Not Found!"));
        return std;
    }
    @PostMapping(value="/batteries")
    public Batteries addBattery(@Valid @RequestBody Batteries std) {
        return batteriesService.save(std);
    }
    @PutMapping(value="/batteries/{id}")
    public Batteries updateUsers(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Batteries newstd) {
        Batteries stdu = batteriesService.findById(id)
                .orElseThrow(()->new BatteriesNotFoundException("Battery with "+id+" is Not Found!"));
        return batteriesService.save(stdu);
    }
    @DeleteMapping(value="/batteries/{id}")
    public String deleteBatteries(@PathVariable("id") @Min(1) int id) {
        Batteries std = batteriesService.findById(id)
                .orElseThrow(()->new BatteriesNotFoundException("Battery with "+id+" is Not Found!"));
        batteriesService.deleteById(std.getId());
        return "Batteries with ID :"+id+" is deleted";
    }
}
