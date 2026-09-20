package com.example.healthcare.People;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data 
@Entity 
public class PatientEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long pid;
    private String pname;
    private String paddress;
    private int pphone;
    
    
}
