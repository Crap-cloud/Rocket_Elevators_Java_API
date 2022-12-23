package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;
import com.crud.Rocket_Elevators_Java_API.models.Buildings;

public interface IBuildings {
    List<Buildings> getAllBuildings();
    Optional<Buildings> findById(int id);
    Buildings save(Buildings std);
    void deleteById(int id);
}
