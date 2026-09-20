package com.example.healthcare.People;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity 
public class DoctorEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long did;
    
    private String dname;
    private String dspecialization;
    private int dphone;
    private double dfees;
    
}
