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
public class ClassNameDTO extends AbstractDTO<ClassNameDTO> {

	private String attribute;
	private ClassNameChildDTO childAttribute;

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
public class ClassNameDTOFixture {

	private ClassNameDTO classNameDTO;

	public ClassNameDTOFixture() {
		classNameDTO = new ClassNameDTO();
		classNameDTO.setAttributo(RandomStringUtils.randomNumeric(6));
		classNameDTO.setChildAttribute(new ClassNameChildDTOFixture().build());
	}

	public ClassNameDTO build() {
		return classNameDTO;
	}

	public ClassNameDTOFixture withAttributeSomeValue() {
		classNameDTO.setAttribute(someValue);
		return this;
	}
	
	public ClassNameDTOFixture withChildAttributeSomeValue() {
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
	public void someTest() {
		ClassName01Service.someTest();
		ClassName02Service.someTest();
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

    public static Response POST_someRequest(ClassNameDTO requestDTO) {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());

        request.body(requestDTO.toJson().toString());

        Response response = request.post("/arezzocoocc/v2/" + Utils.getSite_UID() + "/something/something");
        response.getBody().print();

        Utils.setCookies(response.getCookies());

        return response;
    }
    
    public static Response GET_someRequest(ClassNameDTO requestDTO) {
        RestAssured.baseURI = Utils.getBaseUrl();

        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.header("Authorization", "Bearer " + Utils.getACCESS_TOKEN());
        request.header("Cookie",Utils.getCookies());

        request.queryParams(requestDTO.toMap());

        Response response = request.get("/arezzocoocc/v2/" + Utils.getSite_UID() + "/something/something");
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