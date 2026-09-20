package com.example.healthcare.Discharge;

import com.example.healthcare.Appointment.AppointmentEntity;
import com.example.healthcare.Imaging.ImageEntity;
import com.example.healthcare.Laboratory.LabEntity;
import com.example.healthcare.People.PatientEntity;
import com.example.healthcare.Pharmacy.PharmEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@Data 
@Entity 
public class DischargeEntity {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dischargeid;

    @ManyToOne
    @JoinColumn (name = "pid")
    private PatientEntity patientid;

    @ManyToOne
    @JoinColumn (name = "appid")
    private AppointmentEntity appointmentid;

    @ManyToOne
    @JoinColumn (name = "imageid")
    private ImageEntity imageid;

    @ManyToOne
    @JoinColumn (name = "testid")
    private LabEntity testid;

    @ManyToOne
    @JoinColumn (name = "medicineid")
    private PharmEntity medicineid;

    @PrePersist 
    @PreUpdate 
    public double getTotalBill() {
    double total = 0.0;

        if (appointmentid != null && appointmentid.getDoctorid() != null) {
        total += appointmentid.getDoctorid().getDfees();
        }
        if (imageid != null) {
        total += imageid.getImagecost();
        }
        if (testid != null) {
        total += testid.getTestcost();
        }
        if (medicineid != null) {
        total += medicineid.getMedicinecost();
        }
        return total;
        
    }
    
    private double total;

    
}


