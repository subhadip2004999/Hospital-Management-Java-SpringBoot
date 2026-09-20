package com.example.healthcare.Discharge;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping ("/discharge")
public class DischargeController {
    
    @Autowired 
    DischargeService service;

    @GetMapping("/getalldischargeform")
    public List<DischargeEntity> getAllDischargeForm() {
        return service.showAllDischargeForm();
    }

    @GetMapping("/getdischargeformbyid")
    public Optional<DischargeEntity> getDischargeFormById(@RequestParam Long id) {
        return service.showDischargeFormById(id);
    }

    @PostMapping("path")
    public void postDischargeForm(@RequestBody DischargeEntity entity) {
        service.createDischargeForm(entity);
    }
    
    
    
}
