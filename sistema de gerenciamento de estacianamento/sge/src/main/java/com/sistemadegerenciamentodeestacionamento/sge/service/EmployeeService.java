package com.sistemadegerenciamentodeestacionamento.sge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemadegerenciamentodeestacionamento.sge.model.Employee;
import com.sistemadegerenciamentodeestacionamento.sge.model.JobTitle;
import com.sistemadegerenciamentodeestacionamento.sge.repositories.EmployeeRepository;
import com.sistemadegerenciamentodeestacionamento.sge.repositories.JobTitleRepository;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository eRepository; 

    @Autowired 
    JobTitleRepository jRepository;

    public void saveEmployee(Employee employee , Long id){
        if(id == null){
            throw new IllegalArgumentException("ID INVALIDO");
        }

        JobTitle jobTitle = jRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Id não existe no banco de dados"));
        employee.setJobTitle(jobTitle);
        eRepository.save(employee);
        
    }
}
