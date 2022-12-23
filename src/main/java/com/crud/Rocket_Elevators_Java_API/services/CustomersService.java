package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.Rocket_Elevators_Java_API.models.Customers;
import com.crud.Rocket_Elevators_Java_API.repo.CustomerRepo;
@Service
public class CustomersService implements ICustomers {
    CustomerRepo customerRepo;
    @Autowired
    public CustomersService(CustomerRepo customerRepo) {this.customerRepo = customerRepo;}
    @Override
    public List<Customers> getAllCustomers() {
        // TODO Auto-generated method stub
        return (List<Customers>) customerRepo.findAll();
    }

    @Override
    public Optional<Customers> findById(int id) {
        // TODO Auto-generated method stub
        return customerRepo.findById(id);
    }
    @Override
    public Customers save(Customers std) {
        // TODO Auto-generated method stub
        return customerRepo.save(std);
    }
    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        customerRepo.deleteById(id);
    }
}
