package com.example.healthcare.People;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepositoty extends JpaRepository<DoctorEntity, Long> {
    
}
