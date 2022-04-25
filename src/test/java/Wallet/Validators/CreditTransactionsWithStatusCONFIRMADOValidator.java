package Wallet.Validators;

import Common.Validators.Validator;
import Wallet.DTOs.Request.CreditPointsRequestDTO;
import Wallet.DTOs.Response.CreditTransactionsResponseDTO;
import Wallet.Enums.CreditTransactionStatusEnum;
import Wallet.Utils.Utils;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class CreditTransactionsWithStatusCONFIRMADOValidator implements Validator {

	private String transactionId;

	public CreditTransactionsWithStatusCONFIRMADOValidator(String transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public void validate(Response response) {
		CreditTransactionsResponseDTO creditTransactionsResponseDTO = new CreditTransactionsResponseDTO().fromJsonString(response.getBody().asString());

		CreditPointsRequestDTO creditPointsRequestDTO = Utils.getCreditPoints(transactionId);

		assertEquals(transactionId, creditTransactionsResponseDTO.getTransactionId());
		assertEquals(creditPointsRequestDTO.getDocument(), creditTransactionsResponseDTO.getDocument());
		assertEquals(creditPointsRequestDTO.getAmount(), creditTransactionsResponseDTO.getAmount());
		assertEquals(creditPointsRequestDTO.getCreditAmount(), creditTransactionsResponseDTO.getCreditAmount());
		assertEquals(CreditTransactionStatusEnum.CONFIRMADO.getValue(), creditTransactionsResponseDTO.getStatus());
		assertNotNull(creditTransactionsResponseDTO.getDateTime());
		assertNotNull(creditTransactionsResponseDTO.getDescription());

	}
}
