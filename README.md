# Desafio Backend Engineer – Nubank

Construir uma API REST para gerenciamento de clientes e seus contatos.  
Cada cliente pode ter um ou mais contatos associados.

---

## 🟣 Requisitos Técnicos

A aplicação deve conter os seguintes endpoints:

- **POST /clientes** — Cadastro de Cliente  
- **POST /contatos** — Cadastro de Contato associado a um cliente existente  
- **GET /clientes** — Listagem de todos os clientes com seus contatos  
- **GET /clientes/{id}/contatos** — Listagem de contatos de um cliente específico  

**Tecnologias obrigatórias:**
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Lombok  

**Boas práticas esperadas:**
- Separação entre Controller, Service/UseCase e Repository  
- Uso de DTOs  
- Tratamento adequado de erros  
- Clean Architecture sugerida  

**Diferenciais (opcionais):**
- Docker para PostgreSQL  
- Testes automatizados  
- Documentação com Swagger  

---


# 🧱 Estrutura do Projeto (Clean Architecture)

Solução proposta utilizando Clean Architecture:

src/main/java/com/challenge/backend/nubank/
│
├── NubankApplication.java
│
├── application/                 # Interface (entrada)
│   ├── controllers/
│   │   └── UserController.java
│   ├── dtos/
│   │   ├── request/
│   │   │   ├── CreateClientRequest.java
│   │   │   └── CreateContactRequest.java
│   │   └── response/
│   │       ├── ClientResponse.java
│   │       └── ContactResponse.java
│   └── mappers/
│       ├── ClientMapper.java
│       └── ContactMapper.java
│
├── domain/                      # Lógica de negócio (sem dependências externas)
│   ├── entities/
│   │   └── Client.java          # Entidade de DOMÍNIO
│   ├── contact/
│   │   └── Contact.java
│   ├── repositories/            # INTERFACES
│   │   ├── IClientRepository.java
│   │   └── IContactRepository.java
│   ├── usecases/                # Casos de uso (serviços de negócio)
│   │   ├── client/
│   │   │   ├── CreateClientUseCase.java
│   │   │   ├── GetClientUseCase.java
│   │   │   └── UpdateClientUseCase.java
│   │   └── contact/
│   │       ├── CreateContactUseCase.java
│   │       └── GetContactUseCase.java
│   ├── vos/                     # Value Objects
│   │   ├── ClientVO.java
│   │   └── ContactVO.java
│   └── exceptions/              # Exceções de negócio
│       ├── ClientNotFoundException.java
│       └── InvalidClientException.java
│
├── infrastructure/              # Implementação técnica (dependências externas)
│   ├── persistence/
│   │   ├── entities/            # JPA Entities
│   │   │   ├── ClientJpaEntity.java
│   │   │   └── ContactJpaEntity.java
│   │   └── repositories/        # Implementações
│   │       ├── ClientRepositoryImpl.java
│   │       └── ContactRepositoryImpl.java
│   └── mappers/
│       ├── ClientPersistenceMapper.java
│       └── ContactPersistenceMapper.java
│
├── config/
│   └── GlobalExceptionHandler.java   # Tratativa de Errors Globais
│
├── exceptions/
│   └── RepositoryException.java
│
├── shared/
│   ├── constants/
│   │   └── Constants.java
│   └── utils/
│       └── Validators/
│
└──
src/main/resources/
│   ├── application.yaml
│   └── db/
│       └── migration/
│           ├── V001__client_register.sql
│           └── V002__contact_register.sql

