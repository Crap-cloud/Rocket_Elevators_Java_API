package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;
import com.crud.Rocket_Elevators_Java_API.models.Columns;

public interface IColumns {
    List<Columns> getAllColumns();
    Optional<Columns> findById(int id);
    Columns save(Columns std);
    void deleteById(int id);
}
