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
		Response response = APIClient.GET_creditTransactions(Utils.getTRANSACTION_ID());

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new CreditTransactionsWithStatusPENDENTEValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void getCreditTransactionsWithStatusCONFIRMADO() {
		Response response = getResponseCreditTransactionsWithStatusCONFIRMADO();

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new CreditTransactionsWithStatusCONFIRMADOValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	private static Response getResponseCreditTransactionsWithStatusCONFIRMADO() {
		Response response = null;

		boolean creditTransactionConfirmed = false;
		int count = 0;
		while (!creditTransactionConfirmed && count < 7) {
			response = APIClient.GET_creditTransactions(Utils.getTRANSACTION_ID());

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
}
