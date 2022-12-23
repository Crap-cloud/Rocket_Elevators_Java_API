package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.Rocket_Elevators_Java_API.models.Batteries;
import com.crud.Rocket_Elevators_Java_API.repo.BatteryRepo;
@Service
public class BatteriesService implements IBatteries {
    BatteryRepo batteryRepo;
    @Autowired
    public BatteriesService(BatteryRepo batteryRepo) {
        this.batteryRepo = batteryRepo;
    }
    @Override
    public List<Batteries> getAllBatteries() {
        // TODO Auto-generated method stub
        return (List<Batteries>) batteryRepo.findAll();
    }

    @Override
    public Optional<Batteries> findById(int id) {
        // TODO Auto-generated method stub
        return batteryRepo.findById(id);
    }
    @Override
    public Batteries save(Batteries std) {
        // TODO Auto-generated method stub
        return batteryRepo.save(std);
    }
    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        batteryRepo.deleteById(id);
    }
}

