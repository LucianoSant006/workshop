# Projeto workshop 
## Este projeto consiste em uma API REST desenvolvida em Java com Spring Boot que permite a realização de operações CRUD em usuário e associação usando arquitetura MVC
## Vários tipos de associações entre entidades de varios relacionamentos usando ORM exemplo: @OneToOne,@OneToMany,@ManyToMany
## Implementando uma Consulta com @Query fazendo uma busca de usuários usando o Like e Query Parameters exemplo
# Tecnologias usadas: Postman, Banco de dados H2, Spring Boot,Maven
## Linguagem usada: Java

<div style="display: flex; gap: 1000px;">
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postman/postman-original.svg" alt="Logo do Postman" width="100" height="100">
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/maven/maven-original.svg" alt="Logo do Maven" width="100" height="100">
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="Logo do Java" width="100" height="100">
    <img src="https://www.h2database.com/html/images/h2-logo-2.png" alt="Logo do H2 Database" width="100" height="100">

</div>

# UML     
## Domain Model
 <img src="https://github.com/user-attachments/assets/cd37579d-b72f-438a-8bb6-bdddd6e49f21" alt="Domain Model" width="800" height="600">

 ## Api Users 
#  Get all users GET /suppliers Route : localhost:8080/users Return:

```json
[
  {
    "id": 1,
    "name": "Maria Brown",
    "email": "maria@gmail.com",
    "phone": "988888888",
    "password": "123456"
  },
  {
    "id": 2,
    "name": "Alex Green",
    "email": "alex@gmail.com",
    "phone": "977777777",
    "password": "123456"
  }
]
```

# Api Users Add new user POST/users route: localhost:8080/users
Content-Type: application/json

## seend

 ```json
{
  "id": null,
  "name": "Luciano Santiago",
  "email": "santiagoluciano@gmail.com",
  "phone": "23232-242",
  "password": "Eazy2324"
}

```
# Return
### Location: http://localhost:8080/users/3
### Content-Type: application/json
### Transfer-Encoding: chunked
### Date: Tue, 12 Nov 2024 17:34:35 GMT

## Get specific user GET / users Route : localhost:8080/users/{id_users}
## Update specific user Update  / users  Route : localhost:8080/users/{id_users}
 ```json
{
  "id": 3,
  "name": "Luciano Santiago",
  "email": "santiagoluciano@gmail.com",
  "phone": "23232-242",
  "password": "Eazy2324"
}
```
 ## JSON da API de Orders
# GET http://localhost:8080/ordes

 ```json
 [
  {
    "id": 1,
    "moment": "2019-06-20T19:53:07Z",
    "orderStatus": "PAID",
    "client": {
      "id": 1,
      "name": "Maria Brown",
      "email": "maria@gmail.com",
      "phone": "988888888",
      "password": "123456"
    },
    "items": [
      {
        "quantity": 2,
        "price": 90.5,
        "subTotal": 181.0
      },
      {
        "quantity": 1,
        "price": 1250.0,
        "subTotal": 1250.0
      }
    ],
    "payment": {
      "id": 1,
      "moment": "2019-06-20T20:53:07Z"
    },
    "total": 1431.0
  },
  {
    "id": 2,
    "moment": "2019-07-21T03:42:10Z",
    "orderStatus": "WAITING_PAYMENT",
    "client": {
      "id": 2,
      "name": "Alex Green",
      "email": "alex@gmail.com",
      "phone": "977777777",
      "password": "123456"
    },
    "items": [
      {
        "quantity": 2,
        "price": 1250.0,
        "subTotal": 2500.0
      }
    ]
```
## Implementei uma consulta com nativeQuery usando Query Parameters 
## Busca os usúarios por id ou pela inicial de um nome apenas uma letra listando todos podendo customizar a busca 
## Get  /users/search? GET /users/search? Route : localhost:8080/users/search?{id_users} or localhost:8080/users/search?{name_users} and localhost:8080/users/search?/{id_users}and{name_users}

## Exemplo de Query Parameters http://localhost:8080/users/search?name=Ma Return:

```json
 {
        "id": 1,
        "name": "Maria Brown",
        "email": "maria@gmail.com",
        "phone": "988888888",
        "password": "123456"
    },
    {
        "id": 3,
        "name": "Marta Oliveira",
        "email": "marta.oliveira@example.com",
        "phone": "31987654321",
        "password": "senha789"
    },
    {
        "id": 5,
        "name": "Matheus Lima",
        "email": "matheus.lima@example.com",
        "phone": "51987654321",
        "password": "senha202"
    },
    {
        "id": 8,
        "name": "Maurício Mendes",
        "email": "mauricio.mendes@example.com",
        "phone": "81987654321",
        "password": "senha505"
    },
    {
        "id": 10,
        "name": "Mariana Rocha",
        "email": "mariana.rocha@example.com",
        "phone": "11999887766",
        "password": "senha707"
    }
```

