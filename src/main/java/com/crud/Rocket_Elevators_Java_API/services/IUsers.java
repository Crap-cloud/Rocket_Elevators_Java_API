package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;
import com.crud.Rocket_Elevators_Java_API.models.Users;

public interface IUsers {
    List<Users> getAllUsers();
    Optional<Users> findById(int id);
    Optional<Users> findByEmail(String email);
    Users save(Users std);
    void deleteById(int id);
}
