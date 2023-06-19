package com.sistemadegerenciamentodeestacionamento.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadegerenciamentodeestacionamento.sge.model.Client;
public interface ClienteResitory extends JpaRepository<Client,Long>{
    
}
