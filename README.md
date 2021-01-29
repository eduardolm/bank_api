
# Banking API
![License](src/main/resources/static/img/MIT.svg)
![Version](src/main/resources/static/img/version-v100.svg)
![Coverage](src/main/resources/static/img/coverage.svg)
## Objetivo
Criar uma API para cadastro e abertura de conta bancária. Essa API visa automatizar as etapas de criação de conta, desde o pré-cadastramento até a criação da conta e realização de transferências bancárias.

O fluxo das etapas foi dividido de forma diminuir a quantidade de informações a serem preenchidas em cada etapa, minimizando a possibildade de perda das infrmações por falhas de rede, bateria fraca de celular e outras possibilidades.

### Fluxo de informações
#### Pré-cadastro
Nessa etapa inicial, o ciente preenche apenas informações básicas como:
 - Nome
 - Sobrenome
 - E-mail
 - Data de nascimento
 - CPF
 
#### Cadastro de endereço
Nessa etapa, o cliente disponibiliza informações sobre seu endereço:
 - CEP
 - Rua
 - Bairro
 - Complemento
 - Cidade
 - Estado
 
 #### Envio de documentos
 Nessa etapa, o cliente envia foto do CPF
 
 #### Revisão e aprovação da proposta
 Nessa fase do processo, o cliente recebe todos os dados para revisar. Pode ainda aceitar ou recusar a proposta.
 Em caso de recusa, sua proposta é armazenada e um e-mail é enviado ao cliente.
 Em caso de aceite, o cliente recebe um e-mail informando que sua conta será criada, e os dados são enviados ao parceiro para aprovação e posterior criação da conta.
 
 #### Criação da conta
 Após aprovação pelo parceiro, a conta é criada e o cliente recebe um e-mail com as informações da conta.
 
 #### Primeiro acesso
 De posse das informações da conta, o cliente procede ao primeiro acesso à sua conta, informando CPF e e-mail.
 Essa validação ocorre com a geração de um token, enviado ao cliente por e-mail.
 O cliente utiliza o token, uma senha temporária é gerada e enviada ao e-mail do cliente.
 
 #### Transferência
 A API deve também possibilitar o recebimento de transferencias bancárias, armazenando todas as informações pertinentes e atualizado o saldo da conta.
 
 ## Tecnologias utilizadas
  + Java 11
  + Spring Boot 2.3.4
  + Maven 3.6.3
  + JPA
  + H2 database
  + Docker
    + LocalStack
        + AWS S3
  + Github
  + Junit
## Como utilizar
Para executar est aplicação é preciso ter o Java versão 11 instalado na máquina.
É recomendado utilizar uma IDE como VS Code ou IntelliJ IDEA, o que permite compilar o programa para versões diferentes do Java.
Podem ocorrer erros caso sejam utilizadas versões inferiores ou superiores do Java.

Utilizando sua IDE preferida, basta executar BankApplication localizado em:

` classpath\src\main\java\com.example.bank\BankApplication`

Como estou utilizando serviço de S3 localmente, o LocalStack está sendo executado em um container Docker.
Para executar o localstack em docker é necessário fazer o download da imagem. Feito o download, executar:

` docker-compose up`

No diretório desta API que será iniciada a execução do Localstack no container.

A escolha do banco de dados a ser utilizado pode ficar a critério do utilizador. Como o objetivo era apenas realizar o desenvolvimento da API, utilizei banco de dados em memória H2, mas poderia ter utilizado MySQL, PostgreSQL, SQL Server, Oracle e outros bancos de dados relacionais.

Estando com o Localstack (ou AWS S3), o banco de dados externo rodando, é preciso adicionar as devidas dependências (driver para o banco de dados escolhido) ao arquivo pom.xml.
As configurações de ambiente devem ser colocadas no arquivo application.properties. Um modelo deste arquivo pode ser visto no arquivo application-test.properties.

Com todos os requisitos e a API em execução, pode-se utilizar o Postman para fazer as requisições aos endpoints da API.

Para maiores informações sobre os endpoints e os payloads passados, favor ler a documentação completa em:
`docs\DOCUMENTATION.md`
