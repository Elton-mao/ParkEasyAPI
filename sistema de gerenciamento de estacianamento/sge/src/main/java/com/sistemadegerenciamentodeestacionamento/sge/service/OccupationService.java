package com.sistemadegerenciamentodeestacionamento.sge.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemadegerenciamentodeestacionamento.sge.model.Client;
import com.sistemadegerenciamentodeestacionamento.sge.model.Occupation;
import com.sistemadegerenciamentodeestacionamento.sge.model.ParkingSpot;
import com.sistemadegerenciamentodeestacionamento.sge.repositories.ClienteResitory;
import com.sistemadegerenciamentodeestacionamento.sge.repositories.OccupationRepository;
import com.sistemadegerenciamentodeestacionamento.sge.repositories.ParkingSpotRepository;

@Service
public class OccupationService {
    @Autowired
    private ClienteResitory cResitory;
    @Autowired
    private ParkingSpotRepository pRepository;
    
    @Autowired 
    private OccupationRepository occupationRepository;
   
    public void occupyParkingSpot(Long parkingSpotId, Long clientId) {
        if (parkingSpotId == null) {
            throw new IllegalArgumentException("ID da vaga de estacionamento inválido");
        }
    
        ParkingSpot parkingSpot = pRepository.findById(parkingSpotId)
                .orElseThrow(() -> new IllegalArgumentException("Essa vaga não existe"));
    
        if (clientId == null) {
            throw new IllegalArgumentException("ID do cliente é inválido");
        }
    
        Client client = cResitory.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não existe"));
    
        Occupation occupation = new Occupation();
        occupation.setClient(client);
        occupation.setParkingSpot(parkingSpot);
        occupation.setOccupationDateTime(LocalDateTime.now());
        occupationRepository.save(occupation);
    
    }
    

}
