package com.sistemadegerenciamentodeestacionamento.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadegerenciamentodeestacionamento.sge.model.ParkingSpot;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot,Long>{
    
}
