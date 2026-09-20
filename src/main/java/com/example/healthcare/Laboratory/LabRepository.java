package com.example.healthcare.Laboratory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface LabRepository extends JpaRepository<LabEntity, Long>{
    
}
