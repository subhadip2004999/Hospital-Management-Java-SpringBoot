package com.example.healthcare;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.healthcare.Pharmacy.PharmService;
import com.example.healthcare.Pharmacy.PharmEntity;

@Component 
public class PharmAdmin {
    @Autowired 
    private PharmService service;
    Scanner sc = new Scanner(System.in);

    public void addmedicine(){
        PharmEntity entity = new PharmEntity();
        System.out.println("\n\n||------------------||");
        System.out.println("|| Add New Medicine ||");
        System.out.println("||------------------||");
        System.out.print("\nEnter Medicine Name: ");
        String name = sc.nextLine();
        entity.setMedicinename(name);
        System.out.print("Enter Medicine Cost: ");
        double cost = sc.nextDouble();
        entity.setMedicinecost(cost);
        sc.nextLine();
        System.out.print("Enter Medicine Details: ");
        String details = sc.nextLine();
        entity.setMedicinedetails(details);
        service.createMedicine(entity);
        System.out.println("\nNew Medicine Added Successfully !!");
    }

    public void allmedicine(){
        System.out.println("\n\n||--------------------||");
        System.out.println("|| View All Medicines ||");
        System.out.println("||--------------------||");
        List<PharmEntity> list = service.showAllMedicine();
        for(int i=0; i<list.size(); i++){
            PharmEntity entity = list.get(i);
            System.out.println("\nMedicine Id: "+entity.getMedicineid());
            System.out.println("Medicine Name: "+entity.getMedicinename());
            System.out.println("Medicine Cost: "+entity.getMedicinecost());
            System.out.println("Medicine Details: "+entity.getMedicinedetails());
            System.out.println("-------------------------------------------");
        }
    }

    public void medicinebyid(){
        System.out.print("\nEnter Medicine Id: ");
        Long id = sc.nextLong();
        sc.nextLine();
        Optional<PharmEntity> list = service.showMedicineById(id);
        PharmEntity entity = list.get();
        System.out.println("\nMedicine Id: "+entity.getMedicineid());
        System.out.println("Medicine Name: "+entity.getMedicinename());
        System.out.println("Medicine Cost: "+entity.getMedicinecost());
        System.out.println("Medicine Details: "+entity.getMedicinedetails());
    }
    
}
