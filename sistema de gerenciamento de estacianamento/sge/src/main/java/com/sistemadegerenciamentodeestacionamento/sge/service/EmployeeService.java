package com.sistemadegerenciamentodeestacionamento.sge.service;

import java.util.Optional;

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
    //registra um funcionario no banco de dados
    public void saveEmployee(Employee employee , Long id){
        if(id == null){
            throw new IllegalArgumentException("ID NÃO INFORMADO");
        }

        JobTitle jobTitle = jRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Id não existe no banco de dados"));
        employee.setJobTitle(jobTitle);
        eRepository.save(employee);
        
    }
    //busca um funcionario pelo id e deleta
    public void deleteByid(Long id){
        if(id != null ){
            eRepository.deleteById(id);
        }
        else{
            throw new IllegalArgumentException("ID NÃO INFORMADO"); 
        }
    }

    //atualiza o resitro do funcionario no banco de Dados
    public void employeeUpdate(Long id , Employee employeeDetails){
        Optional<Employee> optinalemployee = eRepository.findById(id);
       if(optinalemployee.isPresent()){
        Employee employeeUpdate = optinalemployee.get();
        employeeUpdate.setEmail(employeeDetails.getEmail());
        employeeUpdate.setJobTitle(employeeDetails.getJobTitle());
        employeeUpdate.setName(employeeDetails.getName());
        employeeUpdate.setRegisterNumber(employeeDetails.getRegisterNumber());
        eRepository.save(employeeUpdate);
       }
    }
}
