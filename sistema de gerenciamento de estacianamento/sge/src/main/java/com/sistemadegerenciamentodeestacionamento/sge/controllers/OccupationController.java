package com.sistemadegerenciamentodeestacionamento.sge.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sistemadegerenciamentodeestacionamento.sge.service.OccupationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/occupation")
public class OccupationController {
    
    @Autowired
    private OccupationService occupationService;
    
    @PostMapping("/{parkingSpotId}/occupy/{clientId}")
    public ResponseEntity<String> occupyParkingSpot(@PathVariable Long parkingSpotId, @PathVariable Long clientId){
        occupationService.occupyParkingSpot(parkingSpotId, clientId);
        return ResponseEntity.ok().body("metodo funcionando");
    }

    
}
