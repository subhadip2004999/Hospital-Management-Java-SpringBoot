package com.example.healthcare;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthcareApplication implements CommandLineRunner {

    @Autowired
    private Appointments app;
    private Patients pat;

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


                case 8:
                    Loop = 890;
                    break;
            }

        } while (Loop == 0);

        sc.close();
    }
}