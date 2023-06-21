package com.sistemadegerenciamentodeestacionamento.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadegerenciamentodeestacionamento.sge.model.JobTitle;

public interface JobTitleRepository extends JpaRepository<JobTitle,Long>{
    
}
