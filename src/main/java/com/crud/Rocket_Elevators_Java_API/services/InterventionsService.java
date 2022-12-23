package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.Rocket_Elevators_Java_API.models.Interventions;
import com.crud.Rocket_Elevators_Java_API.repo.InterventionRepo;
@Service
public class InterventionsService implements IInterventions {
    InterventionRepo interventionRepo;
    @Autowired
    public InterventionsService(InterventionRepo interventionRepo) {
        this.interventionRepo = interventionRepo;
    }
    @Override
    public List<Interventions> getAllInterventions() {
        // TODO Auto-generated method stub
        return (List<Interventions>) interventionRepo.findAll();
    }

    @Override
    public Optional<Interventions> findById(int id) {
        // TODO Auto-generated method stub
        return interventionRepo.findById(id);
    }
    @Override
    public Interventions save(Interventions std) {
        // TODO Auto-generated method stub
        return interventionRepo.save(std);
    }
    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        interventionRepo.deleteById(id);
    }
}