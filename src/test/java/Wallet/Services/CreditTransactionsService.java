package Wallet.Services;

import Common.Validators.StatusCodeOKValidator;
import Common.Validators.StatusCodeUnauthorizedValidator;
import Common.Validators.Validator;
import Wallet.Handlers.CreditPointsHandler;
import Wallet.Utils.APIClient;
import Wallet.DTOs.Response.CreditTransactionsResponseDTO;
import Wallet.Enums.CreditTransactionStatusEnum;
import Wallet.Utils.Utils;
import Wallet.Validators.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreditTransactionsService {

	public static void getCreditTransactionsWithStatusPENDENTE() {
		Utils.getCreditPoints().stream()
				.filter(creditPointsHandler -> !creditPointsHandler.isConfirmed())
				.forEach(creditPointsHandler -> getCreditTransactionWithStatusPENDENTE(creditPointsHandler.getTransactionId()));
	}

	public static void getCreditTransactionsWithStatusCONFIRMADO() {
		List<CreditPointsHandler> pendingTransactions = Utils.getCreditPoints().stream()
				.filter(creditPointsHandler -> !creditPointsHandler.isConfirmed()).collect(Collectors.toList());
		pendingTransactions.forEach(creditPointsHandler -> getCreditTransactionWithStatusCONFIRMADO(creditPointsHandler.getTransactionId()));
	}

	public static void getPendingCreditTransactionsWithStatusCONFIRMADO() {
		Utils.getCreditPoints().stream()
			.filter(creditPointsHandler -> !creditPointsHandler.isConfirmed())
			.forEach(creditPointsHandler -> getPendingCreditTransactionWithStatusCONFIRMADO(creditPointsHandler.getTransactionId()));
	}

	public static void getCreditTransactionsWithoutAuthentication() {
		Response response = APIClient.getCreditTransactions("123");

		List<Validator> validators = Arrays.asList(new StatusCodeUnauthorizedValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	private static void getPendingCreditTransactionWithStatusCONFIRMADO(String transactionId) {
		Response response = getResponseCreditTransactionsWithStatusCONFIRMADO(transactionId);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new CreditTransactionsWithStatusCONFIRMADOValidator(transactionId));
		validators.stream().forEach(validator -> validator.validate(response));

		handleCreditPendingTransactions(response);
	}

	private static void getCreditTransactionWithStatusPENDENTE(String transactionId) {
		Response response = APIClient.getCreditTransactions(transactionId);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new CreditTransactionsWithStatusPENDENTEValidator(transactionId));
		validators.stream().forEach(validator -> validator.validate(response));
	}

	private static void getCreditTransactionWithStatusCONFIRMADO(String transactionId) {
		Response response = getResponseCreditTransactionsWithStatusCONFIRMADO(transactionId);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new CreditTransactionsWithStatusCONFIRMADOValidator(transactionId));
		validators.stream().forEach(validator -> validator.validate(response));

		handleCreditTransactions(response);
	}

	private static Response getResponseCreditTransactionsWithStatusCONFIRMADO(String transactionId) {
		Response response = null;

		boolean creditTransactionConfirmed = false;
		int count = 0;
		while (!creditTransactionConfirmed && count < 7) {
			response = APIClient.getCreditTransactions(transactionId);

			CreditTransactionsResponseDTO creditTransactionsResponseDTO = new CreditTransactionsResponseDTO().fromJsonString(response.getBody().asString());
			creditTransactionConfirmed = CreditTransactionStatusEnum.CONFIRMADO.getValue().equals(creditTransactionsResponseDTO.getStatus());
			if (!creditTransactionConfirmed) {
				count++;
				try {
					Thread.sleep(10000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return response;
	}

	private static void handleCreditTransactions(Response response) {
		CreditTransactionsResponseDTO creditTransactionsResponseDTO = new CreditTransactionsResponseDTO().fromJsonString(response.getBody().asString());
		Utils.creditPoints(creditTransactionsResponseDTO);
	}

	private static void handleCreditPendingTransactions(Response response) {
		CreditTransactionsResponseDTO creditTransactionsResponseDTO = new CreditTransactionsResponseDTO().fromJsonString(response.getBody().asString());
		Utils.creditPendingPoints(creditTransactionsResponseDTO);
	}
}
