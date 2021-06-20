package Wallet.Pages;

import Wallet.APIClient;
import Wallet.DTOs.CreditTransactionsResponseDTO;
import Wallet.Enums.CreditTransactionStatusEnum;
import Wallet.Utils.Utils;
import Wallet.Validators.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class CreditTransactionsPage {

	public static void getCreditTransactionsWithStatusPENDENTE() {
		Utils.getCreditPoints().stream()
				.filter(creditPointsHandler -> !creditPointsHandler.isConfirmed())
				.forEach(creditPointsHandler -> getCreditTransactionWithStatusPENDENTE(creditPointsHandler.getTransactionId()));
	}

	public static void getCreditTransactionsWithStatusCONFIRMADO() {
		Utils.getCreditPoints().stream()
				.filter(creditPointsHandler -> !creditPointsHandler.isConfirmed())
				.forEach(creditPointsHandler -> getCreditTransactionWithStatusCONFIRMADO(creditPointsHandler.getTransactionId()));
	}

	private static void getCreditTransactionWithStatusPENDENTE(String transactionId) {
		Response response = APIClient.GET_creditTransactions(transactionId);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new CreditTransactionsWithStatusPENDENTEValidator(transactionId));
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	private static void getCreditTransactionWithStatusCONFIRMADO(String transactionId) {
		Response response = getResponseCreditTransactionsWithStatusCONFIRMADO(transactionId);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new CreditTransactionsWithStatusCONFIRMADOValidator(transactionId));
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));

		handleCreditTransactions(response);
	}

	private static Response getResponseCreditTransactionsWithStatusCONFIRMADO(String transactionId) {
		Response response = null;

		boolean creditTransactionConfirmed = false;
		int count = 0;
		while (!creditTransactionConfirmed && count < 7) {
			response = APIClient.GET_creditTransactions(transactionId);

			CreditTransactionsResponseDTO creditTransactionsResponseDTO = CreditTransactionsResponseDTO.fromJsonString(response.getBody().asString());
			creditTransactionConfirmed = CreditTransactionStatusEnum.CONFIRMADO.getValue().equals(creditTransactionsResponseDTO.getStatus());
			if (!creditTransactionConfirmed) {
				count++;
				try {
					Thread.sleep(10000l);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return response;
	}

	private static void handleCreditTransactions(Response response) {
		CreditTransactionsResponseDTO creditTransactionsResponseDTO = CreditTransactionsResponseDTO.fromJsonString(response.getBody().asString());
		Utils.creditPoints(creditTransactionsResponseDTO);
	}
}
