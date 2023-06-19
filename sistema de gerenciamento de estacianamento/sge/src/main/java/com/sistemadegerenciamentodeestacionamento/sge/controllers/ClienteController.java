package com.sistemadegerenciamentodeestacionamento.sge.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.sistemadegerenciamentodeestacionamento.sge.model.Client;
import com.sistemadegerenciamentodeestacionamento.sge.model.Vehicle;
import com.sistemadegerenciamentodeestacionamento.sge.repositories.ClienteResitory;
import com.sistemadegerenciamentodeestacionamento.sge.repositories.VehicleRepository;

@RequestMapping("/client")
@RestController
public class ClienteController {
  @Autowired
  private ClienteResitory cResitory;
  @Autowired
  private VehicleRepository vRepository;

  // retorna uma lista com todos os clientes cadastrados
  @GetMapping
  @ResponseBody
  public ResponseEntity<Object> findALl() {
    try {
      List<Client> listClients = cResitory.findAll();
      // verifica se existe cadastros de clientes no banco de dados
      if (listClients.size() != 0) {
        // retorna uma lista de clientes
        return ResponseEntity.ok().body(listClients);

      } else {
        // se não for encontrado nenhum cliente
        return ResponseEntity.ok().body("Não existem clientes cadastrados no momento.");
      }

    } catch (Exception e) {
      // caso ocorra algum erro na solicitação
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("Lamentamos, mas algo deu errado ao processar sua solicitação. Por favor, tente novamente mais tarde.");
    }
  }

  // Registra um Novo Cliente no banco de Dados
  @PostMapping("/save")
  public ResponseEntity<Object> saveClient(@RequestBody Client client) {
    try {
      // verifica se existe existe um veiculo cadastrado
      Vehicle vehicle = client.getVehicle();
      if (vehicle != null) {
        // cadastra o veiculo
        vehicle = vRepository.save(vehicle);
      }
      // salva o cliente e associa um veiculo
      client.setVehicle(vehicle);
      cResitory.save(client);
      return ResponseEntity.status(HttpStatus.OK).body("Cadastro realizado com sucesso");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Houve uma Falha ao Executar o recurso Salvar cliente!");
    }
  }

  // deleta um cliente pelo ID cadastrado
  @GetMapping("/delete/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    try {
      if (cResitory.existsById(id)) {
        cResitory.deleteById(id);
        return ResponseEntity.ok("cliente deletado com sucesso");
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Não encontrado Na base De Dados!! ");
      }
    } catch (Exception e) {

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao executar o Recurso!");

    }

  }

  // busca cliente por ID
  @GetMapping("/findbyid/{id}")
  @ResponseBody
  public ResponseEntity<Object> findById(@PathVariable Long id) {
    try {
      Optional<Client> optionalClient = cResitory.findById(id);
      if (optionalClient.isPresent()) {
        Client client = optionalClient.get();
        return ResponseEntity.ok().body(client);
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Não foi encontrado nenhum cliente com o ID informado na base de dados.");
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao executar o recurso.");
    }
  }

  // atualiza cadastro do Cliente
  @PutMapping("/update/{id}")
  public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Client clientDetails) {
    Optional<Client> optionalClient = cResitory.findById(id);
    try {
      if (optionalClient.isPresent()) {
        Client clientUpdate = optionalClient.get();
        clientUpdate.setName(clientDetails.getName());
        clientUpdate.setEmail(clientDetails.getEmail());
        clientUpdate.setPhone(clientDetails.getPhone());
        clientUpdate.setRegisterNumber(clientDetails.getRegisterNumber());

        if (clientUpdate.getVehicle() != null) {
          clientUpdate.getVehicle().setType(clientDetails.getVehicle().getType());
          clientUpdate.getVehicle().setPlateBoard(clientDetails.getVehicle().getPlateBoard());
        } else {
          clientUpdate.setVehicle(clientDetails.getVehicle());
        }

        cResitory.save(clientUpdate);
        return ResponseEntity.ok("Dados do Cliente Atualizados com Sucesso");
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o ID informado!");
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("não foi possivel executar sua requisição por favor tente novamente mais tarde");
    }
  }
}
