package com.sistemadegerenciamentodeestacionamento.sge.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client extends User {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    @JsonManagedReference
    private Vehicle vehicle;
   
    @JsonIgnore
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private List<Occupation> occupations;


}
