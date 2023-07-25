# ParkEasyAPI
 A "ParkEasyAPI" é uma API REST projetada para simplificar o gerenciamento de um estacionamento. Com uma interface fácil de usar e recursos intuitivos, essa API oferece uma solução eficiente para controlar e monitorar as operações de um estacionamento.


## Endpoints do Cliente

### Listar todos os clientes

Retorna uma lista com todos os clientes cadastrados.

**Endpoint:** `GET /client`

#### Resposta de Sucesso

Código de status: 200 OK

Exemplo de resposta:
```json
[
  {
    "id": 1,
    "name": "Nome do Cliente",
    "registerNumber": "Número de Registro",
    "phone": "Telefone do Cliente",
    "email": "Email do Cliente",
    "vehicle": {
      "id": 1,
      "type": "Tipo de Veículo",
      "plateBoard": "Placa do Veículo"
    }
  },
  {
    "id": 2,
    "name": "Nome do Cliente",
    "registerNumber": "Número de Registro",
    "phone": "Telefone do Cliente",
    "email": "Email do Cliente",
    "vehicle": null
  }
]
```

#### Resposta de Sucesso (sem clientes cadastrados)

Código de status: 200 OK

Exemplo de resposta:
```json
"Não existem clientes cadastrados no momento."
```

### Cadastrar um novo cliente

Registra um novo cliente no banco de dados.

**Endpoint:** `POST /client/save`

#### Corpo da Solicitação

Exemplo de corpo da solicitação:
```json
{
  "name": "Nome do Cliente",
  "registerNumber": "Número de Registro",
  "phone": "Telefone do Cliente",
  "email": "Email do Cliente",
  "vehicle": {
    "type": "Tipo de Veículo",
    "plateBoard": "Placa do Veículo"
  }
}
```

#### Resposta de Sucesso

Código de status: 200 OK

Exemplo de resposta:
```
Cadastro realizado com sucesso
```

### Deletar um cliente

Deleta um cliente pelo ID cadastrado.

**Endpoint:** `GET /client/delete/{id}`

#### Parâmetros de Path

- `id` (obrigatório): ID do cliente a ser deletado.

#### Resposta de Sucesso

Código de status: 200 OK

Exemplo de resposta:
```
Cliente deletado com sucesso
```

#### Resposta de Erro (cliente não encontrado)

Código de status: 404 Not Found

Exemplo de resposta:
```
Cliente não encontrado na base de dados
```

### Buscar cliente por ID

Busca um cliente pelo ID.

**Endpoint:** `GET /client/findbyid/{id}`

#### Parâmetros de Path

- `id` (obrigatório): ID do cliente a ser buscado.

#### Resposta de Sucesso

Código de status: 200 OK

Exemplo de resposta:
```json
{
  "id": 1,
  "name": "Nome do Cliente",
  "registerNumber": "Número de Registro",
  "phone": "Telefone do Cliente",
  "email": "Email do Cliente",
  "vehicle": {
    "id": 1,
    "type": "Tipo de Veículo",
    "plateBoard": "Placa do Veículo"
  }
}
```

#### Resposta de Erro (cliente não encontrado)

Código de status: 404 Not Found

Exemplo de resposta:
```
Não foi encontrado nenhum cliente com o ID informado na base de dados.
```

### Atualizar cadastro do cliente

Atualiza o cadastro do cliente.

**Endpoint:** `PUT /client/update/{id}`

#### Parâmetros de

 Path

- `id` (obrigatório): ID do cliente a ser atualizado.

#### Corpo da Solicitação

Exemplo de corpo da solicitação:
```json
{
  "name": "Nome do Cliente",
  "registerNumber": "Número de Registro",
  "phone": "Telefone do Cliente",
  "email": "Email do Cliente",
  "vehicle": {
    "type": "Tipo de Veículo",
    "plateBoard": "Placa do Veículo"
  }
}
```

#### Resposta de Sucesso

Código de status: 200 OK

Exemplo de resposta:
```
Dados do Cliente Atualizados com Sucesso
```

#### Resposta de Erro (cliente não encontrado)

Código de status: 404 Not Found

Exemplo de resposta:
```
Não foi possível encontrar o ID informado!
```
Aqui está a documentação para o controller `ParkingSpotoController` com o método `createparkingspot`:

## ParkingSpotController

Este controller lida com as operações relacionadas ao cadastro de vagas de estacionamento.

### Método

#### Cadastrar uma vaga de estacionamento

`POST /parking`

Este método permite cadastrar uma nova vaga de estacionamento.

##### Corpo da solicitação

```json
{
  "spotNumber": 123,
  "isAvailaber": true,
  "allowedVehicleType": "car"
}
```

- `spotNumber` (obrigatório): Número da vaga de estacionamento.
- `isAvailaber` (obrigatório): Indica se a vaga está disponível (true) ou não (false).
- `allowedVehicleType` (opcional): Tipo de veículo permitido na vaga de estacionamento.

##### Resposta

###### Códigos de resposta

- `200 OK`: A vaga de estacionamento foi cadastrada com sucesso.
- `404 Not Found`: Ocorreu um erro ao cadastrar a vaga de estacionamento.
- `500 Internal Server Error`: Ocorreu um erro interno ao processar a solicitação.

###### Exemplo de solicitação

```
POST /parking

{
  "spotNumber": 123,
  "isAvailaber": true,
  "allowedVehicleType": "car"
}
```

###### Exemplo de resposta de sucesso

```
200 OK
"vaga cadastrada com sucesso"
```

###### Exemplo de resposta de erro

```
404 Not Found
"Não foi possível executar o recurso. Tente novamente."
```

###### Exemplo de resposta de erro (erro interno do servidor)

```
500 Internal Server Error
"Ocorreu um erro interno ao processar a solicitação."
```
Aqui está a documentação para o controller `OccupationController` com o método `occupyParkingSpot`:

## OccupationController

Este controller lida com as operações relacionadas à ocupação de vagas de estacionamento.

### Método

#### Ocupa uma vaga de estacionamento

`POST /occupation/{parkingSpotId}/occupy/{clientId}`

Este método permite ocupar uma vaga de estacionamento, associando um cliente à vaga específica.

##### Parâmetros da URL

- `{parkingSpotId}` (obrigatório): O ID da vaga de estacionamento que será ocupada.
- `{clientId}` (obrigatório): O ID do cliente que ocupará a vaga.

##### Resposta

###### Códigos de resposta

- `200 OK`: A vaga de estacionamento foi ocupada com sucesso.
- `404 Not Found`: A vaga de estacionamento ou o cliente não foram encontrados.
- `500 Internal Server Error`: Ocorreu um erro ao processar a solicitação.

###### Exemplo de solicitação

```
POST /occupation/123/occupy/456
```

###### Exemplo de resposta de sucesso

```
200 OK
"metodo funcionando"
```

###### Exemplo de resposta de erro (vaga de estacionamento não encontrada)

```
404 Not Found
"A vaga de estacionamento não foi encontrada."
```

###### Exemplo de resposta de erro (cliente não encontrado)

```
404 Not Found
"O cliente não foi encontrado."
```

###### Exemplo de resposta de erro (erro interno do servidor)

```
500 Internal Server Error
"Ocorreu um erro ao processar a solicitação."
```


### EmployeeController  

**Endpoint: GET /employee**
- Descrição: Obtém a lista de todos os funcionários cadastrados.
- Resposta de Sucesso (200 OK):
  - Corpo: Lista de objetos do tipo Employee contendo os detalhes dos funcionários cadastrados.
- Resposta de Erro (404 Not Found):
  - Corpo: "Não existe funcionários cadastrados".
- Resposta de Erro (500 Internal Server Error):
  - Corpo: "Houve um erro ao executar o recurso".

**Endpoint: POST /employee/{jobTitleId}**
- Descrição: Cadastra um novo funcionário associado a um cargo específico.
- Corpo da Requisição: Objeto JSON representando os detalhes do novo funcionário.
- Parâmetro: jobTitleId (tipo: Long) - ID do cargo ao qual o funcionário será associado.
- Resposta de Sucesso (200 OK):
  - Corpo: Objeto JSON contendo os detalhes do funcionário recém-cadastrado.
- Resposta de Erro (500 Internal Server Error):
  - Corpo: "Erro ao executar o recurso".

**Endpoint: GET /employee/delete/{id}**
- Descrição: Exclui um funcionário pelo seu ID.
- Parâmetro: id (tipo: Long) - ID do funcionário a ser excluído.
- Resposta de Sucesso (200 OK):
  - Corpo: "Funcionário deletado com sucesso {id}".
- Resposta de Erro (500 Internal Server Error):
  - Corpo: "Não foi possível realizar sua requisição".

**Endpoint: PUT /employee/update/{id}**
- Descrição: Atualiza as informações de um funcionário existente pelo seu ID.
- Parâmetro: id (tipo: Long) - ID do funcionário a ser atualizado.
- Corpo da Requisição: Objeto JSON contendo os novos detalhes do funcionário.
- Resposta de Sucesso (200 OK):
  - Corpo: "Funcionário atualizado com sucesso".
- Resposta de Erro (500 Internal Server Error):
  - Corpo: "Erro ao executar o recurso".


### JobTitleController

**Endpoint: GET /jobtitle**
- Descrição: Obtém a lista de todos os cargos cadastrados.
- Resposta de Sucesso (200 OK):
  - Corpo: Lista de objetos do tipo JobTitle contendo os detalhes dos cargos cadastrados.
- Resposta de Erro (404 Not Found):
  - Corpo: "NÃO EXISTE CARGOS CADASTRADOS".
- Resposta de Erro (400 Bad Request):
  - Corpo: "Não foi possível processar sua requisição, tente novamente".

**Endpoint: POST /jobtitle**
- Descrição: Cadastra um novo cargo.
- Corpo da Requisição: Objeto JSON representando os detalhes do novo cargo.
- Resposta de Sucesso (200 OK):
  - Corpo: "Cargo salvo com sucesso".
- Resposta de Erro (404 Not Found):
  - Corpo: "Não foi possível executar o recurso, tente novamente".

**Endpoint: GET /jobtitle/delete/{id}**
- Descrição: Exclui um cargo pelo seu ID.
- Parâmetro: id (tipo: Long) - ID do cargo a ser excluído.
- Resposta de Sucesso (200 OK):
  - Corpo: "Cargo Deletado Com Sucesso".
- Resposta de Erro (404 Not Found):
  - Corpo: "ID informado não encontrado".
- Resposta de Erro (500 Internal Server Error):
  - Corpo: "Não foi possível realizar sua requisição, tente novamente".

**Endpoint: GET /jobtitle/findbyid/{id}**
- Descrição: Obtém os detalhes de um cargo pelo seu ID.
- Parâmetro: id (tipo: Long) - ID do cargo a ser buscado.
- Resposta de Sucesso (200 OK):
  - Corpo: Objeto JSON contendo os detalhes do cargo encontrado.
- Resposta de Erro (404 Not Found):
  - Corpo: "Não foi encontrado nenhum cargo cadastrado com o ID informado!".
- Resposta de Erro (500 Internal Server Error):
  - Corpo: "Não foi possível realizar sua requisição, tente novamente".


