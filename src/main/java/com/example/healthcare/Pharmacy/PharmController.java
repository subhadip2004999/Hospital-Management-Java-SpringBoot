package com.example.healthcare.Pharmacy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.healthcare.Laboratory.LabEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping ("/pharmacy")
public class PharmController {
    
    @Autowired 
    PharmService service;
    
    @GetMapping("/getallmedicine")
    public List<PharmEntity> getAllMedicine() {
        return service.showAllMedicine();
    }

    @GetMapping("/getmedicinebyid")
    public Optional<PharmEntity> getMedicineById(@RequestParam Long id) {
        return service.showMedicineById(id);
    }

    @PostMapping("/addmedicine")
    public void postAddMedicine(@RequestBody PharmEntity entity) {
        service.createMedicine(entity);
    }
    
}
