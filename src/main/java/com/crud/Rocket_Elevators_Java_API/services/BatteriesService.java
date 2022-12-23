package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.Rocket_Elevators_Java_API.models.Battery;
import com.crud.Rocket_Elevators_Java_API.repo.BatteryRepo;
@Service
public class BatteriesService implements IBatteries {
    BatteryRepo batteryRepo;
    @Autowired
    public BatteriesService(BatteryRepo batteryRepo) {
        this.batteryRepo = batteryRepo;
    }
    @Override
    public List<Battery> getAllBatteries() {
        // TODO Auto-generated method stub
        return (List<Battery>) batteryRepo.findAll();
    }

    @Override
    public Optional<Battery> findById(int id) {
        // TODO Auto-generated method stub
        return batteryRepo.findById(id);
    }
    @Override
    public Battery save(Battery std) {
        // TODO Auto-generated method stub
        return batteryRepo.save(std);
    }
    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        batteryRepo.deleteById(id);
    }
}

