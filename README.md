# Sistema Acadêmico Web

**Equipe**: Ana Vitória Lima, Anderson de Freitas, Pérolla da Silva e Yara França. 

Esse Sistema foi desenvolvido com o intuito de auxiliar instituições de ensino, como escolas, no cadastro de alunos e professores, além de dividir os campos que cada um pode ter acesso, como **Disciplinas**, **Carga Horaria**, **CPF**, **Gmail**, **ID**, **Matrícula** e **Salario**.

---

## Tecnologias e Versões Utilizadas

- **Java**: Versão 17
- **JDK**: Amazon Corretto 17
- **Spring Boot**: Versão 3.4.0

---

## Dependências e Versões

- **Spring Data JPA**: 3.1.0
- **Spring Boot Starter Validation**: 3.1.0
- **Lombok**: 1.18.28
  
**Spring Boot**
- spring-boot-starter-data-jpa - Suporte para JPA (Java Persistence API).
- spring-boot-starter-web - Desenvolvimento de aplicações web RESTful.
- spring-boot-devtools - Ferramenta de desenvolvimento para recarregamento automático durante o desenvolvimento.
- spring-boot-starter-test - Dependência para testes unitários e de integração.

**Outras Dependências**
lombok - Geração automática de código (como getters, setters e construtores).

---

## Bancos de Dados
- postgresql - Conector JDBC para PostgreSQL.

---

## Configurações do Banco de Dados

- **PgAdmin 4**:Postgree 17.2
- **Estrutura do Banco de Dados**:(https://onecompiler.com/mysql/42wkvj6xe)
  
## Credenciais de Acesso
- **Host**: Endereço do servidor onde o banco de dados está hospedado
- **Porta**: Número da porta usada para a comunicação com o banco de dados
- **Usuário**: Nome do usuário com permissões para acessar o banco de dados.
- **Senha**: Senha associada ao usuário mencionado.
- **Database**: Nome do banco de dados ao qual deseja se conectar.

---

## Comandos Maven

### Realizar o Build do Projeto \ Executar o Projeto Localmente
```bash
mvn clean install
mvn spring-boot:run

```

## Classe Model 
- Se trata de uma Classe Modelo que sera usada para representar a tabela do banco de dados na API, de modo que os atributos correspondam as colunas da tabela, e é responsável pelas regras de negócio e pela interação com o banco de dados.

No caso foram feitas tres 3 Classes ModeL:

**AlunoModel**
- Atributos: Nome, Email e CPF.
- Chave Primaria: Matricula.
- Relacionamento: ManyToMany(AlunoModel\DisciplinaModel).
- Metodo: Set e Get.
  
**DisciplinaModel**
- Atributos: Nome e Carga-Horaria.
- Chave Primaria: ID
- Relacionamento: ManyToOne(ProfessorModel\DisciplinaModel)
                  ManyToMany(AlunoModel\DisciplinaModel).

**ProfessorModel**
- Atributos: Nome, Email e Salario.
- Chave Primaria: ID
- Relacionamento: ManyToOne(ProfessorModel\DisciplinaModel)


---

## Repository
- Trata-se de um padrão de projeto focado na persistemcia de dados, que faz parte da camada de negocios e fornrce objetos para outras camadas, como controle, sem depender da infraestrutura do banco de dados ou da tecnologia de conexão usada.
  
O codigo possui 3 Repositoty:

**AlunoRepository** **DisciplinaRepository**
**ProfessorRepository**


---

## Service
- É a parte que gerencia a lógica de negócio nas aplicações Java, especialmente em Spring, ele define as regras que controlam o comportamento da aplicação e gerencia as operações de persistencia de dados, interagindo com os repositorios para garantir o correto processamento das informações.

O codigo possui 3 Setvices:

**AlunoService** 
**DisciplinaService**
**ProfessorService**

- Medotos usados em cada um dos Services acima: Listar, buscar, salvar, atualizar, deletar

---

## Controller 
- É a intermediária entre o Front-end e a camada de negócios (Model-Service). Ela recebe as requisições do usuário, encaminha para a camada de negócios e retorna as respostas ao Front-end. Isso permite reutilizar a lógica de negócios em outros sistemas, já que não há dependência direta entre o Front-end e o Service.

O codigo possui 3 Controller:

**AlunoController** 
**DisciplinaController**
**ProfessorServiceController**

- O Controller executa todos os metodos apresentados no Service, ademais o metodo criar.

---

## Dockerfile e Docker-compose.yml

**Dockerfile**
- Ele é um arquivo de configuração usado para automatizar a criação de imagens Docker, contém instruções que definem como a imagem será construída, especificando desde o sistema operacional base até as dependências e configurações necessárias para rodar a aplicação.

- FROM: Define a imagem base usada na construção.
- COPY: Copia arquivos do sistema local para o contêiner.
- RUN: Executa comandos durante a criação da imagem, como instalar dependências.
- EXPOSE: Informa qual porta o contêiner usará para comunicação externa.

Ao criar um Dockerfile, a imagem resultante pode ser executada em qualquer ambiente que tenha Docker instalado, garantindo portabilidade e consistência no desenvolvimento e na produção.

---

**Docker-compose.yml**
- Ele é um arquivo de configuração usado para definir e gerenciar múltiplos contêineres Docker de forma simplificada, ademais ele permite especificar serviços, redes e volumes necessários para uma aplicação, facilitando o gerenciamento de ambientes complexos.

- Volumes: Define volumes para persistência de dados.
- Image: Especifica a imagem Docker a ser usada.
- Ports: Mapeia as portas do contêiner para a máquina host.
  

## Acesse aplicação 
Após a instalação dos pré-requisitos e iniciar a aplicação do projeto, clique no link:
- [http://localhost:8080](http://localhost:8080)



