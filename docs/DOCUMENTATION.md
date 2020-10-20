# Documentação
## Instruções

Com a API e demais dependências em execução conforme arquivo README.md, podemos utilizar Postman ou similar para realizar testes dos diversos endpoins da API.

### Endpoints 

#### Pré-cadastro
**Ação** | **Endpoint** | **Método**
------ | ----- | -----
Cadastro inicial | _/v1/registrations_ | POST
Listar todos os registros | _/v1/registrations_ | GET
Retornar registro por id | _/v1/registrations/{id}_ | GET
Alterar registro | _/v1/registrations/{id}_ | PUT

#### Proposta
**Ação** | **Endpoint** | **Método**
------ | ----- | -----
Cadastro de proposta | _/v1/proposals_ | POST
Listar todos as propostas | _/v1/proposals_ | GET
Retornar proposta por id | _/v1/proposals/{id}_ | GET

#### Documentos
**Ação** | **Endpoint** | **Método**
------ | ----- | -----
Envio de documentos | _/v1/documents/{id}_ | POST
Listar todos os documentos | _/v1/documents_ | GET
Retornar documento por id | _/v1/documents/{id}_ | GET

#### Revisão e Aprovação
**Ação** | **Endpoint** | **Método**
------ | ----- | -----
Aprovação / Negação da proposta | _/v1/review_ | POST
Retornar proposta final por id | _/v1/review/{id}_ | GET

#### Criação de Conta
**Ação** | **Endpoint** | **Método**
------ | ----- | -----
Criar conta | _/v1/accounts/{id}_ | POST
Listar todas as contas | _/v1/accounts_ | GET
Retornar conta por id | _/v1/accounts/{id}_ | GET

#### Primeiro acesso - Geração de token
**Ação** | **Endpoint** | **Método**
------ | ----- | -----
Geração de token | _/v1/tokens_ | POST
Retornar token por id | _/v1/tokens/{id}_ | GET

#### Primeiro acesso - Geração de senha
**Ação** | **Endpoint** | **Método**
------ | ----- | -----
Geração de senha | _/v1/passwords_ | POST
Retornar senha por id | _/v1/passwords/{id}_ | GET

#### Recebimento de transferência
**Ação** | **Endpoint** | **Método**
------ | ----- | -----
Registro de transferência | _/v1/transfers_ | POST
Listar todas as transferências | _/v1/transfers_ | GET
Retornar transferência por id | _/v1/transfers/{id}_ | GET

### Layout dos Payloads

#### Pré-cadastro
##### POST
    {
        "firstName": "Ricardo",
        "lastName": "Braga",
        "email": "ricardo@maill.com",
        "birthDate": "2002-06-12",
        "cpf": "40687675057"
    }
##### GET
    [
        {
            "id": "4cecc613-0589-461a-a2d3-da6c56c0b84e",
            "firstName": "Ricardo",
            "lastName": "Braga",
            "email": "ricardo@maill.com",
            "birthDate": "2002-06-12",
            "cpf": "40687675057",
            "status": "UNDER_PRE_ANALYSIS"
        }
    ]

#### Proposta
##### POST
    {
        "zip": "32141587",
        "street": "Rua Bernardo de Campos",
        "neighborhood": "Passo Alto",
        "complement": "1844",
        "city": "Santos",
        "state": "RS",
        "id": "4cecc613-0589-461a-a2d3-da6c56c0b84e"
    }
##### GET
    [
        {
            "id": "4cecc613-0589-461a-a2d3-da6c56c0b84e",
            "zip": "32141587",
            "street": "Rua Bernardo de Campos",
            "neighborhood": "Passo Alto",
            "complement": "1844",
            "city": "Santos",
            "state": "RS",
            "proposal": {
                "id": "4cecc613-0589-461a-a2d3-da6c56c0b84e",
                "firstName": "Ricardo",
                "lastName": "Braga",
                "email": "ricardo@maill.com",
                "birthDate": "2002-06-12",
                "cpf": "40687675057",
                "status": "UNDER_ANALYSIS_DATA"
            },
            "document": null
        }
    ]

#### Documentos
##### POST e GET
Sem body. Envio de arquivos e retorno de HTTP status apenas

#### Revisão e Aprovação
##### POST - REQUEST
    {
        "id": "4cecc613-0589-461a-a2d3-da6c56c0b84e",
        "firstName": "Ricardo",
        "lastName": "Braga",
        "email": "ricardo@maill.com",
        "birtDate": "2002-06-12",
        "cpf": "40687675057",
        "status": "WAITING_FOR_APPROVAL",
        "zip": "32141587",
        "street": "Rua Bernardo de Campos",
        "complement": "1844",
        "neighborhood": "Passo Alto",
        "city": "Santos",
        "state": "RS",
        "accepted": "YES"
    }
##### RESPONSE
    {
        "Status": "OK",
        "Message": "Obrigado por escolher o nosso banco! Sua conta será criada.",
        "Code": 200
    }

##### GET
    {
        "id": "4cecc613-0589-461a-a2d3-da6c56c0b84e",
        "firstName": "Ricardo",
        "lastName": "Braga",
        "email": "ricardo@maill.com",
        "birtDate": "2002-06-12",
        "cpf": "40687675057",
        "status": "APPROVED",
        "zip": "32141587",
        "street": "Rua Bernardo de Campos",
        "complement": "1844",
        "neighborhood": "Passo Alto",
        "city": "Santos",
        "state": "RS",
        "accepted": "YES"
    }

#### Criação de Conta
##### POST - REQUEST
Sem body. Passado somente o id. 
Sem retorno. 

##### POST - RESPONSE
    {
        "Status": "OK",
        "Message": "A conta será criada.",
        "Code": 200
    }
##### GET
    {
        "id": "4cecc613-0589-461a-a2d3-da6c56c0b84e",
        "bankNumber": 123,
        "agencyNumber": 1025,
        "accountNumber": 14464162,
        "balance": 0.0,
        "proposal": {
            "id": "4cecc613-0589-461a-a2d3-da6c56c0b84e",
            "firstName": "Ricardo",
            "lastName": "Braga",
            "email": "ricardo@maill.com",
            "birthDate": "2002-06-12",
            "cpf": "40687675057",
            "status": "RELEASED"
        }
    }

#### Geração de token
##### POST
    {
        "email": "ricardo@maill.com",
        "cpf": "40687675057"
    }
Sem retorno. Somente HTTP Status.
##### GET
    {
        "id": "4cecc613-0589-461a-a2d3-da6c56c0b84e",
        "token": "7bc41N",
        "expires": "2020-10-20T18:02:31.232127",
        "used": "NO",
        "proposal": {
            "id": "4cecc613-0589-461a-a2d3-da6c56c0b84e",
            "firstName": "Ricardo",
            "lastName": "Braga",
            "email": "ricardo@maill.com",
            "birthDate": "2002-06-12",
            "cpf": "40687675057",
            "status": "RELEASED"
        }
    }

#### Geração de senha
##### POST - REQUEST
    {
        "id": "4cecc613-0589-461a-a2d3-da6c56c0b84e",
        "token": "7bc41N",
        "expires": "2020-10-20T18:02:31.232127",
        "used": "NO"
    }
##### POST - RESPONSE
    {
        "Status": "Ok",
        "Message": "Senha gerada com sucesso.",
        "Code": 200
    }
##### GET
    {
        "Status": "Ok",
        "Code": 200,
        "Password": "BO8j%8Sn"
    }
