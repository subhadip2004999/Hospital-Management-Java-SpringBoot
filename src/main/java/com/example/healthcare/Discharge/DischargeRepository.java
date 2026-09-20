package com.example.healthcare.Discharge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface DischargeRepository extends JpaRepository<DischargeEntity, Long>{
    
}
