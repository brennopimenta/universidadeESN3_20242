package com.example.universidadeESN3.service;

import org.springframework.http.ResponseEntity;

public interface IPhotoService {

    ResponseEntity<?> buscaPhotoPorId(Long id);
}
