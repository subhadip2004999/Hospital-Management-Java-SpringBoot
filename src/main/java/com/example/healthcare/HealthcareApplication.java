package com.example.healthcare;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthcareApplication implements CommandLineRunner {

    @Autowired
    private Appointments app;
    @Autowired
    private Patients pat;
    @Autowired
    private Doctors doc;
    @Autowired
    private ImageAdmin img;
    @Autowired
    private LabAdmin lab;
    @Autowired 
    private PharmAdmin pharm;
    private DischargeAdmin dischargeAdmin;

    public static void main(String[] args) {
        SpringApplication.run(HealthcareApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int Loop = 0;

        do {
            System.out.println("\n\n||-------------------------------||");
            System.out.println("|| SELECT SERVICE FOR THE SYSTEM ||");
            System.out.println("||-------------------------------||\n");

            System.out.println("1. APPOINTMENTS");
            System.out.println("2. PATIENTS");
            System.out.println("3. DOCTORS");
            System.out.println("4. IMAGING");
            System.out.println("5. LABORATORY");
            System.out.println("6. PHARMACY");
            System.out.println("7. DISCHARGE");
            System.out.println("8. EXIT");
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    int appointmentLoop = 0;
                    do {
                        System.out.println("\n\n||--------------||");
                        System.out.println("|| Appointments ||");
                        System.out.println("||--------------||\n");
                        System.out.println("1. Make A New Appointment");
                        System.out.println("2. Show All Appointments");
                        System.out.println("3. Search Appointment By Id");
                        System.out.println("4. Exit");
                        System.out.print("\nEnter your choice: ");
                        int choice1 = sc.nextInt();
                        sc.nextLine();

                        switch (choice1) {
                            case 1:
                                app.addAppointment();
                                sc.nextLine();
                                break;
                            case 2:
                                app.allAppointment();
                                sc.nextLine();
                                break;
                            case 3:
                                app.idAppointment();
                                sc.nextLine();
                                break;
                            case 4:
                                System.out.println("\n\nExit Appointments\n");
                                sc.nextLine();
                                appointmentLoop = 1;
                                break;
                            default:
                                System.out.println("\nWrong Choice\n");
                                sc.nextLine();
                                break;
                        }
                    } while (appointmentLoop == 0);
                    break;
                
                case 2:
                    int patientLoop = 0;
                    do{
                        System.out.println("\n\n||----------||");
                        System.out.println("|| Patients ||");
                        System.out.println("||----------||\n");
                        System.out.println("1. Add A New Patient");
                        System.out.println("2. Show All Patients");
                        System.out.println("3. Search Patient By Id");
                        System.out.println("4. Exit");
                        System.out.print("\nEnter your choice: ");
                        int choice2 = sc.nextInt();
                        sc.nextLine();
                        switch(choice2){
                            case 1:
                                pat.addpatients();
                                sc.nextLine();
                                break;
                            case 2:
                                pat.allpatients();
                                sc.nextLine();
                                break;
                            case 3:
                                pat.patientbyid();
                                sc.nextLine();
                                break;
                            case 4:
                                System.out.println("\n\nExit Patients\n");
                                sc.nextLine();
                                patientLoop = 1;
                                break;
                            default:
                                System.out.println("\nWrong choice");
                                sc.nextLine();
                                break;                        }

                    }while(patientLoop==0);
                    break;
                
                case 3:
                    int doctorLoop = 0;
                    do{
                        System.out.println("\n\n||---------||");
                        System.out.println("|| Doctors ||");
                        System.out.println("||---------||\n");
                        System.out.println("1. Add A New Doctor");
                        System.out.println("2. Show All Doctors");
                        System.out.println("3. Exit");
                        System.out.print("\nEnter your choice: ");
                        int choice3 = sc.nextInt();
                        sc.nextLine();

                        switch(choice3){
                            case 1:
                                doc.adddoctors();
                                sc.nextLine();
                                break;
                            case 2:
                                doc.viewdoctors();
                                sc.nextLine();
                                break;
                            case 3:
                                System.out.println("\n\nExit Doctors\n");
                                sc.nextLine();
                                doctorLoop =1;
                                break;
                            default:
                                System.out.println("\nWrong Choice\n");
                                sc.nextLine();
                                break;
                        }
                    }while(doctorLoop==0);
                    break;

                case 4:
                    int imageLoop = 0;
                    do{
                        System.out.println("\n\n||---------||");
                        System.out.println("|| Imaging ||");
                        System.out.println("||---------||\n");
                        System.out.println("1. Add New Image Technology");
                        System.out.println("2. Show All Image Technology");
                        System.out.println("3. Find Imaging Details By Id");
                        System.out.println("4. Exit");
                        System.out.print("\nEnter your choice: ");
                        int choice4 = sc.nextInt();
                        sc.nextLine();
                        switch(choice4){
                            case 1:
                                img.addimage();
                                sc.nextLine();
                                break;
                            case 2:
                                img.allimage();
                                sc.nextLine();
                                break;
                            case 3:
                                img.imagebyid();
                                sc.nextLine();
                                break;
                            case 4:
                                System.out.println("\nExit Imaging\n");
                                sc.nextLine();
                                imageLoop = 1;
                                break;
                            default:
                                System.out.println("\nWrong Choice\n");
                                sc.nextLine();
                                break;
                        }

                    }while(imageLoop==0);
                    break;

                case 5:
                int labLoop = 0;
                    do{
                        System.out.println("\n\n||------------||");
                        System.out.println("|| Laboratory ||");
                        System.out.println("||------------||\n");
                        System.out.println("1. Add New Image Technology");
                        System.out.println("2. Show All Image Technology");
                        System.out.println("3. Find Imaging Details By Id");
                        System.out.println("4. Exit");
                        System.out.print("\nEnter your choice: ");
                        int choice5 = sc.nextInt();
                        sc.nextLine();
                        switch(choice5){
                            case 1:
                                lab.addlab();
                                sc.nextLine();
                                break;
                            case 2:
                                lab.alllab();
                                sc.nextLine();
                                break;
                            case 3:
                                lab.labbyid();
                                sc.nextLine();
                                break;
                            case 4:
                                System.out.println("\nExit Imaging\n");
                                sc.nextLine();
                                imageLoop = 1;
                                break;
                            default:
                                System.out.println("\nWrong Choice\n");
                                sc.nextLine();
                                break;
                            }
                    }while(labLoop==0);
                    break;


                case 6:
                    int pharmLoop = 0;
                    do{
                        System.out.println("\n\n||----------||");
                        System.out.println("|| Pharmacy ||");
                        System.out.println("||----------||\n");
                        System.out.println("1. Add New Medicine");
                        System.out.println("2. Show All Medicine");
                        System.out.println("3. Find Medicine Details By Id");
                        System.out.println("4. Exit");
                        System.out.print("\nEnter your choice: ");
                        int choice6 = sc.nextInt();
                        sc.nextLine();
                        switch(choice6){
                            case 1:
                                pharm.addmedicine();
                                sc.nextLine();
                                break;
                            case 2:
                                pharm.allmedicine();
                                sc.nextLine();
                                break;
                            case 3:
                                pharm.medicinebyid();
                                sc.nextLine();
                                break;
                            case 4:
                                System.out.println("\nExit Imaging\n");
                                sc.nextLine();
                                imageLoop = 1;
                                break;
                            default:
                                System.out.println("\nWrong Choice\n");
                                sc.nextLine();
                                break;
                            }
                    }while(pharmLoop==0);
                    break;

                
           case 7:
        int dischargeLoop = 0;
        do {
            System.out.println("\n\n||-----------||");
            System.out.println("|| Discharge ||");
            System.out.println("||-----------||\n");
            System.out.println("1. Discharge Patient");
            System.out.println("2. Show Discharge Details");
            System.out.println("3. Exit");
            System.out.print("\nEnter your choice: ");
            int choice7 = sc.nextInt();
            sc.nextLine(); // Consumes the newline character left-over from nextInt()
            
            switch (choice7) {
                case 1:
                    // Calls the method to add/create a discharge form and calculate the bill
                    dischargeAdmin.adddischarge();
                    break;
                    
                case 2:
                    // Calls the method to look up and print the detailed discharge bill slip by ID
                    dischargeAdmin.dischargebyid();
                    break;
                    
                case 3:
                    System.out.println("\nExit Discharge\n");
                    dischargeLoop = 1;
                    break;
                    
                default:
                    System.out.println("\nWrong Choice\n");
                    break;
            }
        } while (dischargeLoop == 0);
        break;
                case 8:
                    System.out.println("\n\n|| Thankyou for using Healthcare. A Backend System for Hospitals ||");
                    Loop = 1;
            }

        } while (Loop == 0);
 
    }
}