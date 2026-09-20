package com.example.healthcare.Imaging;

import java.sql.Date;

import com.example.healthcare.People.PatientEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data 
@Entity 
public class ImageEntity {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageid;

    private String imagename;
    private double imagecost;
    private String imagedetails;
}
