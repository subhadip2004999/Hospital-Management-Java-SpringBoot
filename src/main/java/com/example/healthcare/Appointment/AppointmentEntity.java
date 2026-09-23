package com.example.healthcare.Appointment;
import java.sql.Date;

import com.example.healthcare.People.DoctorEntity;
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
public class AppointmentEntity {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appid;

    @ManyToOne
    @JoinColumn (name = "pid")
    private PatientEntity patientid;

    @ManyToOne
    @JoinColumn (name="did")
    private DoctorEntity doctorid;
    
    private Date appointmentdate;

}
