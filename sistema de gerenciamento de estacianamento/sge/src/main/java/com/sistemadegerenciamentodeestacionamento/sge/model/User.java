package com.sistemadegerenciamentodeestacionamento.sge.model;


import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(name = "user_name")
    @NotBlank(message = "CAMPO NÃO INFORMADO")
    private String name;
    @Column(name = "user_register_name", nullable = false,unique = true)
    @CPF(message = "NUMERO DE CPF DIGITADO INVALIDO")
    private String registerNumber;
    @Column(name = "user_phome", nullable = false,unique = true)
    @NotBlank(message = "CAMPO NÃO INFORMADO")
    private String phone;
    @Column(name = "user_email", nullable = false,unique = true)
    @Email
    private String email;

}
