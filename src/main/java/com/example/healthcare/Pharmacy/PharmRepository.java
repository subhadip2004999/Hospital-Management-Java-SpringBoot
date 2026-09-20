package com.example.healthcare.Pharmacy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface PharmRepository extends JpaRepository<PharmEntity, Long>{
    
}
