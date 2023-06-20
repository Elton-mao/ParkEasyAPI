# ParkEasyAPI
 A "ParkEasyAPI" é uma API REST projetada para simplificar o gerenciamento de um estacionamento. Com uma interface fácil de usar e recursos intuitivos, essa API oferece uma solução eficiente para controlar e monitorar as operações de um estacionamento.

Certamente! Aqui está a atualização da documentação dos endpoints com os dados fornecidos:

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

