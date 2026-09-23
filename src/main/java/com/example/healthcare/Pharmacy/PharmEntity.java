package com.example.healthcare.Pharmacy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
