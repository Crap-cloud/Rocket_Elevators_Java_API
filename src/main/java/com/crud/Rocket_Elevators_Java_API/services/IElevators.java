package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;
import com.crud.Rocket_Elevators_Java_API.models.Elevators;

public interface IElevators {
    List<Elevators> getAllElevators();
    Optional<Elevators> findById(int id);
    Elevators save(Elevators std);
    void deleteById(int id);
}
