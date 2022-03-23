# E-Commerce API Automation
Este é um projeto do time de e-commerce, com a finalidade de testar de forma automatizada suas APIs.

### APIs presentes nos testes:
- Hybris | OCC
- Hybris | V3
- ZZNet | Prateleira Infinita
- Sensedia | Wallet

### Tech Talk: [Link da gravação](https://drive.google.com/file/d/1tx1_DGb73UWVVXTHeUa1qL0hNmmgUIDy/view)

## Executar o Projeto

### Pelo IntelliJ IDEA
- Clonar o projeto
- No IntelliJ em Run/Debug Configuration, Add New Configuration `Junit`
- Seleciona uma versão do java 8
- Remove o `-ea` e coloque `-Dbrand=Zzmall -Denv=integ01 -DexcludeWallet=true`.
  - Se for outra marca ou ambiente, deve utilizar os listados na seção **Argumentos disponíveis**.
- Escolher o método que quer rodar, os testes se encontram em `src/test/java/OCC/Tests/...`

- Salve e rode o teste

### Por linha de comando
- Possuir o artefato construído
- Executar a tarefa `test` do Maven, com os argumentos necessários
  - Ex.: `mvn test -Dbrand=Zzmall -Denv=integ01 -DexcludeWallet=true`

## Argumentos disponíveis

- `-Dbrand`: Identificação de qual será a marca da execução dos testes.
  - Valores disponíveis: `AlexandreBirman`/`Anacapri`/`Arezzo`/`Fiever`/`Owme`/`Schutz`/`Vans`/`Zzmall`
  - Valores no arquivo: `src/test/resources/baseUrl.json`
- `-Denv`: Identificação de qual será o ambiente de execução dos testes.
  - Valores disponíveis: 
    - OCC: `prd`/`hml`/`integ01`/`integ02`/`integ03`/`integ04`/`integ05`/`integ06`
    - Valores no arquivo: `src/test/resources/baseUrl.json`
- `-DwalletEnv:` Identificação de qual será o ambiente de execução dos testes da wallet.
  - Valores disponíveis:
    - Wallet: `dev`/`qa`
    - Valores no arquivo: `src/test/resources/wallet.json`
- `-DexcludeWallet`: Identificação se os cenários da **Wallet** devem ser executados.
  - Valores disponiveis: `true`/`false`

## Padrões do GIT:
<details>
  <summary>Estrutura de branches</summary>

```   
 main
  |
  |
  |_____ develop -> branch com o código que reflete o produto em atual desenvolvimento
          |
          |
          |_______ feat/login -> branch de uma nova feature que será mergeada para a dev
          |
          |
          |_______ fix/home-alignment -> branch de uma correção que será mergeada para a dev
          |
          |
          |_______ refactor/user-state -> branch de um refactor que será mergeado para a dev
          |
          |
          |_______ docs/define-git-default -> branch de uma inclusão de documentação que será mergeado na dev
          |
          |
          |_______ revert/login -> branch de um código que foi implementado recentemente e terá que voltar ao seu estado anterior
```
Sendo assim para criar uma nova feature, corrigir um bug ou fazer um refactor
você sempre abrirá uma nova branch a partir da `develop`.
```
git checkout develop
git pull
git checkout -b <nome_da_sua_branch>
```

</details>

<details>
  <summary>Nomenclatura de branches</summary>

Para criar um nova branch devemos seguir alguns padrões para preservar uma boa organização do repositório.
O nome da sua branch sempre será composto por duas seções principais separados por uma `/`. São elas:

**O tipo de tarefa feita na branch:**
- **feat**: Nova feature
- **fix**: Correção de bug
- **refactor**: Mudanças no código que não são nem correção de bug nem novas features
- **docs**: Inclusão ou mudanças na documentação
- **revert**: Quando uma implementação recente precisa ser retornada ao seu estado anterior

**O que está sendo feito na branch:**

Nessa parte iremos ser um pouco mais específicos, que tipo de `feat`, `fix`,`refactor`, `docs` ou `revert` vocês está fazendo?
Digamos que eu esteja fazendo a feature de login do usuário.
Sendo assim, posso criar uma branch nomeada `feat/user-login`, tente ser objetivo e claro ao pensar neste nome.
Outro ponto importante é que: nomes compostos devem ser sempre separados por `-` mantendo todas as letras em lowercase
e sempre utilizando a lingua inglesa.

</details>

<details>
  <summary>Nomenclatura das mensagens de commit</summary>

Da mesma forma que as novas branches, as mensagens de commit também devem seguir um padrão predefinido.
Todas elas devem conter um dos seguintes prefixos: `feat`,`fix`,`refactor`,`docs`, `revert`.

- `feat`: Implementação de uma nova feature
- `fix`: Correção de um bug
- `refactor`: Mudanças no código que não são nem correção de bug nem novas features, normalmente mudanças relacionadas a estrutura do código
- `docs`: Adições ou mudanças na documentação
- `revert`: Quando algo que foi feito recentemente dentro da branch estiver sendo revertido para o seu estado anterior

Após o prefixo seguido de `:` devemos detalhar melhor o que exatamente foi feito nos arquivos que estão sendo `commitados`.
Seguindo o mesmo exemplo dado anteriormente, digamos que eu tenha feito a parte de chamar o endpoint de autenticação para buscar o `accessToken` e o `refreshToken`.
A mensagem de commit poderia ser algo como: `Feat: Request access and refresh tokens`.

**Boas práticas:**
- Escrever mensagens de commit curtas com no máximo 50 caracteres
- Escrever as mensagens sempre em inglês
- Evitar muitas abreviações

</details>

<details>
  <summary>Pull Requests</summary>

Nessa etapa teremos que seguir algumas regras e padrões, conforme abaixo.

**Título:**

O título deve ser o nome da branch na qual você estava trabalhando no formato literal, `Feat: Nome da branch de forma literal`,
pois dessa forma as mensagens de merge no histórico do git ficam limpas e claras.

Exemplo no histórico: `Merged PR 1085: Feat: Change wallet services methods name`.

**Descrição:**

Aqui você colocará o objetivo daquele PR, detalhes sobre as modificações feitas e pontos de atenção, caso existam,
que devem ser observados durante o code review.

**Reviewers:**

Solicite o review de todos os membros que atuam no projeto da automação de api.

**Work items to link:**

Nesse campo do pull request você deve vincular a task relacionada.

</details>

<details>
  <summary>Condições de Merge</summary>

Um PR poderá ser mergeado após ter pelo menos 2 approves e nenhum `change request` ou comentários não resolvidos.
Qualquer um pode fazer o merge desde que o PR atenda esses critérios.

</details>

## Estrutura de arquivos

- **Common**: Classes compartilhadas por mais uma API.
- **OCC**: Classes utilizadas apenas para cenários de testes do Hybris OCC.
- **V3**: Classes utilizadas apenas para cenários de testes da API V3 da Hybris.
- **Wallet**: Classes utilizadas apenas para cenários de testes do API da Wallet, hospedada na Sensedia.
- **OtherServices**: Classes utilizadas para cenários de testes de APIs menores.

## Padrões de Desenvolviemnto

### DTO
Classe com definição dos objetos de request e response.
<details>
  <summary>Exemplo</summary>

   ```
public class ClassName[Request/Response]DTO extends AbstractDTO<ClassName[Request/Response]DTO> {

	private String attribute;
	private ClassNameChild[Request/Response]DTO childAttribute;

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getChildAttribute() {
		return childAttribute;
	}

	public void setChildAttribute(String childAttribute) {
		this.childAttribute = childAttribute;
	}
}
   ```
</details>

### Fixture
Classes responsáveis por criar DTOs com dados dinâmicos para os testes.
<details>
  <summary>Exemplo</summary>

   ```
public class ClassNameRequestDTOFixture {

	private ClassNameRequestDTO classNameDTO;

	private ClassNameRequestDTOFixture() {
		classNameDTO = new ClassNameRequestDTO();
		classNameDTO.setAttributo(RandomStringUtils.randomNumeric(6));
		classNameDTO.setChildAttribute(ClassNameChildDTOFixture.get().build());
	}

  public static ClassNameRequestDTOFixture get() {
		return new ClassNameRequestDTOFixture();
	}
	
    public ClassNameRequestDTO build() {
		return classNameDTO;
	}
	
	private ClassNameRequestDTOFixture random() {
		return this
		.withChildAttributeSomeValue()
		.withAttributeSomeValue()
	
	public static ClassNameRequestDTOFixture getRandom() {
		return ClassNameRequestDTOFixture.get().random();
	}

	public ClassNameRequestDTOFixture withAttributeSomeValue() {
		classNameDTO.setAttribute(someValue);
		return this;
	}
	
	public ClassNameRequestDTOFixture withChildAttributeSomeValue() {
		classNameDTO.setChildAttribute(someValue);
		return this;
	}
}
   ```
</details>

### Tests
Classes com os roteiros dos cenários de testes
<details>
  <summary>Exemplo</summary>

   ```
public class ClassNameTest {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void [post/get/...]SomeTest() {
		ClassName01Service.[post/get/...]SomeTest();
		ClassName02Service.[post/get/...]SomeTest();
	}
}
   ```
</details>

### Service
Classes responsáveis pela definição de cada cenário de teste, sempre seguindo o padrão [AAA](https://medium.com/@alamonunes/teste-unit%C3%A1rio-e-o-padr%C3%A3o-aaa-arrange-act-assert-cb81d587368a).

Utilizamos no prefixo o método HTTP para evidênciar a ação que será executada na api.
<details>
  <summary>Exemplo</summary>

   ```
public class ClassNameService {

	public static void postSomeTest() {
		ClassNameDTO classNameDTO = new ClassNameDTOFixture().withAttributeSomeValue().build();

		Response response = APIClient.postSomeRequest(classNameDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeValidator(), new Some01Validator(), new Some02Validator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}
	
	public static void postSomeTestWithHandleValues() {
		ClassNameDTO classNameDTO = new ClassNameDTOFixture().withAttributeSomeValue().build();

		Response response = APIClient.postSomeRequest(classNameDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeValidator(), new Some01Validator(), new Some02Validator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
		
		handleSomeValue(classNameDTO, response);
	}
}
   ```
</details>

### Validator
Classes responsáveis por validar se os dados respondidos estão de acordo com o esperado.
<details>
  <summary>Exemplo</summary>

   ```
public class SomeValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		ClassNameDTO classNameDTO = new ClassNameDTO().fromJsonString(response.getBody().asString());

		Assertions.assertNotNull(classNameDTO.getAttribute());
		Assertions.assertEquals(someValue, classNameDTO.getAttribute());

		return true;
	}
}
   ```
</details>

### APIClient
Classe responsável pela definição de cada serviço a ser requisitado para a API.
<details>
  <summary>Exemplo</summary>

   ```
public class APIClient {

    public static Response postSomeRequest(ClassNameRequestDTO requestDTO) {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.header("Authorization", "Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());

        request.body(requestDTO.toJson().toString());

        Response response = request.post("/arezzocoocc/v2/" + Utils.getSiteUid() + "/something/something");
        response.getBody().print();

        Utils.setCookies(response.getCookies());

        return response;
    }
    
    public static Response getSomeRequest(ClassNameRequestDTO requestDTO) {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.header("Authorization", "Bearer " + Utils.getAccessToken());
        request.header("Cookie",Utils.getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/arezzocoocc/v2/" + Utils.getSiteUid() + "/something/something");
        response.getBody().print();

        Utils.setCookies(response.getCookies());

        return response;
    }
}
   ```
</details>

### Handler
Classes responsáveis por salvar os dados a serem manupulados durante a execução dos testes.

### Util
Classes utilitárias para a execução dos testes de cada API.