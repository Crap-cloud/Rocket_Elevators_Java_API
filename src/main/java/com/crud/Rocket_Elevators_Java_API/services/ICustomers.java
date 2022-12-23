package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;
import com.crud.Rocket_Elevators_Java_API.models.Customers;

public interface ICustomers {
    List<Customers> getAllCustomers();
    Optional<Customers> findById(int id);
    Customers save(Customers std);
    void deleteById(int id);
}
