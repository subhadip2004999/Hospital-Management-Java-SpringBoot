package com.example.healthcare.Appointment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class AppointmentService {

    @Autowired 
    AppointmentRepository repository;

    public void addAppointment(AppointmentEntity entity){
        repository.save(entity);
    }
    
    public Optional<AppointmentEntity> showAppointmentById(Long id){
        return repository.findById(id);
    }

    public List<AppointmentEntity> showAllAppointments(){
        return repository.findAll();
        
    }
}
