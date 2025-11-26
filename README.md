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

## 🧱 Estrutura do Projeto (Clean Architecture)

Solução proposta utilizando Clean Architecture:

### Raiz do Projeto

```
src/main/java/com/challenge/backend/nubank/
├── NubankApplication.java
└── [Camadas abaixo]
```

### 📱 Camada de Aplicação (Interface)

Responsável por receber requisições e retornar respostas.

```
application/
├── controllers/
│   └── UserController.java                    # Endpoints da API
├── dtos/
│   ├── request/
│   │   ├── CreateClientRequest.java
│   │   └── CreateContactRequest.java
│   └── response/
│       ├── ClientResponse.java
│       └── ContactResponse.java
└── mappers/
    ├── ClientMapper.java
    └── ContactMapper.java
```

| Componente | Responsabilidade |
|-----------|-----------------|
| **Controllers** | Receber requisições HTTP e coordenar com os casos de uso |
| **DTOs** | Transferência de dados entre camadas (Request/Response) |
| **Mappers** | Conversão entre DTOs e domínio |

### 🎯 Camada de Domínio (Lógica de Negócio)

Núcleo da aplicação, independente de frameworks externos.

```
domain/
├── entities/
│   ├── Client.java                            # Entidade de domínio
│   └── Contact.java
├── repositories/
│   ├── IClientRepository.java                 # Interfaces (contrato)
│   └── IContactRepository.java
├── usecases/
│   ├── client/
│   │   ├── CreateClientUseCase.java
│   │   ├── GetClientUseCase. java
│   │   └── UpdateClientUseCase.java
│   └── contact/
│       ├── CreateContactUseCase.java
│       └── GetContactUseCase.java
├── vos/
│   ├── ClientVO.java                          # Value Objects
│   └── ContactVO.java
└── exceptions/
    ├── ClientNotFoundException.java
    └── InvalidClientException.java
```

| Componente | Responsabilidade |
|-----------|-----------------|
| **Entities** | Modelos de domínio com lógica de negócio |
| **Repositories (I)** | Contrato de persistência (sem implementação) |
| **UseCases** | Orquestração da lógica de negócio |
| **Value Objects** | Objetos imutáveis que representam conceitos do domínio |
| **Exceptions** | Exceções específicas do negócio |

### 🔧 Camada de Infraestrutura (Implementação Técnica)

Implementações concretas, dependências externas (BD, APIs, etc).

```
infrastructure/
├── persistence/
│   ├── entities/
│   │   ├── ClientJpaEntity.java               # Mapeamento JPA
│   │   └── ContactJpaEntity. java
│   └── repositories/
│       ├── ClientRepositoryImpl.java           # Implementação dos contratos
│       └── ContactRepositoryImpl.java
└── mappers/
    ├── ClientPersistenceMapper.java           # DTO → JPA Entity
    └── ContactPersistenceMapper.java
```

| Componente | Responsabilidade |
|-----------|-----------------|
| **JPA Entities** | Mapeamento para tabelas do banco de dados |
| **Repository Implementations** | Implementação das interfaces de repositório |
| **Persistence Mappers** | Conversão entre domínio e persistência |

### ⚙️ Configurações e Utilitários

```
config/
├── GlobalExceptionHandler.java                # Tratamento global de erros
└── [outras configurações]

exceptions/
└── RepositoryException.java                   # Exceções técnicas

shared/
├── constants/
│   └── Constants.java
└── utils/
    └── Validators/
        └── [validadores reutilizáveis]
```

### 📦 Recursos (Resources)

```
src/main/resources/
├── application. yaml                           # Configurações da aplicação
└── db/
    └── migration/
        ├── V001__client_register.sql
        └── V002__contact_register.sql
```

---

## 📊 Fluxo de Dados (Clean Architecture)

```
[HTTP Request]
      ↓
[Controller] (Application Layer)
      ↓
[Mapper DTO → Domain]
      ↓
[UseCase] (Domain Layer) ← Lógica de Negócio
      ↓
[Repository Interface]
      ↓
[Repository Implementation] (Infrastructure Layer)
      ↓
[JPA Entity → Database]
      ↓
[HTTP Response]
```

---

## 🎯 Princípios Aplicados

✅ **Inversão de Controle** - Dependências injetadas  
✅ **Single Responsibility** - Cada classe com uma responsabilidade  
✅ **Open/Closed** - Aberto para extensão, fechado para modificação  
✅ **Liskov Substitution** - Implementações podem substituir interfaces  
✅ **Interface Segregation** - Interfaces específicas e pequenas  
✅ **Dependency Inversion** - Dependência em abstrações, não em concreções
