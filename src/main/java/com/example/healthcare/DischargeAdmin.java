package com.example.healthcare;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.healthcare.Appointment.AppointmentEntity;
import com.example.healthcare.Appointment.AppointmentService;
import com.example.healthcare.Discharge.DischargeEntity;
import com.example.healthcare.Discharge.DischargeService;
import com.example.healthcare.Imaging.ImageEntity;
import com.example.healthcare.Imaging.ImageService;
import com.example.healthcare.Laboratory.LabEntity;
import com.example.healthcare.Laboratory.LabService;
import com.example.healthcare.People.DoctorEntity;
import com.example.healthcare.People.PatientEntity;
import com.example.healthcare.People.PeopleService;
import com.example.healthcare.Pharmacy.PharmEntity;
import com.example.healthcare.Pharmacy.PharmService;

@Component 
public class DischargeAdmin {

    @Autowired
    private DischargeService service;

    @Autowired
    private PeopleService s1;

    @Autowired
    private AppointmentService s2;

    @Autowired
    private ImageService s3;

    @Autowired
    private LabService s4;

    @Autowired
    private PharmService s5;
    
    private Scanner sc = new Scanner(System.in);

    public void adddischarge(){
        DischargeEntity entity = new DischargeEntity();
        System.out.println("\n\n||--------------------||");
        System.out.println("|| Add Discharge Form ||");
        System.out.println("||--------------------||");
        
        System.out.print("\nEnter Patient's Id: ");
        Long pat = sc.nextLong();
        sc.nextLine();
        entity.setPatientid(pat);

        System.out.print("\nEnter Doctor's Id: ");
        Long doc = sc.nextLong();
        sc.nextLine();
        Optional<DoctorEntity> docOpt = s1.findDoctorById(doc);
        if (!docOpt.isPresent()) {
            System.out.println("Doctor not found!");
            return;
        }
        entity.setDoctorid(doc);

        System.out.print("\nEnter Appointment Id: ");
        Long app = sc.nextLong();
        sc.nextLine();
        entity.setAppointmentid(app);

        System.out.print("\nEnter Imaging Id: ");
        Long img = sc.nextLong();
        sc.nextLine();
        Optional<ImageEntity> imgOpt = s3.showImageById(img);
        if (!imgOpt.isPresent()) {
            System.out.println("Imaging record not found!");
            return;
        }
        entity.setImageid(img);

        System.out.print("\nEnter Lab Test Id: ");
        Long test = sc.nextLong();
        sc.nextLine();
        Optional<LabEntity> labOpt = s4.showTestById(test);
        if (!labOpt.isPresent()) {
            System.out.println("Lab test record not found!");
            return;
        }
        entity.setTestid(test);

        System.out.print("\nEnter Medicine Id: ");
        Long med = sc.nextLong();
        sc.nextLine();
        Optional<PharmEntity> pharmOpt = s5.showMedicineById(med);
        if (!pharmOpt.isPresent()) {
            System.out.println("Medicine record not found!");
            return;
        }
        entity.setMedicineid(med);

        // Calculate total bill
        double total = docOpt.get().getDfees() 
                     + imgOpt.get().getImagecost() 
                     + labOpt.get().getTestcost() 
                     + pharmOpt.get().getMedicinecost();
                     
        entity.setTotalbill(total);
        service.createDischargeForm(entity);
        System.out.println("\nDischarge Form Created Successfully! Total Bill: $" + total);
    }


    public void alldischarge(){
        List<DischargeEntity> list = service.showAllDischargeForm();
        System.out.println("\n\n|| All Discharge List ||");
        for(int i = 0; i < list.size(); i++){
            DischargeEntity entity = list.get(i);
            System.out.println("\nDischarge Id: " + entity.getDischargeid());
            System.out.println("Patient's Id: " + entity.getPatientid());
            System.out.println("Doctor's Id: " + entity.getDoctorid());
            System.out.println("Appointment Id: " + entity.getAppointmentid());
            System.out.println("Imaging Id: " + entity.getImageid());
            System.out.println("Lab Test Id: " + entity.getTestid());
            System.out.println("Medicine Id: " + entity.getMedicineid());
            System.out.println("Total Bill  : $" + entity.getTotalbill());
            System.out.println("-------------------------------------------");
        }
    }

    public void dischargebyid(){
        System.out.print("\nEnter Discharge Id: ");
        Long id = sc.nextLong();
        sc.nextLine();
        
        Optional<DischargeEntity> dischargeOpt = service.showDischargeFormById(id);
        if (!dischargeOpt.isPresent()) {
            System.out.println("Discharge form with ID " + id + " not found.");
            return;
        }

        DischargeEntity entity = dischargeOpt.get();
        Long p = entity.getPatientid();
        Long d = entity.getDoctorid();
        Long a = entity.getAppointmentid();
        Long imgId = entity.getImageid();
        Long testId = entity.getTestid();
        Long medId = entity.getMedicineid();

        // Fetch related entities
        Optional<PatientEntity> patientOpt = s1.findPatientById(p);
        Optional<DoctorEntity> doctorOpt = s1.findDoctorById(d);
        Optional<AppointmentEntity> appointmentOpt = s2.showAppointmentById(a);
        Optional<ImageEntity> imageOpt = s3.showImageById(imgId);
        Optional<LabEntity> labOpt = s4.showTestById(testId);
        Optional<PharmEntity> pharmOpt = s5.showMedicineById(medId);

        // Print Discharge Bill Slip
        System.out.println("\n\n===========================================");
        System.out.println("            HOSPITAL DISCHARGE BILL        ");
        System.out.println("===========================================");
        System.out.println("Discharge ID   : " + entity.getDischargeid());
        
        // Patient Info
        if (patientOpt.isPresent()) {
            // Note: Update `getName()` to `getPatientname()` if your entity uses that method
            System.out.println("Patient Name   : " + patientOpt.get().getPname());
        } else {
            System.out.println("Patient Name   : N/A (ID: " + p + ")");
        }

        // Doctor Info & Fees
        if (doctorOpt.isPresent()) {
            DoctorEntity doc = doctorOpt.get();
            System.out.println("Doctor Name    : " + doc.getDname()); // Adjust getter if needed
            System.out.println("Doctor Fees    : $" + doc.getDfees());
        } else {
            System.out.println("Doctor Name    : N/A (ID: " + d + ")");
        }

        // Appointment Date
        if (appointmentOpt.isPresent()) {
            // Note: Update `getDate()` to `getAppointmentdate()` or similar if named differently in your AppointmentEntity
            System.out.println("Appointment Dt : " + appointmentOpt.get().getAppointmentdate());
        } else {
            System.out.println("Appointment Dt : N/A (ID: " + a + ")");
        }

        System.out.println("-------------------------------------------");
        System.out.println("               SERVICES & COSTS            ");
        System.out.println("-------------------------------------------");

        // Imaging Info & Cost
        if (imageOpt.isPresent()) {
            ImageEntity img = imageOpt.get();
            // Note: Adjust `getImageName()` if your getter is `getImagename()`
            System.out.println("Imaging        : " + img.getImagename() + " - $" + img.getImagecost());
        } else {
            System.out.println("Imaging        : N/A");
        }

        // Lab Test Info & Cost
        if (labOpt.isPresent()) {
            LabEntity lab = labOpt.get();
            // Note: Adjust `getTestName()` if your getter is `getTestname()`
            System.out.println("Lab Test       : " + lab.getTestname() + " - $" + lab.getTestcost());
        } else {
            System.out.println("Lab Test       : N/A");
        }

        // Medicine Info & Cost
        if (pharmOpt.isPresent()) {
            PharmEntity pharm = pharmOpt.get();
            // Note: Adjust `getMedicineName()` if your getter is `getMedicinename()`
            System.out.println("Medicine       : " + pharm.getMedicinename() + " - $" + pharm.getMedicinecost());
        } else {
            System.out.println("Medicine       : N/A");
        }

        System.out.println("-------------------------------------------");
        System.out.println("Total Bill     : $" + entity.getTotalbill());
        System.out.println("===========================================");
    }
}