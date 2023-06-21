package com.sistemadegerenciamentodeestacionamento.sge.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee extends User {
   
    @ManyToOne
    @JsonBackReference
    private JobTitle jobTitle;
}
