package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;
import com.crud.Rocket_Elevators_Java_API.models.Batteries;

public interface IBatteries {
    List<Batteries> getAllBatteries();
    Optional<Batteries> findById(int id);
    Batteries save(Batteries std);
    void deleteById(int id);
}
