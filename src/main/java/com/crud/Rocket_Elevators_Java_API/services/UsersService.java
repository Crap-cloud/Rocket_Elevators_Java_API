package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.Rocket_Elevators_Java_API.models.Users;
import com.crud.Rocket_Elevators_Java_API.repo.UserRepo;
@Service
public class UsersService implements IUsers {
    UserRepo userRepo;
    @Autowired
    public UsersService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public List<Users> getAllUsers() {
        // TODO Auto-generated method stub
        return (List<Users>) userRepo.findAll();
    }

    @Override
    public Optional<Users> findById(int id) {
        // TODO Auto-generated method stub
        return userRepo.findById(id);
    }
    @Override
    public Optional<Users> findByEmail(String email) {
        // TODO Auto-generated method stub
        return userRepo.findByEmail(email);
    }
    @Override
    public Users save(Users std) {
        // TODO Auto-generated method stub
        return userRepo.save(std);
    }
    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        userRepo.deleteById(id);
    }
}
