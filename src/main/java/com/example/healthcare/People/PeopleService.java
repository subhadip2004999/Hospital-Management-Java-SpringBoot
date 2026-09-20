package com.example.healthcare.People;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class PeopleService {
    
    @Autowired 
    DoctorRepositoty dRepositoty;

    @Autowired 
    PatientRepository pRepository;

    public void addPatient(PatientEntity eitity){
        pRepository.save(eitity);
    }

    public void addDoctor(DoctorEntity entity){
        dRepositoty.save(entity);
    }

    public List<PatientEntity> showPatients(){
        return pRepository.findAll();
    }

    public List<DoctorEntity> showDoctors(){
        return dRepositoty.findAll();
    }

    public Optional<PatientEntity> findPatientById(Long id){
        return pRepository.findById(id);

    }

}
