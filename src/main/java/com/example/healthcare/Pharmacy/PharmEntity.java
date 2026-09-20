package com.example.healthcare.Pharmacy;

import com.example.healthcare.People.PatientEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data 
@Entity 
public class PharmEntity {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineid;

    private String medicinename;
    private double medicinecost;
    private String medicinecompany;
    private String medicinedetails;
}
