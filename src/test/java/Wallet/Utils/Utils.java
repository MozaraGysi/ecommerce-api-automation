package Wallet.Utils;

import Wallet.DTOs.CreditPointsRequestDTO;
import Wallet.DTOs.CreditTransactionsResponseDTO;
import Wallet.DTOs.DebitPointsRequestDTO;
import Wallet.Enums.CreditPointsTypeEnum;
import Wallet.Enums.StatementStatusEnum;
import Wallet.Handlers.CreditPointsHandler;
import Wallet.Handlers.DebitPointsHandler;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Utils {

	static String ACCESS_TOKEN;
	static String EMAIL;
	static String CPF;
	static float AVAILABLE_AMOUNT;
	static float PENDING_AMOUNT;
	static List<CreditPointsHandler> CREDIT_POINTS;
	static List<DebitPointsHandler> DEBIT_POINTS;

	public static String getBrand() {
		String brand = "";
		if (System.getProperty("brand") == null){
			System.out.println("Brand not informed: Ex.: -Dbrand=Zzpay ");
		}else{
			brand = System.getProperty("brand");
		}
		return brand;
	}

	public static String getEnv() {
		String env = "";
		if (System.getProperty("env") == null) {
			System.out.println("Environment not informed: Ex.: -Denv=qa ");
		} else {
			env = System.getProperty("env");
		}
		return env;
	}

	public static String getBaseUrl() {
		StringBuilder fileName = new StringBuilder();
		fileName.append("src/test/resources/wallet.json");
		String jsonBaseUrl = "";
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName.toString()))) {
			Gson gson = new Gson();
			Map<String, Object> element = gson.fromJson(bufferedReader, Map.class);
			jsonBaseUrl = ((Map<String, String>)((Map<String, Object>)element.get(getBrand())).get(getEnv())).get("url");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonBaseUrl.concat("customer-loyalty/v1");
	}

	public static String getBaseUrlAccessToken() {
		StringBuilder fileName = new StringBuilder();
		fileName.append("src/test/resources/wallet.json");
		String jsonBaseUrl = "";
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName.toString()))) {
			Gson gson = new Gson();
			Map<String, Object> element = gson.fromJson(bufferedReader, Map.class);
			jsonBaseUrl = ((Map<String, String>)((Map<String, Object>)element.get(getBrand())).get(getEnv())).get("url");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonBaseUrl.concat("oauth/v1");
	}

	public static String getCredentials() {
		StringBuilder fileName = new StringBuilder();
		fileName.append("src/test/resources/wallet.json");
		String clientId = "";
		String clientSecret = "";
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName.toString()))) {
			Gson gson = new Gson();
			Map<String, Object> element = gson.fromJson(bufferedReader, Map.class);
			clientId = ((Map<String, String>)((Map<String, Object>)element.get(getBrand())).get(getEnv())).get("clientId");
			clientSecret = ((Map<String, String>)((Map<String, Object>)element.get(getBrand())).get(getEnv())).get("clientSecret");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return clientId.concat(":").concat(clientSecret);
	}

	public static String getUser(String param) {
		StringBuilder fileName = new StringBuilder();
		fileName.append("src/test/resources/users.json");
		String jsonUsers = "";
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName.toString()))) {
			Gson gson = new Gson();
			Map<String, Object> element = gson.fromJson(bufferedReader, Map.class);
			jsonUsers = ((Map<String, String>) element.get(param)).get("email");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonUsers;
	}

	private static String email() {
		String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyHHmmssSSS"));
		String email = "anajulia_" + data + "@zzmall.com";
		System.out.println(email);
		return email;
	}

	public static void setEMAIL(String email) {
		EMAIL = email;
	}

	public static String getEMAIL() {
		if (Objects.isNull(EMAIL)) {
			EMAIL = email();
		}
		return EMAIL;
	}

	public static void setACCESS_TOKEN(String access_token) {
		ACCESS_TOKEN = access_token;
	}

	public static String getACCESS_TOKEN() {
		return ACCESS_TOKEN;
	}

	private static String cpf() {
		GenerateCPF newCPF = new GenerateCPF();
		String cpf = newCPF.cpfFinal(false);
		System.out.println(cpf);
		return cpf;
	}

	public static String getCPF() {
		if (Objects.isNull(CPF)) {
			CPF = cpf();
		}
		return CPF;
	}

	public static void init() {
		ACCESS_TOKEN = null;
		EMAIL = null;
		CPF = null;
		AVAILABLE_AMOUNT = 0;
		PENDING_AMOUNT = 0;
		CREDIT_POINTS = new ArrayList<>();
		DEBIT_POINTS = new ArrayList<>();
	}

	public static float getAvailableAmount() {
		return AVAILABLE_AMOUNT;
	}

	public static float getPendingAmount() {
		return PENDING_AMOUNT;
	}

	public static void creditPoints(CreditTransactionsResponseDTO creditTransactionsResponseDTO) {
		CreditPointsRequestDTO creditPointsConfirmation = Utils.getCreditPoints(creditTransactionsResponseDTO.getTransactionId());
		cleanPendingTransactions(creditTransactionsResponseDTO, creditPointsConfirmation);
		AVAILABLE_AMOUNT = new BigDecimal(AVAILABLE_AMOUNT).add(BigDecimal.valueOf(creditTransactionsResponseDTO.getCreditAmount())).setScale(2, RoundingMode.HALF_EVEN).floatValue();
		Utils.getCreditPoints().stream()
				.filter(creditPointsHandler -> creditTransactionsResponseDTO.getTransactionId().equals(creditPointsHandler.getTransactionId()))
				.findFirst()
				.ifPresent(creditPointsHandler -> creditPointsHandler.setConfirmed(true));
	}

	private static void cleanPendingTransactions(CreditTransactionsResponseDTO creditTransactionsResponseDTO, CreditPointsRequestDTO creditPointsConfirmation) {
		if (Objects.nonNull(creditPointsConfirmation) && StatementStatusEnum.CONFIRMADO.getValue().equals(creditPointsConfirmation.getStatus()) && CreditPointsTypeEnum.VALOR_MONETARIO.getValue().equals(creditPointsConfirmation.getType())) {
			CreditPointsHandler creditPointsHandlerPENDENTE = Utils.getCreditPoints().stream()
					.filter(handler -> StatementStatusEnum.PENDENTE.getValue().equals(handler.getRequestDTO().getStatus()) && Objects.nonNull(creditPointsConfirmation.getOrder()) && creditPointsConfirmation.getOrder().getId().equals(handler.getRequestDTO().getOrder().getId()))
					.findFirst()
					.orElse(null);
			CreditPointsHandler creditPointsHandlerCONFIRMADO = Utils.getCreditPoints().stream()
					.filter(handler -> StatementStatusEnum.CONFIRMADO.getValue().equals(handler.getRequestDTO().getStatus()) && Objects.nonNull(creditPointsConfirmation.getOrder()) && creditPointsConfirmation.getOrder().getId().equals(handler.getRequestDTO().getOrder().getId()))
					.findFirst()
					.orElse(null);
			PENDING_AMOUNT = new BigDecimal(PENDING_AMOUNT).subtract(BigDecimal.valueOf(creditTransactionsResponseDTO.getCreditAmount())).setScale(2, RoundingMode.HALF_EVEN).floatValue();
			if (Objects.nonNull(creditPointsHandlerPENDENTE) && Objects.nonNull(creditPointsHandlerCONFIRMADO)) {
				creditPointsHandlerPENDENTE.setRequestDTO(creditPointsHandlerCONFIRMADO.getRequestDTO());
			}
			Utils.getCreditPoints().remove(creditPointsHandlerCONFIRMADO);
		}
	}

	public static void creditPendingPoints(CreditTransactionsResponseDTO creditTransactionsResponseDTO) {
		PENDING_AMOUNT = new BigDecimal(PENDING_AMOUNT).add(BigDecimal.valueOf(creditTransactionsResponseDTO.getCreditAmount())).setScale(2, RoundingMode.HALF_EVEN).floatValue();
		Utils.getCreditPoints().stream()
			.filter(creditPointsHandler -> creditTransactionsResponseDTO.getTransactionId().equals(creditPointsHandler.getTransactionId()))
			.findFirst()
			.ifPresent(creditPointsHandler -> creditPointsHandler.setConfirmed(true));
	}

	public static void debitPoints(float points) {
		AVAILABLE_AMOUNT = new BigDecimal(AVAILABLE_AMOUNT).subtract(new BigDecimal(points)).setScale(2, RoundingMode.HALF_EVEN).floatValue();
	}

	public static List<CreditPointsHandler> getCreditPoints() {
		return CREDIT_POINTS;
	}

	public static CreditPointsRequestDTO getCreditPoints(String transactionId) {
		return CREDIT_POINTS.stream()
				.filter(creditPointsHandler -> transactionId.equals(creditPointsHandler.getTransactionId()))
				.map(CreditPointsHandler::getRequestDTO)
				.findFirst()
				.orElse(null);
	}

	public static CreditPointsHandler getLastConfirmedCreditPoints() {
		return CREDIT_POINTS.stream()
				.filter(CreditPointsHandler::isConfirmed)
				.sorted((o1, o2) -> Integer.valueOf(o2.getTransactionId()).compareTo(Integer.valueOf(o1.getTransactionId())))
				.findAny()
				.orElse(null);
	}

	public static void addCreditPoints(CreditPointsHandler creditPointsHandler) {
		CREDIT_POINTS.add(creditPointsHandler);
	}

	public static List<DebitPointsHandler> getDebitPoints() {
		return DEBIT_POINTS;
	}

	public static DebitPointsRequestDTO getDebitPoints(String transactionId) {
		return DEBIT_POINTS.stream()
				.filter(debitPointsHandler -> transactionId.equals(debitPointsHandler.getTransactionId()))
				.map(DebitPointsHandler::getRequestDTO)
				.findFirst()
				.orElse(null);
	}

	public static DebitPointsHandler getLastDebitPoints() {
		return DEBIT_POINTS.stream()
				.sorted((o1, o2) -> Integer.valueOf(o2.getTransactionId()).compareTo(Integer.valueOf(o1.getTransactionId())))
				.findAny()
				.orElse(null);
	}

	public static void addDebitPoints(DebitPointsHandler debitPointsHandler) {
		DEBIT_POINTS.add(debitPointsHandler);
		Utils.debitPoints(debitPointsHandler.getRequestDTO().getDebitAmount());
	}
}
