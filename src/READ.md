# Fórum Hub API

Uma API RESTful para gerenciar tópicos e discussões, desenvolvida no desafio promovido pela Alura em parceria com o programa Oracle Next Education.

##  Tecnologias Utilizadas
- **Linguagem**: Java 17
- **Framework**: Spring Boot (versão 3.3.5)
- **Banco de Dados**: MySQL (migrações gerenciadas pelo Flyway)
- **Gerenciamento de Dependências**: Maven
- **Validação e Segurança**: Spring Validation e Spring Security
- **Autenticação**: JWT (JSON Web Token)
- **Documentação**: Gerada automaticamente com Springdoc OpenAPI

## Dependências
As principais dependências do projeto incluem:
- `spring-boot-starter-web`: Criação de APIs RESTful.
- `spring-boot-starter-data-jpa`: Integração com banco de dados relacional.
- `spring-boot-starter-validation`: Validação de dados enviados.
- `spring-boot-starter-security`: Configuração de autenticação e autorização.
- `flyway-core`: Controle de migração de banco de dados.
- `lombok`: Redução de código repetitivo.
- `springdoc-openapi`: Geração de documentação interativa da API.
- `mysql-connector-java`: Driver para conexão com MySQL.

Todas as dependências podem ser verificadas no arquivo `pom.xml`.

## Funcionalidades
### 1. **Gerenciamento de Tópicos**
- **Cadastro**: Registre novos tópicos, com validação de dados.
- **Listagem**: Consulte tópicos cadastrados, com suporte a paginação e ordenação.
- **Detalhamento**: Obtenha informações completas de um tópico por ID.
- **Atualização**: Modifique dados de um tópico existente.
- **Exclusão Lógica**: Marque tópicos como inativos em vez de removê-los fisicamente.

### 2. **Autenticação e Segurança**
- Autenticação JWT para proteção de endpoints.
- Acesso controlado a recursos sensíveis para usuários autenticados.

## Como Executar o Projeto
1. Clone o repositório:
   ```bash  
   git clone <URL_DO_REPOSITORIO>  
