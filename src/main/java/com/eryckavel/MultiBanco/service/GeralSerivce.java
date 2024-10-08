package com.eryckavel.MultiBanco.service;

import com.eryckavel.MultiBanco.model.Geral;
import com.eryckavel.MultiBanco.repository.GeralRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GeralSerivce {

    @Autowired
    private GeralRepository repository;

    public ResponseEntity<List<Geral>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

}
