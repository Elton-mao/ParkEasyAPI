package com.sistemadegerenciamentodeestacionamento.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistemadegerenciamentodeestacionamento.sge.model.Occupation;


public interface OccupationRepository extends JpaRepository<Occupation,Long> {
    
}
