package com.example.healthcare.Discharge;

import com.example.healthcare.Appointment.AppointmentEntity;
import com.example.healthcare.Imaging.ImageEntity;
import com.example.healthcare.Laboratory.LabEntity;
import com.example.healthcare.People.DoctorEntity;
import com.example.healthcare.People.PatientEntity;
import com.example.healthcare.Pharmacy.PharmEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data 
@Entity 
public class DischargeEntity {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dischargeid;

    
    private Long doctorid;

    private Long patientid;

    private double totalbill;

    private Long appointmentid;
    
    private Long imageid;
    
    private Long testid;

    private Long medicineid;


    
}


