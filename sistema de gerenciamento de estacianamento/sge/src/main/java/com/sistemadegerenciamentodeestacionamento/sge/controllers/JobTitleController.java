package com.sistemadegerenciamentodeestacionamento.sge.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadegerenciamentodeestacionamento.sge.model.JobTitle;
import com.sistemadegerenciamentodeestacionamento.sge.repositories.JobTitleRepository;

@RestController
@RequestMapping("/jobtitle")
public class JobTitleController {

    @Autowired
    private JobTitleRepository jTitleRepository;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            List<JobTitle> jobTitleList = jTitleRepository.findAll();
            //verifica se existe cargos cadastrados
            if (jobTitleList.size() != 0) {
                //retorna uma lisca com todos os dados
                return ResponseEntity.ok().body(jobTitleList);
            } else {
                // retorna uma mensagem de erro caso não exista cargos cadastrados
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NÃO EXISTE CARGOS CADASTRADOS");
            }
        } catch (Exception e) {
            //cassa ocorra um erro durante a execução
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("não foi possivel processar sua requisição tente novamente");
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody JobTitle jobTitle) {
        try {
            jTitleRepository.save(jobTitle);
            return ResponseEntity.ok().body("Cargo salvo com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi possivel executar o recurso tente novamente");
        }

    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        try {
            if (jTitleRepository.existsById(id)) {
                jTitleRepository.deleteById(id);
                return ResponseEntity.ok().body("Cargo Deletado Com Sucesso");   
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("id informado não encontrado");
            }
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("não foi possivel realizar sua requisição tente novamente");
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Object> findbyId(@PathVariable Long id){
        Optional<JobTitle> optionalJobTitle = jTitleRepository.findById(id);
       try {
        if (optionalJobTitle.isPresent()) {
            JobTitle jobTitle = optionalJobTitle.get();
            return ResponseEntity.ok().body(jobTitle);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("não foi encontrado nenhum cliente cadastrado com o ID informado! ");
        }
        
       } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Não foi possivel realizar sua requisição tente novamente");
       } 
    }

}