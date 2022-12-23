package com.crud.Rocket_Elevators_Java_API.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.Rocket_Elevators_Java_API.models.Columns;
import com.crud.Rocket_Elevators_Java_API.repo.ColumnRepo;
@Service
public class ColumnsService implements IColumns {
    ColumnRepo columnRepo;
    @Autowired
    public ColumnsService(ColumnRepo columnRepo) {
        this.columnRepo = columnRepo;
    }
    @Override
    public List<Columns> getAllColumns() {
        // TODO Auto-generated method stub
        return (List<Columns>) columnRepo.findAll();
    }

    @Override
    public Optional<Columns> findById(int id) {
        // TODO Auto-generated method stub
        return columnRepo.findById(id);
    }
    @Override
    public Columns save(Columns std) {
        // TODO Auto-generated method stub
        return columnRepo.save(std);
    }
    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        columnRepo.deleteById(id);
    }
}
