## Rodar Projeto

- Baixar o projeto
- No IntelliJ em Run/Debug Configuration, Add New Configuration `Junit`
- Seleciona uma versão do java 8
- Remove o -ea e coloque `-Dbrand=Zzmall` e `-Denv=integ01` se utilizar outro ambiente o mesmo pode ser mudado, 
o json dos ambientes se encontra em `src\test\resources\baseUrl.json`
- Escolher o método que quer rodar, os testes se encontram em `src\test\java\OCC\Tests\...`
- Salve e rode o teste
