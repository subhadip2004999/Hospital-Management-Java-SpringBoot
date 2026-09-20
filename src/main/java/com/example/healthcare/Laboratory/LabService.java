package com.example.healthcare.Laboratory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aj.org.objectweb.asm.Label;

@Service 
public class LabService {
    
    @Autowired 
    LabRepository repository;

    public void createTest(LabEntity entity){
        repository.save(entity);
    }

    public List<LabEntity> showAllTest(){
        return repository.findAll();
    }

    public Optional<LabEntity> showTestById(Long id){
        return repository.findById(id);
    }
}
