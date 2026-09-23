package com.example.healthcare.Imaging;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ImageService {
    
    @Autowired 
    ImageRepository repository;

    public void createImage(ImageEntity entity){
        repository.save(entity);
    }

    public Optional<ImageEntity> showImageById(Long id){
        return repository.findById(id);
    }

    public List<ImageEntity> showAllImage(){
        return repository.findAll();
    }
}
