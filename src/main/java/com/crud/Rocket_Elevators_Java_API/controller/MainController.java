package com.crud.Rocket_Elevators_Java_API.controller;

import com.crud.Rocket_Elevators_Java_API.models.Users;
import com.crud.Rocket_Elevators_Java_API.services.UsersService;

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
import com.crud.Rocket_Elevators_Java_API.exceptions.UsersNotFoundException;

// THIS IS USER CONTROLLER
@RestController // This means that this class is a RestController
@RequestMapping(path="/api") // This means URL's start with /api (after Application path)
public class MainController {
    UsersService usersService;
    @Autowired
    public MainController(UsersService usersService) {
        this.usersService = usersService;
    }
    @GetMapping(value="/users")
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }
    @GetMapping(value="/users/{id}")
    public Users getUsersById(@PathVariable("id") @Min(1) int id) {
        Users std = usersService.findById(id)
                .orElseThrow(()->new UsersNotFoundException("User with "+id+" is Not Found!"));
        return std;
    }
    @PostMapping(value="/users")
    public Users addUser(@Valid @RequestBody Users std) {
        return usersService.save(std);
    }
    @PutMapping(value="/users/{id}")
    public Users updateUsers(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Users newstd) {
        Users stdu = usersService.findById(id)
                .orElseThrow(()->new UsersNotFoundException("User with "+id+" is Not Found!"));
        stdu.setEmail(newstd.getEmail());
        return usersService.save(stdu);
    }
    @DeleteMapping(value="/users/{id}")
    public String deleteUsers(@PathVariable("id") @Min(1) int id) {
        Users std = usersService.findById(id)
                .orElseThrow(()->new UsersNotFoundException("User with "+id+" is Not Found!"));
        usersService.deleteById(std.getId());
        return "User with ID :"+id+" is deleted";
    }
}
