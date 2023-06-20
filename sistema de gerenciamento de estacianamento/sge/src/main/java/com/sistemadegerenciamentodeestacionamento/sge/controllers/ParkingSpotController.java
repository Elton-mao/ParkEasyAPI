package com.sistemadegerenciamentodeestacionamento.sge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadegerenciamentodeestacionamento.sge.model.ParkingSpot;
import com.sistemadegerenciamentodeestacionamento.sge.repositories.ParkingSpotRepository;

@RestController
@RequestMapping("/parking")
public class ParkingSpotController {

    @Autowired
    private ParkingSpotRepository pRepository;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            List<ParkingSpot> parkingSpots = pRepository.findAll();
            if(parkingSpots.size()!=0){
                return ResponseEntity.ok().body(parkingSpots);
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe Vagas Cadastradas no Momento");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("não foi possivel realizar executar a requisição tente novamente");        }

    }


    @PostMapping
    public ResponseEntity<Object> createparkingspot(@RequestBody ParkingSpot parkingSpot) {
        try {
            pRepository.save(parkingSpot);
            return ResponseEntity.ok().body("vaga cadastrada com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi possivel executar o recurso tente novamente");
        }

    }

}
