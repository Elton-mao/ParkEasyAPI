package com.sistemadegerenciamentodeestacionamento.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadegerenciamentodeestacionamento.sge.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Long>{
    
}
