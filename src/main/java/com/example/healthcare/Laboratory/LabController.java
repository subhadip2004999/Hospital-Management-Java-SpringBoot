package com.example.healthcare.Laboratory;

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
@RequestMapping ("/laboratory")
public class LabController {
    
    @Autowired 
    LabService service;

    @GetMapping("/getalltest")
    public List<LabEntity> getAllTest() {
        return service.showAllTest();
    }

    @GetMapping("/gettestbyid")
    public Optional<LabEntity> getTestById(@RequestParam Long id) {
        return service.showTestById(id);
    }

    @PostMapping("/addtest")
    public void postAddTest(@RequestBody LabEntity entity) {
        service.createTest(entity);
    }
    
    
    
}
