package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;
import com.crud.Rocket_Elevators_Java_API.models.Building;

public interface IBuildings {
    List<Building> getAllBuildings();
    Optional<Building> findById(int id);
    Building save(Building std);
    void deleteById(int id);
}
