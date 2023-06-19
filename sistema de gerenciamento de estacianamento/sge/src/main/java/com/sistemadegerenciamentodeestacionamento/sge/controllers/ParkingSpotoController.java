package com.sistemadegerenciamentodeestacionamento.sge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadegerenciamentodeestacionamento.sge.model.ParkingSpot;
import com.sistemadegerenciamentodeestacionamento.sge.repositories.ParkingSpotRepository;

@RestController
@RequestMapping("/parking")
public class ParkingSpotoController {

    @Autowired
    private ParkingSpotRepository pRepository;
    
    // @Autowired
    // private ParkingSpotService parkingSpotService = new ParkingSpotService();

    @PostMapping
    public ResponseEntity<Object> createparkingspot(@RequestBody ParkingSpot parkingSpot) {
        try {
            parkingSpot.setAvailaber(true);
            pRepository.save(parkingSpot);
            return ResponseEntity.ok().body("vaga cadastrada com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi possivel executar o recurso tente novamente");
        }
        
    }

    // @PostMapping("/{parkingspotId}/occupy/{clientId}")
    // public ResponseEntity<String> occupyParkingSpot(@PathVariable Long parkingspotId, @PathVariable Long clientId){
    //     try {
    //         parkingSpotService.occupyParkingSpot(parkingspotId,clientId);
    //         return ResponseEntity.ok().body("vaga ocupada com sucesso");
    //     } catch (IllegalArgumentException e) {
    //         return ResponseEntity.badRequest().body(e.getMessage());
    //     }
    // }


}

