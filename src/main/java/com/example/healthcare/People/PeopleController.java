package com.example.healthcare.People;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/admin")
public class PeopleController {

    @Autowired
    PeopleService service;
    
    @GetMapping("/patientbyid")
    public Optional<PatientEntity> getPatientById(@RequestParam Long id) {
        return service.findPatientById(id);
    }
    
    @GetMapping("/allpatients")
    public List<PatientEntity> getPatientsTable() {
        return service.showPatients();
    }

    @GetMapping("/alldoctors")
    public List<DoctorEntity> getDoctorsTable() {
        return service.showDoctors();
    }
    
    
    @PostMapping("/addpatient")
    public void postPatient(@RequestBody PatientEntity entity) {
        service.addPatient(entity);
    }
    
    @PostMapping("/adddoctor")
    public void postDoctor(@RequestBody DoctorEntity entity) {
        service.addDoctor(entity);
    }
    

}
