package com.example.healthcare;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthcareApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareApplication.class, args);

		Scanner sc = new Scanner(System.in);

		int num = 0;
		do{

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
			System.out.print("\nEnter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

		}while(num!=890);

	}

}
