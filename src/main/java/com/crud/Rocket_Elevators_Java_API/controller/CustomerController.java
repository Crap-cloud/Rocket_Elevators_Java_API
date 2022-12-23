package com.crud.Rocket_Elevators_Java_API.controller;

import com.crud.Rocket_Elevators_Java_API.models.Customers;
import com.crud.Rocket_Elevators_Java_API.services.CustomersService;

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
import com.crud.Rocket_Elevators_Java_API.exceptions.CustomersNotFoundException;

@RestController // This means that this class is a RestController
@RequestMapping(path="/api") // This means URL's start with /api (after Application path)
public class CustomerController {
    CustomersService CustomersService;
    @Autowired
    public CustomerController(CustomersService CustomersService) {
        this.CustomersService = CustomersService;
    }
    @GetMapping(value="/customers")
    public List<Customers> getAllCustomers(){
        return CustomersService.getAllCustomers();
    }
    @GetMapping(value="/customers/{id}")
    public Customers getCustomersById(@PathVariable("id") @Min(1) int id) {
        Customers std = CustomersService.findById(id)
                .orElseThrow(()->new CustomersNotFoundException("Customer with "+id+" is Not Found!"));
        return std;
    }
    @PostMapping(value="/customer")
    public Customers addCustomer(@Valid @RequestBody Customers std) {
        return CustomersService.save(std);
    }
    @PutMapping(value="/customers/{id}")
    public Customers updateUsers(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Customers newstd) {
        Customers stdu = CustomersService.findById(id)
                .orElseThrow(()->new CustomersNotFoundException("Customer with "+id+" is Not Found!"));
        return CustomersService.save(stdu);
    }
    @DeleteMapping(value="/customers/{id}")
    public String deleteCustomers(@PathVariable("id") @Min(1) int id) {
        Customers std = CustomersService.findById(id)
                .orElseThrow(()->new CustomersNotFoundException("Customer with "+id+" is Not Found!"));
        CustomersService.deleteById(std.getId());
        return "Customer with ID :"+id+" is deleted";
    }
}
