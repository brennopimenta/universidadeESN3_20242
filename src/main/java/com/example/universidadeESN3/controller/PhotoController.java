package com.example.universidadeESN3.controller;

import com.example.universidadeESN3.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private IPhotoService photoService;

    @GetMapping("/{id}")
    ResponseEntity<?> getPhotoById(@PathVariable Long id){
        return photoService.buscaPhotoPorId(id);
    }

}
