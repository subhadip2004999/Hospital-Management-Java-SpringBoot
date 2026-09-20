package com.example.healthcare.Appointment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping ("/appointment")
public class AppointmentController {

    @Autowired 
    AppointmentService service;
    
    @GetMapping("/appointmentbyid")
    public Optional<AppointmentEntity> getAppointmentById(@RequestParam Long id) {
        return service.showAppointmentById(id);
    }

    @GetMapping("/allappointments")
    public List<AppointmentEntity> getMethodName() {
        return service.showAllAppointments();
    }

    @PostMapping("/bookappointment")
    public void postMethodName(@RequestBody AppointmentEntity entity) {
        service.addAppointment(entity);
    }
    
    
    
}
