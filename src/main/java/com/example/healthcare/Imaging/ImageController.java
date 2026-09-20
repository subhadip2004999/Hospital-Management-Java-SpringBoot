package com.example.healthcare.Imaging;

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
@RequestMapping ("/imaging")
public class ImageController {
    
    @Autowired 
    ImageService service;

    @GetMapping("/getallimage")
    public List<ImageEntity> getAllImage() {
        return service.showAllImage();
    }

    @GetMapping("/getimagebyid")
    public Optional<ImageEntity> getImageById(@RequestParam Long id) {
        return service.showImageById(id);
    }
    @PostMapping("/addimage")
    public void postAddImage(@RequestBody ImageEntity entity) {
        service.createImage(entity);
    }
    
    
    
}
