## Executar o Projeto

- Baixar o projeto
- No IntelliJ em Run/Debug Configuration, Add New Configuration `Junit`
- Seleciona uma versão do java 8
- Remove o -ea e coloque `-Dbrand=Zzmall` e `-Denv=integ01` se utilizar outro ambiente o mesmo pode ser mudado, 
o json dos ambientes se encontra em `src\test\resources\baseUrl.json`
- Escolher o método que quer rodar, os testes se encontram em `src\test\java\OCC\Tests\...`
- Salve e rode o teste

## Observações

- Para testar a Wallet é preciso informar só o `-Denv=`,
os ambientes disponíveis se encontram em `src\test\resources\wallet.json`

- Para testar todo o projeto ignorando só os testes da Wallet é preciso
adicionar -DexcludeWallet=true nos parametros do teste.
Ex: `mvn test -Dtest=** -Dbrand=Zzmall -Denv=integ01 -DexcludeWallet=true`

## Estrutura

##### DTOs: Objetos de resquest/response
##### Fixtures: Objetos gerados com dados dinâmicos
##### Handlers: Responsáveis por salvar os dados a serem manupulados de uma ou mais requisições
##### Scenarios: Cenários de testes
##### Services: Testes de cada serviço de forma isolada
##### Utils: Utilitários para testes da respetiva API
##### Validators: Validam se os dados retornados estão de acordo com o esperado

Os testes estão divididos conforme os projetos de APIs, sendo localizados dentro de `\src\java\`:

- CentralSeller
  - DTOs
  - Fixtures
  - Handlers
  - Scenarios
  - Services
  - Utils
  - Validators
- NovoEcommerce
  - DTOs
  - Fixtures
  - Handlers
  - Scenarios
  - Services
  - Utils
  - Validators
- OCC
    - DTOs
    - Fixtures
    - Handlers
    - Scenarios
    - Services
    - Utils
    - Validators
- Wallet
    - DTOs
    - Fixtures
    - Handlers
    - Scenarios
    - Services
    - Utils
    - Validators
