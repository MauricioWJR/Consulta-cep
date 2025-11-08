# Consulta-cep

**Aplicação para consultar informações de CEP utilizando Spring Boot, desenvolvida para a empresa OTI Software.**


## Descrição

Este projeto é uma API REST desenvolvida com Spring Boot 3.x que permite realizar consultas por **CEP**, **Logradouro** e **Cidade**. Além disso, a aplicação implementa um CRUD completo para gerenciar as informações dos CEPs.

## Tecnologias Usadas

## Tecnologias Usadas

- **Java 17**
- **Spring Boot 3.x**
- **JPA / Hibernate**
- **H2 Database** (Banco de dados em memória para desenvolvimento e testes)

## Estrutura do Projeto

- **controller**: Contém os controladores REST, responsáveis por expor os endpoints da API.
- **service**: Contém a lógica de negócios, que interage com os repositórios e implementa a lógica do sistema.
- **repository**: Contém os repositórios JPA, que realizam o acesso ao banco de dados.
- **model**: Contém as entidades JPA, que representam as tabelas do banco de dados.
- **exception**: Contém classes para tratamento de exceções personalizadas, como erros globais ou específicos da aplicação.
- **config**: Contém configurações adicionais do Spring Boot, como beans e propriedades específicas da aplicação.

