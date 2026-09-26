package com.example.healthcare;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.healthcare.People.DoctorEntity;
import com.example.healthcare.People.PeopleService;

@Component 
public class Doctors {
    private Scanner sc = new Scanner(System.in);
    @Autowired 
    PeopleService service;

    public void adddoctors(){
        DoctorEntity entity = new DoctorEntity();
            System.out.println("\n\n||-------------||");
            System.out.println("|| Add Doctors ||");
            System.out.println("||-------------||");
            System.out.print("\nEnter Doctor's Name: ");
            String name = sc.nextLine();
            entity.setDname(name);
            System.out.print("Enter Doctor's Specialization: ");
            String specs = sc.nextLine();
            entity.setDspecialization(specs);
            System.out.print("Enter Doctor's Phone Number: ");
            String phone = sc.nextLine();
            entity.setDphone(phone);
            System.out.print("Enter Doctor's Fees: $");
            double fees = sc.nextDouble();
            sc.nextLine();
            entity.setDfees(fees);
            service.addDoctor(entity);
            System.out.println("\nDoctor: "+name+" is added successfully !!");
    }

    public void viewdoctors(){
         List<DoctorEntity> list = service.showDoctors();
            System.out.println("\n\n||------------------||");
            System.out.println("|| Show All Doctors ||");
            System.out.println("||------------------||");
            for(int i =0; i<list.size(); i++){
                DoctorEntity entity = list.get(i);
                System.out.println("\nDoctor's Id: "+entity.getDid());
                System.out.println("Doctor's Name: "+entity.getDname());
                System.out.println("Doctor's Specialization: "+entity.getDspecialization());
                System.out.println("Doctor's Phone Number: "+entity.getDphone());
                System.out.println("Doctor's Fees: "+entity.getDfees());
                System.out.println("-------------------------------------------");
            }
    }
    
}
