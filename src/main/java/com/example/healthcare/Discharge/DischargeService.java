package com.example.healthcare.Discharge;

import java.util.List;
import java.util.Optional;

import com.example.healthcare.Appointment.AppointmentEntity;
import com.example.healthcare.Imaging.ImageEntity;
import com.example.healthcare.Laboratory.LabEntity;
import com.example.healthcare.People.PatientEntity;
import com.example.healthcare.Pharmacy.PharmEntity;

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
