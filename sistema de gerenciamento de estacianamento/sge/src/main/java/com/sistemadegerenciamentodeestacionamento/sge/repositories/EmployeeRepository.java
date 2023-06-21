package com.sistemadegerenciamentodeestacionamento.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadegerenciamentodeestacionamento.sge.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    
}
 