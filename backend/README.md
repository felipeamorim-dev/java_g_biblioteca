# Api para Gerenciar os Emprestimos de Livros



Esse api foi desenvolvida para compor meu portifólio profissional na área de desenvolvimento de software.  Ela consiste em um gerente de emprestimos de livros. 

Com essa api é possivel realizar o cadastro dos estudantes e mapear os livros que serão emprestados, armazenando o estado do processo em um banco de dados relacional e consultar o banco de dados sobre informações relacionada aos livros, inclusive a quantidade de exemplares que a biblioteca possui de um título.



## Tecnologias utilizadas

- Linguagem Java
- Framework Spring Boot
- Maven
- Toncat
- Banco de dados H2 e PostgreSQL
- Postman
- Swagger API



## URL de acesso a documentação da api



A documentação dessa api foi gerada a partir da API Swagger, dessa forma é possivel visualizar todos os endpoints do serviço prestado por essa aplicação. Para isso, execute a aplicação pelo terminal ou utilizando a sua IDE favorita. Pelo terminal, basta acessar a pasta raiz da aplicação e executar o seguinte comando

```bash
./mvnw spring-boot:run
```

A url de acesso a documentação estará localizada em:

```java
http://localhost:8080/swagger-ui.html
```

Lembrando que esse endereço é valida apenas para a configuraçlão de portas padrão utilizadas pelo Tomcat.

![Alt text](https://github.com/felipeamorim-dev/java_g_biblioteca/blob/main/doc_api.png)

 

### Instalação

Para realizar a instalação do projeto no perfil de  testar basta realizar o build utilizando o maven, como a seguir:

```java
mvn clean package
```

Execute o comando a partir da raiz do projeto. Após finalizar o processo de build, o arquivo jar da aplicação estará na pasta target. Com esse arquivo basta executar o comando

```java
Java -jar [nome_do_arquivo.jar]
```

para rodar a aplicação. 

No perfil de teste é utilizado o banco de dados H2 eno mesmo já possui alguns livros cadastrados para realizar os testes das funcionalidades da api. Para utilizar o PostgreSQL é necessário modificar para dev o perfil de desenvolvimento e modificar o arquivo application-dev.properties. É necessário criar o banco no Postegre (gbibli) e popular a tabelas de livros e seu estoque, como feito na versão de teste. 

Uma observação importante. Esse já possui todas as dependências necessárias para que a aplicação rode, inclusive o servidor tomcat embarcado.

Também podemos rodar a aplicação dentro de um container, paa isso, precisamos criar o arquivo Dockfile com os seguintes comandos

```dockerfile
FROM openjdk:11-jdk
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

Em seguida, podemos criar o container docker com a aplicação executando o seguinte comando pelo terminal

```bash
docker build -t [nome_do_container]
```

Após finalizar o processo de build da imagem podemos rodar a imagem em um container com o comando

```bash
docker run -p 8080 [id_da_imagem/nome_da_imagem]
```

Agora é possível acessar o local host na porta 8080 com os endpoints definidos na documentação para testar a aplicação.



