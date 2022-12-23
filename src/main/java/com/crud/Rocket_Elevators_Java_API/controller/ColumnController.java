package com.crud.Rocket_Elevators_Java_API.controller;

import com.crud.Rocket_Elevators_Java_API.models.Columns;
import com.crud.Rocket_Elevators_Java_API.services.ColumnsService;

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
import com.crud.Rocket_Elevators_Java_API.exceptions.ColumnsNotFoundException;

@RestController // This means that this class is a RestController
@RequestMapping(path="/api") // This means URL's start with /api (after Application path)
public class ColumnController {
    ColumnsService ColumnsService;
    @Autowired
    public ColumnController(ColumnsService ColumnsService) {
        this.ColumnsService = ColumnsService;
    }
    @GetMapping(value="/columns")
    public List<Columns> getAllColumns(){
        return ColumnsService.getAllColumns();
    }
    @GetMapping(value="/columns/{id}")
    public Columns getColumnsById(@PathVariable("id") @Min(1) int id) {
        Columns std = ColumnsService.findById(id)
                .orElseThrow(()->new ColumnsNotFoundException("Column with "+id+" is Not Found!"));
        return std;
    }
    @PostMapping(value="/columns")
    public Columns addColumn(@Valid @RequestBody Columns std) {
        return ColumnsService.save(std);
    }
    @PutMapping(value="/columns/{id}")
    public Columns updateUsers(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Columns newstd) {
        Columns stdu = ColumnsService.findById(id)
                .orElseThrow(()->new ColumnsNotFoundException("Column with "+id+" is Not Found!"));
        return ColumnsService.save(stdu);
    }
    @DeleteMapping(value="/columns/{id}")
    public String deleteColumns(@PathVariable("id") @Min(1) int id) {
        Columns std = ColumnsService.findById(id)
                .orElseThrow(()->new ColumnsNotFoundException("Column with "+id+" is Not Found!"));
        ColumnsService.deleteById(std.getId());
        return "Column with ID :"+id+" is deleted";
    }
}