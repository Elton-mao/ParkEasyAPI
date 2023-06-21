package com.sistemadegerenciamentodeestacionamento.sge.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sistemadegerenciamentodeestacionamento.sge.service.OccupationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/occupation")
public class OccupationController {
    
    @Autowired
    private OccupationService occupationService;
    
    // ocupa a vaga do estacionamento recebendo um cliente é uma vaga
    @PostMapping("/{parkingSpotId}/occupy/{clientId}")
    public ResponseEntity<String> occupyParkingSpot(@PathVariable Long parkingSpotId, @PathVariable Long clientId){
       try {
        occupationService.occupyParkingSpot(parkingSpotId, clientId);
        return ResponseEntity.ok().body("vaga ocupada com sucesso");
       } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("não foi possivel realizar sua requisição");
       } 
    }
}
