package com.sistemadegerenciamentodeestacionamento.sge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadegerenciamentodeestacionamento.sge.model.Employee;
import com.sistemadegerenciamentodeestacionamento.sge.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<Object> listAll() {
        try {
            List<Employee> employees = employeeRepository.findAll();
            if (employees.size() != 0) {
                return ResponseEntity.ok().body(employees);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("não existe funcionarios cadastrados");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("houve um erro ao executar o recurso");
        }
    }

    // @PostMapping
    // public ResponseEntity<Object> save(@RequestBody Employee employee){
    //     employeeRepository.save(employee);
    //     return ResponseEntity.ok().body(employee);
    // }
}

