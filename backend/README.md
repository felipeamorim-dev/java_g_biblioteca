# Api para Gerenciar os Emprestimos de Livros



Esse api foi desenvolvida para compor meu portifólio profissional na área de desenvolvimento de software.  Ela consiste em um gerente de emprestimos de livros. 

Com essa api é possivel realizar o cadastro dos estudantes e mapear os livros que serão emprestados, armazenando o estado do processo em um banco de dados relacional e consultar o banco de dados sobre informações relacionada aos livros, inclusive a quantidade de exemplares que a biblioteca possui de um título.



## Tecnologias utilizadas

- Linguagem Java
- Framework Spring Boot
- Maven
- Banco de dados H2 e PostgreSQL
- Postman



## URL de acesso a api



### Método GET

* /students/{id} -> Recupera os dados sobre o estudante cadastrado.
* /registration/{registration} ->  Recupera os dados sobre o estudante cadastrado através do seu número de registro.
* /sections -> Recupera todas as seções da biblioteca.
* /sections/{id} -> Recupera os dados de apenas uma seção da biblioteca.
* /books -> Recupera todos os dados sobre os livros de forma paginada.
* /books/{isbn} -> Recupera os dados de um livro através de seu código de identificação internacional.
* /loan/{id} -> Recupera os dados sobre o emprestimo realizado para um estudante especifico. 



### Método POST

* /students -> Realiza a persistencia dos dados do aluno no banco de dados da biblioteca. Os atributos que devem compor o corpo do método são: registro, nome, curso e período.
* /loan -> Adiciona livros como itens a serem emprestados. No corpo do método deve conter pelo menois o isbn do livro para que internamente seja referenciado corretamento o livro que deseja adiciona a lista de livros emprestados.
* /loan/create -> Vincula o emprestimo ao aluno iserindo no banco de dados todas as informações pertinentes a transação realizada. Obs: A transação será realizada quando a lista de livros a emprestar não for nula.



### Método PUT

* /students/registration/{registration} -> Atualiza os dados sobre o estudante no banco de dados.



### Método DELETE

* /students/{id} -> Retira do banco de dados as informações sobre o aluno
* /students/{registration} -> Retira do banco de dados as informações sobre o aluno.

 

### Instalação

Para realizar a instalação do projeto no perfil de  testar basta realizar realizar o build utilizando o maven, como a seguir:

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



