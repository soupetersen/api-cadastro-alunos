# Sistema de Matrícula - API de Cadastro de Alunos

Uma simples Java Spring Boot API REST para gerenciamento de alunos da Escola Pequenas Crianças.
Estruturas separadas em controller, dtos, model, repository e service.

## Tecnologias Utilizadas

- Spring Boot 2.7.18
- Spring Data JPA
- MySQL
- Maven

## Pré-requisitos

- Java 11 ou superior
- MySQL 5.7 ou superior
- Maven 3.6 ou superior

## Configuração do Banco de Dados

1. Criar banco de dados MySQL:
```sql
CREATE DATABASE escola_pequenas_criancas;
```

2. Configurar credenciais no arquivo `src/main/resources/application.properties`:
```properties
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

## Como Executar

1. Clonar o repositório
2. Navegar até o diretório do projeto
3. Executar o comando:
```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em: http://localhost:8080

## Endpoints da API

### Listar todos os alunos
- **GET** `/api/alunos`
- Retorna lista de todos os alunos cadastrados
```json
  {
    "id": 5,
    "nome": "Mario Pinto",
    "idade": 8,
    "responsavel": "Jairo Silva",
    "turma": "1º Ano A"
},
{
    "id": 7,
    "nome": "Mario Pinto",
    "idade": 28,
    "responsavel": "Jairo Silva",
    "turma": "1º Ano A"
},
{
    "id": 9,
    "nome": "Mario Pinto",
    "idade": 28,
    "responsavel": "Jairo Silva",
    "turma": "1º Ano A"
}
```

### Buscar aluno por ID
- **GET** `/api/alunos/{id}`
- Retorna dados de um aluno específico
```json
{
  "id": 7,
  "nome": "Mario Pinto",
  "idade": 28,
  "responsavel": "Jairo Silva",
  "turma": "1º Ano A"
}
```

### Cadastrar novo aluno
- **POST** `/api/alunos`
- Body (JSON):
```json
{
  "id": 10,
  "nome": "Mario Pinto",
  "idade": 28,
  "responsavel": "Jairo Silva",
  "turma": "1º Ano A"
}
```

### Atualizar aluno
- **PUT** `/api/alunos/{id}`
- Body (JSON):
```json
{
  "id": 7,
  "nome": "João Santos Silva",
  "idade": 9,
  "responsavel": "Maria Santos Silva",
  "turma": "4º Ano B"
}
```

### Excluir aluno
- **DELETE** `/api/alunos/{id}`
- Desabilita o aluno do sistema (soft delete)
- O aluno não é removido fisicamente, apenas marcado como inativo com timestamp
- Fiz dessa forma, porque em bancos de produção, sempre queremos manter o histórico do usuário.
```json
{
    "success": true,
    "message": "Student disabled successfully",
    "data": null
}
```

### Excluir aluno permanentemente
- **DELETE** `/api/alunos/{id}/delete`
- Remove o aluno permanentemente do banco de dados
```json
{
  "success": true,
  "message": "Student permanently deleted",
  "data": null
}
```
