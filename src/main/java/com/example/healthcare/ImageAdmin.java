package com.example.healthcare;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.healthcare.Imaging.ImageService;
import com.example.healthcare.Imaging.ImageEntity;

@Component 
public class ImageAdmin {
    @Autowired 
    private ImageService service;
    Scanner sc = new Scanner(System.in);

    public void addimage(){
        ImageEntity entity = new ImageEntity();
        System.out.println("\n\n||----------------------||");
        System.out.println("|| Add Image Technology ||");
        System.out.println("||----------------------||");
        System.out.print("\nEnter Technology Name: ");
        String name = sc.nextLine();
        entity.setImagename(name);
        System.out.print("Enter Image Cost: ");
        double cost = sc.nextDouble();
        entity.setImagecost(cost);
        sc.nextLine();
        System.out.print("Enter Image Technology Details: ");
        String details = sc.nextLine();
        entity.setImagedetails(details);
        service.createImage(entity);
        System.out.println("\nNew Image Technology Added Successfully !!");
    }

    public void allimage(){
        System.out.println("\n\n||-------------------------||");
        System.out.println("|| View Image Technologies ||");
        System.out.println("||-------------------------||");
        List<ImageEntity> list = service.showAllImage();
        for(int i=0; i<list.size(); i++){
            ImageEntity entity = list.get(i);
            System.out.println("\nImage Technology Id: "+entity.getImageid());
            System.out.println("Image Technology Name: "+entity.getImagename());
            System.out.println("Image Technology Cost: "+entity.getImagecost());
            System.out.println("Image Technology Details: "+entity.getImagedetails());
            System.out.println("-------------------------------------------");
        }
    }

    public void imagebyid(){
        System.out.print("\nEnter Image Id: ");
        Long id = sc.nextLong();
        sc.nextLine();
        Optional<ImageEntity> list = service.showImageById(id);
        ImageEntity entity = list.get();
        System.out.println("\nImage Technology Id: "+entity.getImageid());
        System.out.println("Image Technology Name: "+entity.getImagename());
        System.out.println("Image Technology Cost: "+entity.getImagecost());
        System.out.println("Image Technology Details: "+entity.getImagedetails());
    }
}
