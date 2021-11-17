## Executar o Projeto

- Baixar o projeto
- No IntelliJ em Run/Debug Configuration, Add New Configuration `Junit`
- Seleciona uma versão do java 8
- Remove o -ea e coloque `-Dbrand=Zzmall` e `-Denv=integ01` se utilizar outro ambiente o mesmo pode ser mudado, 
o json dos ambientes se encontra em `src\test\resources\baseUrl.json`
- Escolher o método que quer rodar, os testes se encontram em `src\test\java\OCC\Tests\...`
- Salve e rode o teste

## Estrutura

Os testes estão divididos conforme os projetos de APIs, sendo localizados dentro de `\src\java\`:

- CentralSeller
  - DTOs (Objetos)
  - Fixtures (Objetos gerados com dados dinâmicos)
  - Handler (Responsáveis por salvar os dados recebidos de uma requisição)
  - Scenarios (Cenários de testes)
  - Services (Testes de cada serviço de forma isolada)
  - Utils (Utilitários para testes da respetiva API)
  - Validators (Validam se os dados retornados estão corretos)
- NovoEcommerce
  - DTOs
  - Fixtures
  - Handler
  - Scenarios
  - Services
  - Utils
  - Validators
- OCC
    - DTOs
    - Fixtures
    - Handler
    - Scenarios
    - Services
    - Utils
    - Validators
- Wallet
    - DTOs
    - Fixtures
    - Handler
    - Scenarios
    - Services
    - Utils
    - Validators
