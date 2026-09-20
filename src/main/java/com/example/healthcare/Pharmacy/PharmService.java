package com.example.healthcare.Pharmacy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthcare.Laboratory.LabEntity;

@Service 
public class PharmService {
    
    @Autowired 
    PharmRepository repository;

    public void createMedicine(PharmEntity entity){
        repository.save(entity);
    }

    public List<PharmEntity> showAllMedicine(){
        return repository.findAll();
    }

    public Optional<PharmEntity> showMedicineById(Long id){
        return repository.findById(id);
    }
}
