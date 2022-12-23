package com.crud.Rocket_Elevators_Java_API.repo;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.crud.Rocket_Elevators_Java_API.models.Building;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface BuildingRepo extends CrudRepository<Building, Integer> {

}
