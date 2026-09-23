package com.example.healthcare.Discharge;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class DischargeService {
    
    @Autowired 
    DischargeRepository repository;
    DischargeEntity dentity;

    public void createDischargeForm(DischargeEntity entity){
        dentity.setTotal(dentity.getTotalBill());
        repository.save(entity);
    }

    public List<DischargeEntity> showAllDischargeForm(){
        return repository.findAll();
    }

    public Optional<DischargeEntity> showDischargeFormById(Long id){
        return repository.findById(id);
    }
       
    
}
