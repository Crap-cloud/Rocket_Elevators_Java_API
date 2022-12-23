package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;
import com.crud.Rocket_Elevators_Java_API.models.Battery;

public interface IBatteries {
    List<Battery> getAllBatteries();
    Optional<Battery> findById(int id);
    Battery save(Battery std);
    void deleteById(int id);
}
