package Wallet.Validators;

import Common.Validators.Validator;
import Wallet.DTOs.Request.CreditPointsRequestDTO;
import Wallet.DTOs.Response.CreditTransactionsResponseDTO;
import Wallet.Enums.CreditTransactionStatusEnum;
import Wallet.Utils.Utils;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class CreditTransactionsWithStatusPENDENTEValidator implements Validator {

	private String transactionId;

	public CreditTransactionsWithStatusPENDENTEValidator(String transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public void validate(Response response) {
		CreditTransactionsResponseDTO creditTransactionsResponseDTO = new CreditTransactionsResponseDTO().fromJsonString(response.getBody().asString());

		CreditPointsRequestDTO creditPointsRequestDTO = Utils.getCreditPoints(transactionId);

		assertEquals(transactionId, creditTransactionsResponseDTO.getTransactionId());
		assertEquals(creditPointsRequestDTO.getDocument(), creditTransactionsResponseDTO.getDocument());
		assertEquals(creditPointsRequestDTO.getAmount(), creditTransactionsResponseDTO.getAmount());
		assertEquals(creditPointsRequestDTO.getAmount(), creditTransactionsResponseDTO.getCreditAmount());
		assertEquals(CreditTransactionStatusEnum.PENDENTE.getValue(), creditTransactionsResponseDTO.getStatus());
		assertNotNull(creditTransactionsResponseDTO.getDateTime());
		assertNotNull(creditTransactionsResponseDTO.getDescription());

	}
}
