# Hospital Management System - Java Spring Boot

A comprehensive backend hospital management system built with **Java 21** and **Spring Boot 4.1.1** that provides integrated services for managing patients, doctors, appointments, medical imaging, laboratory tests, pharmacy operations, and patient discharge processing.

## What This Is

This is a command-line driven hospital management application that centralizes critical healthcare operations. It enables hospital administrators and staff to manage patient records, doctor profiles, medical appointments, imaging services, lab tests, medicine inventory, and patient discharge with billing calculations. The system uses **Spring Data JPA** for database persistence with MySQL and follows a modular service-oriented architecture.

### Stack

- **Language(s):** Java 21
- **Framework / Runtime:** Spring Boot 4.1.1 with Spring Data JPA
- **Notable libraries:** 
  - Spring Boot Starter Actuator (monitoring & health checks)
  - Spring Data JPA (ORM layer for MySQL)
  - Lombok (boilerplate reduction)
  - MySQL Connector/J (database driver)
  - Spring Boot Test suites (testing framework)

## How It's Organized

```
src/main/java/com/example/healthcare/
  ├── HealthcareApplication.java         Main entry point with CLI menu system
  ├── Appointments.java                  Appointment management (add, view, search)
  ├── Patients.java                      Patient management (add, view, search)
  ├── Doctors.java                       Doctor registry (add, view profiles)
  ├── ImageAdmin.java                    Medical imaging services
  ├── LabAdmin.java                      Laboratory test management
  ├── PharmAdmin.java                    Pharmacy & medicine inventory
  ├── DischargeAdmin.java                Patient discharge & billing
  │
  ├── Appointment/                       Appointment domain module
  │   ├── AppointmentEntity.java         JPA entity for appointments
  │   ├── AppointmentRepository.java     Data access layer (Spring Data JPA)
  │   ├── AppointmentService.java        Business logic layer
  │   └── AppointmentController.java     REST/request handlers
  │
  ├── People/                            Patients & Doctors domain module
  │   ├── PatientEntity.java             JPA entity for patients
  │   ├── DoctorEntity.java              JPA entity for doctors
  │   ├── PatientRepository.java         Patient data access
  │   ├── DoctorRepositoty.java          Doctor data access
  │   ├── PeopleService.java             Business logic for patients & doctors
  │   └── PeopleController.java          REST endpoints
  │
  ├── Imaging/                           Medical imaging services
  ├── Laboratory/                        Lab testing services
  ├── Pharmacy/                          Medicine & pharmacy operations
  └── Discharge/                         Patient discharge & billing
```

**How it fits together:** The application runs as a command-line interface with a main menu loop in `HealthcareApplication`. Users navigate through service options (Appointments, Patients, Doctors, Imaging, Lab, Pharmacy, Discharge) where each selection triggers the corresponding Admin/Manager class (e.g., `Patients`, `Doctors`, `ImageAdmin`). These components use Spring-injected services to perform CRUD operations via JPA repositories connected to MySQL. Data flows from user input → Admin class → Service layer → Repository → MySQL database, with results formatted and displayed back in the terminal.

## How to Run It

### Prerequisites
- Java 21+ installed
- MySQL server running and accessible
- Maven (included via `mvnw` wrapper)

### Build & Run

```bash
# Using Maven wrapper (Linux/Mac)
./mvnw clean install
./mvnw spring-boot:run

# Or on Windows
mvnw.cmd clean install
mvnw.cmd spring-boot:run
```

### Required Configuration

Update `src/main/resources/application.properties` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### First Launch

Once running, you'll see a menu like:

```
||-------------------------------||
|| SELECT SERVICE FOR THE SYSTEM ||
||-------------------------------|

1. APPOINTMENTS
2. PATIENTS
3. DOCTORS
4. IMAGING
5. LABORATORY
6. PHARMACY
7. DISCHARGE
8. EXIT
```

Select an option and follow the sub-menu prompts to:
- Add new records
- View all records
- Search/filter by ID
- Manage discharge and billing

## Contact

- businesssubhadip@gmail.com
- github@subhadip2004999
