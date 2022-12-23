package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.Rocket_Elevators_Java_API.models.Elevators;
import com.crud.Rocket_Elevators_Java_API.repo.ElevatorRepo;
@Service
public class ElevatorsService implements IElevators {
    ElevatorRepo elevatorRepo;
    @Autowired
    public ElevatorsService(ElevatorRepo elevatorRepo) {
        this.elevatorRepo = elevatorRepo;
    }
    @Override
    public List<Elevators> getAllElevators() {
        // TODO Auto-generated method stub
        return (List<Elevators>) elevatorRepo.findAll();
    }

    @Override
    public Optional<Elevators> findById(int id) {
        // TODO Auto-generated method stub
        return elevatorRepo.findById(id);
    }
    @Override
    public Elevators save(Elevators std) {
        // TODO Auto-generated method stub
        return elevatorRepo.save(std);
    }
    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        elevatorRepo.deleteById(id);
    }
}
