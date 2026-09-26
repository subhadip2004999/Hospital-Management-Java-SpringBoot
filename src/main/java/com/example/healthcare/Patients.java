package com.example.healthcare;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.healthcare.People.PatientEntity;
import com.example.healthcare.People.PeopleService;

@Component 
public class Patients {
    
        Scanner sc = new Scanner(System.in);
        @Autowired 
        PeopleService service;

        public void addpatients(){
            PatientEntity entity = new PatientEntity();

            System.out.println("\n\n||--------------||");
            System.out.println("|| Add Patients ||");
            System.out.println("||--------------||");
            System.out.print("\nEnter Patient's Name: ");
            String name = sc.nextLine();
            entity.setPname(name);
            System.out.print("Enter Patient's Address: ");
            String address = sc.nextLine();
            entity.setPaddress(address);
            System.out.print("Enter Patient's Phone Number: ");
            int phone = sc.nextInt();
            sc.nextLine();
            entity.setPphone(phone);
            service.addPatient(entity);
            System.out.println("\nPatient: "+" is added successfully !!");
        }

        public void allpatients(){
            List<PatientEntity> list = service.showPatients();
            System.out.println("\n\n||-------------------||");
            System.out.println("|| Show All Patients ||");
            System.out.println("||-------------------||/n");
            for(int i=0; i<list.size();i++){
                PatientEntity entity = list.get(i);
                System.out.println("Patient's Id: "+entity.getPid());
                System.out.println("Patient's Name: "+entity.getPname());
                System.out.println("Patient's Address: "+entity.getPaddress());
                System.out.println("Patient's Phone Number: "+entity.getPphone());
                System.out.println("-------------------------------------------");
            }

        }

        public void patientbyid(){
            System.out.print("\nEnter Patient's Id: ");
            Long id = sc.nextLong();
            sc.nextLine();
            Optional<PatientEntity> list = service.findPatientById(id);
            if (list.isPresent()) {
            PatientEntity entity = list.get();
            System.out.println("\nPatient Id: " + entity.getPid());
            System.out.println("Patient's Name: " + entity.getPname());
            System.out.println("Patient's Address: " + entity.getPaddress());
            System.out.println("Patient's Phone Number: " + entity.getPphone());
        } else {
            System.out.println("\nPatient not found with ID: " + id);
        }
        }
}
