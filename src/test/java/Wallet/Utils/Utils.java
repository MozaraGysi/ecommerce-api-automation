package Wallet.Utils;

import Wallet.DTOs.CreditPointsRequestDTO;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;

public class Utils {

	static String ACCESS_TOKEN;
	static String EMAIL;
	static String CPF;
	static String TRANSACTION_ID;
	static float AVAILABLE_AMOUNT;
	static CreditPointsRequestDTO LAST_CREDIT_POINTS;

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

	public static String getTransactionId() {
		return TRANSACTION_ID;
	}

	public static void setTRANSACTION_ID(String transactionId) {
		TRANSACTION_ID = transactionId;
	}

	public static void init() {
		ACCESS_TOKEN = null;
		EMAIL = null;
		CPF = null;
		TRANSACTION_ID = null;
		AVAILABLE_AMOUNT = 0;
		LAST_CREDIT_POINTS = null;
	}

	public static float getAvailableAmount() {
		return AVAILABLE_AMOUNT;
	}

	public static void sumAvailableAmount(float availableAmount) {
		AVAILABLE_AMOUNT += availableAmount;
	}

	public static CreditPointsRequestDTO getLastCreditPoints() {
		return LAST_CREDIT_POINTS;
	}

	public static void setLastCreditPoints(CreditPointsRequestDTO lastCreditPoints) {
		LAST_CREDIT_POINTS = lastCreditPoints;
	}
}
