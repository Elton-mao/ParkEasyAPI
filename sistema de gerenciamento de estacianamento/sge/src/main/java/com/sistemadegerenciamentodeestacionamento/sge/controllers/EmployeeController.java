package com.sistemadegerenciamentodeestacionamento.sge.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadegerenciamentodeestacionamento.sge.model.Employee;
import com.sistemadegerenciamentodeestacionamento.sge.repositories.EmployeeRepository;
import com.sistemadegerenciamentodeestacionamento.sge.service.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

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

    @PostMapping("/{jobTitleId}")
    public ResponseEntity<Object> save(@RequestBody Employee employee, @PathVariable Long jobTitleId) {
        try {
            employeeService.saveEmployee(employee, jobTitleId);
            return ResponseEntity.ok().body(employee);    
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erro ao executar o recurso");
        }
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<Object> deleteEntity(@PathVariable Long id){
        try {
            employeeService.deleteByid(id);
            return ResponseEntity.ok().body("cliente deletedo com sucesso"+ id);    
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("não foi possivel realizar sua requisição");
        }
        

    }
    
    

}
