package com.example.healthcare;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.healthcare.Appointment.AppointmentEntity;
import com.example.healthcare.Appointment.AppointmentService;

@Component 
public class Appointments {

    @Autowired 
    private AppointmentService service;

    private Scanner sc = new Scanner(System.in);

    public void addAppointment() {
        AppointmentEntity entity = new AppointmentEntity();

        System.out.println("\n\n||------------------||");
        System.out.println("|| Add Appointments ||");
        System.out.println("||------------------||");

        System.out.print("\nEnter the Doctor's id: ");
        Long doctorId = sc.nextLong();
        sc.nextLine();
        entity.setDoctorid(doctorId);

        System.out.print("Enter the Patient's id: ");
        Long patientId = sc.nextLong();
        sc.nextLine();
        entity.setPatientid(patientId);

        System.out.print("Enter Appointment date (DD/MM/YYYY): ");
        String dateStr = sc.nextLine();
        entity.setAppointmentdate(dateStr);

        service.addAppointment(entity);
        System.out.println("\nAppointment Added Successfully !!");
    }

    public void allAppointment() {
        System.out.println("\n\n||-------------------||");
        System.out.println("|| Show Appointments ||");
        System.out.println("||-------------------||");
        
        List<AppointmentEntity> list = service.showAllAppointments();
        
        if (list == null || list.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (int i =0; i<list.size();i++) {
            AppointmentEntity entity = list.get(i);
            System.out.println("\nAppointment Id: " + entity.getAppid());
            System.out.println("Patient's Id: " + entity.getPatientid());
            System.out.println("Doctor's Id: " + entity.getDoctorid());
            System.out.println("Date of appointment: " + entity.getAppointmentdate());
            System.out.println("-------------------------------------------");
        }
    }

    public void idAppointment() {
        System.out.println("\n\n||--------------------||");
        System.out.println("|| Appointments by id ||");
        System.out.println("||--------------------||");
        
        System.out.print("\nEnter Appointment Id: ");
        Long id1 = sc.nextLong();
        sc.nextLine();

        Optional<AppointmentEntity> optionalEntity = service.showAppointmentById(id1);

        if (optionalEntity.isPresent()) {
            AppointmentEntity entity = optionalEntity.get();
            System.out.println("\nAppointment Id: " + entity.getAppid());
            System.out.println("Patient's Id: " + entity.getPatientid());
            System.out.println("Doctor's Id: " + entity.getDoctorid());
            System.out.println("Date of appointment: " + entity.getAppointmentdate());
        } else {
            System.out.println("\nAppointment not found with ID: " + id1);
        }
    }
}