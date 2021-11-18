# Api para Gerenciar os Emprestimos de Livros



Esse api foi desenvolvida para compor meu portifólio profissional na área de desenvolvimento de software.  Ela consiste em um gerente de emprestimos de livros. 

Com essa api é possivel realizar o cadastro dos estudantes e mapear os livros que serão emprestados, armazenando o estado do processo em um banco de dados relacional e consultar o banco de dados sobre informações relacionada aos livros, inclusive a quantidade de exemplares que a biblioteca possui de um título.



## Tecnologias utilizadas

- Linguagem Java
- Framework Spring Boot
- Maven
- Banco de dados H2 e MySql
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

* /students -> Realiza a persistencia dos dados do aluno no banco de dados da biblioteca.
* /loan -> Adiciona livros como itens a serem emprestados
* /loan/create -> Vincula o emprestimo ao aluno iserindo no banco de dados todas as informações pertinentes a transação realizada.



### Método PUT

* /students/registration/{registration} -> Atualiza os dados sobre o estudante no banco de dados.



### Método DELETE

* /students/{id} -> Retira do banco de dados as informações sobre o aluno
* /students/{registration} -> Retira do banco de dados as informações sobre o aluno.

 