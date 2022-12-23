package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.Rocket_Elevators_Java_API.models.Buildings;
import com.crud.Rocket_Elevators_Java_API.repo.BuildingRepo;
@Service
public class BuildingsService implements IBuildings {
    BuildingRepo buildingRepo;
    @Autowired
    public BuildingsService(BuildingRepo buildingRepo) {
        this.buildingRepo = buildingRepo;
    }
    @Override
    public List<Buildings> getAllBuildings() {
        // TODO Auto-generated method stub
        return (List<Buildings>) buildingRepo.findAll();
    }

    @Override
    public Optional<Buildings> findById(int id) {
        // TODO Auto-generated method stub
        return buildingRepo.findById(id);
    }
    @Override
    public Buildings save(Buildings std) {
        // TODO Auto-generated method stub
        return buildingRepo.save(std);
    }
    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        buildingRepo.deleteById(id);
    }
}

