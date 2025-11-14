# 🏦 EasyFin - Back-end

> Back-end em Java (Spring Boot) desenvolvido para o projeto de Análise e Desenvolvimento de Sistemas da FIAP.

## 📖 Sobre o Projeto

Este repositório contém o código-fonte do **back-end** do projeto EasyFin. A aplicação foi desenvolvida como parte do curso de **Análise e Desenvolvimento de Sistemas** na **FIAP**.

O objetivo principal deste back-end é fornecer uma API RESTful para realizar as operações de CRUD (Create, Read, Update, Delete), gerenciando a conexão e a persistência dos dados com o banco de dados.

## 🛠️ Tecnologias Utilizadas

Esta é a pilha de tecnologia usada no desenvolvimento:

* **Linguagem Principal:** Java 21
* **Framework Core:** Spring Boot 3.5.7
* **Banco de Dados:** Oracle Database
* **Gerenciador de Dependências:** Maven

## 🏁 Como Rodar o Projeto

Siga os passos abaixo para executar o projeto localmente.

### Pré-requisitos

* Java JDK 21 ou superior
* Apache Maven
* Uma instância do Oracle Database acessível.
* **Importante:** É necessário criar o banco de dados (schema/tabelas) antes de executar a aplicação.

### Instalação e Execução

1.  Clone o repositório:
    ```bash
    git clone [https://github.com/vitorolivacoelho/easyfin.git](https://github.com/vitorolivacoelho/easyfin.git)
    ```
    *(Substitua `easyfin.git` pelo nome do seu repositório se for diferente)*

2.  Acesse a pasta do projeto:
    ```bash
    cd easyfin
    ```

3.  Configure suas credenciais do Oracle Database no arquivo `src/main/resources/application.properties`.

4.  Compile o projeto e instale as dependências (isso criará a pasta `target` e o arquivo `.jar`):
    ```bash
    mvn clean install
    ```

5.  Execute a aplicação:
    ```bash
    java -jar target/easyfin-0.0.1-SNAPSHOT.jar
    ```
    *(O nome do arquivo .jar pode variar. Verifique o nome gerado na pasta `target` após o passo 4)*

6.  A API estará disponível em `http://localhost:8080`.

## ✒️ Autor

<img src="https://github.com/vitorolivacoelho.png" alt="Foto de Vitor Oliva Coelho" width="200" style="border-radius:50%; border: 2px solid #333; padding: 3px;"/>
<br>

* **Vitor Oliva Coelho** - dev backend
* LinkedIn: [https://www.linkedin.com/in/vitorolivacoelho/](https://www.linkedin.com/in/vitorolivacoelho/)
