package com.example.universidadeESN3.service;

import com.example.universidadeESN3.client.IClientPhoto;
import com.example.universidadeESN3.exception.InvalidPhotoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PhotoService implements IPhotoService {

    @Autowired
    IClientPhoto clientPhoto;

    @Override
    public ResponseEntity<?> buscaPhotoPorId(Long id) {

        try {
            log.info("buscarPhotoPorId() - photoId - <{}>", id.toString());
            Object response = clientPhoto.getPhotoById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            log.error("buscarPhotoPorId() - [ERRO] - <{}>", e.getMessage());
            throw new InvalidPhotoException("Busca de photo com problemas");
        }
    }
}
