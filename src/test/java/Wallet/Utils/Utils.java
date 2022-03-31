package Wallet.Utils;

import Common.Utils.EnvConfig;
import Common.Utils.GenerateCPF;
import Wallet.DTOs.Request.CreditPointsRequestDTO;
import Wallet.DTOs.Request.DebitPointsRequestDTO;
import Wallet.DTOs.Response.CreditTransactionsResponseDTO;
import Wallet.Enums.CreditPointsTypeEnum;
import Wallet.Enums.StatementStatusEnum;
import Wallet.Handlers.CreditPointsHandler;
import Wallet.Handlers.DebitPointsHandler;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static Wallet.Data.WalletDataTest.getClientId;
import static Wallet.Data.WalletDataTest.getClientSecret;
import static Wallet.Data.WalletDataTest.getLoginDomain;
import static Wallet.Data.WalletDataTest.getLoginEmail;

public class Utils {

	static String ACCESS_TOKEN;
	static String EMAIL;
	static String CPF;
	static float AVAILABLE_AMOUNT;
	static float PENDING_AMOUNT;
	static List<CreditPointsHandler> CREDIT_POINTS;
	static List<DebitPointsHandler> DEBIT_POINTS;
	static Map<String, Object> WALLET_CONFIG_MAPPED;
	public static String WALLET_API_NAME = "Wallet";

	public static void init() {
		ACCESS_TOKEN = null;
		EMAIL = null;
		CPF = null;
		AVAILABLE_AMOUNT = 0;
		PENDING_AMOUNT = 0;
		CREDIT_POINTS = new ArrayList<>();
		DEBIT_POINTS = new ArrayList<>();
	}

	private static String getWalletEnv() {
		String env = "";
		if (System.getProperty("walletEnv") == null) {
			System.out.println("Environment not informed: Ex.: -DwalletEnv=qa ");
		} else {
			env = System.getProperty("walletEnv");
		}
		return env;
	}

	public static String getCredentials() {
		String clientId = getClientId();
		String clientSecret = getClientSecret();

		return clientId.concat(":").concat(clientSecret);
	}

	public static Map<String, Object> getWalletConfigMapped() {
		if (Objects.isNull(WALLET_CONFIG_MAPPED)) {
			WALLET_CONFIG_MAPPED = EnvConfig.getConfigs(WALLET_API_NAME, getWalletEnv());
		}
		return WALLET_CONFIG_MAPPED;
	}

	private static String email() {
		String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyHHmmssSSS"));
		String email = getLoginEmail() + data + getLoginDomain();
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
