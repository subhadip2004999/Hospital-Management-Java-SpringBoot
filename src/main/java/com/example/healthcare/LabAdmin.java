package com.example.healthcare;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.healthcare.Laboratory.LabService;
import com.example.healthcare.Laboratory.LabEntity;

@Component 
public class LabAdmin {
    @Autowired 
    private LabService service;
    Scanner sc = new Scanner(System.in);

    public void addlab(){
        LabEntity entity = new LabEntity();
        System.out.println("\n\n||-------------------------||");
        System.out.println("|| Add New Laboratory Test ||");
        System.out.println("||-------------------------||");
        System.out.print("\nEnter Laboratory Test Name: ");
        String name = sc.nextLine();
        entity.setTestname(name);
        System.out.print("Enter Test Cost: ");
        double cost = sc.nextDouble();
        entity.setTestcost(cost);
        sc.nextLine();
        System.out.print("Enter Test Details: ");
        String details = sc.nextLine();
        entity.setTestdetails(details);
        service.createTest(entity);
        System.out.println("\nNew Image Technology Added Successfully !!");
    }

    public void alllab(){
        System.out.println("\n\n||-------------------------||");
        System.out.println("|| View Image Technologies ||");
        System.out.println("||-------------------------||");
        List<LabEntity> list = service.showAllTest();
        for(int i=0; i<list.size(); i++){
            LabEntity entity = list.get(i);
            System.out.println("\nLab Test Id: "+entity.getTestid());
            System.out.println("Lab Test Name: "+entity.getTestname());
            System.out.println("Lab Test Cost: "+entity.getTestcost());
            System.out.println("Lab test Details: "+entity.getTestdetails());
            System.out.println("-------------------------------------------");
        }
    }

    public void labbyid(){
        System.out.print("\nEnter Lab Test Id: ");
        Long id = sc.nextLong();
        sc.nextLine();
        Optional<LabEntity> list = service.showTestById(id);
        LabEntity entity = list.get();
        System.out.println("\nLab Test Id: "+entity.getTestid());
        System.out.println("Lab Test Name: "+entity.getTestname());
        System.out.println("Lab Test Cost: "+entity.getTestcost());
        System.out.println("Lab test Details: "+entity.getTestdetails());
    }
    
}
