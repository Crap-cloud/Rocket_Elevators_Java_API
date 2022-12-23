package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;
import com.crud.Rocket_Elevators_Java_API.models.Interventions;

public interface IInterventions {
    List<Interventions> getAllInterventions();
    Optional<Interventions> findById(int id);
    Interventions save(Interventions std);
    void deleteById(int id);
}
