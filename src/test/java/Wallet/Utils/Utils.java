package Wallet.Utils;

import Wallet.DTOs.CreditPointsRequestDTO;
import Wallet.DTOs.CreditTransactionsResponseDTO;
import Wallet.DTOs.DebitPointsRequestDTO;
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

	// Talvez seja necessário quando tivermos ambiente de dev/qa no motor de cashback
	public static String getEnv() {
		String env = "";
		if (System.getProperty("env") == null) {
			System.out.println("Env não adicionado: Ex.: -Denv=hml ");
		} else {
			env = System.getProperty("env");
		}
		return env;
	}

	public static String getBaseUrl() {
		return "http://api.arezzoco.com.br/qa/customer-loyalty/v1";
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
		AVAILABLE_AMOUNT = new BigDecimal(AVAILABLE_AMOUNT).add(BigDecimal.valueOf(creditTransactionsResponseDTO.getCreditAmount())).setScale(2, RoundingMode.HALF_EVEN).floatValue();
		Utils.getCreditPoints().stream()
				.filter(creditPointsHandler -> creditTransactionsResponseDTO.getTransactionId().equals(creditPointsHandler.getTransactionId()))
				.findFirst()
				.ifPresent(creditPointsHandler -> creditPointsHandler.setConfirmed(true));
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