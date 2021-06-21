package Wallet.Validators;

import Wallet.DTOs.CreditPointsRequestDTO;
import Wallet.DTOs.CreditTransactionsResponseDTO;
import Wallet.Enums.CreditTransactionStatusEnum;
import Wallet.Utils.Utils;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class CreditTransactionsWithStatusCONFIRMADOValidator implements Validator {

	private String transactionId;

	public CreditTransactionsWithStatusCONFIRMADOValidator(String transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public boolean validate(Response response) {
		CreditTransactionsResponseDTO creditTransactionsResponseDTO = CreditTransactionsResponseDTO.fromJsonString(response.getBody().asString());

		CreditPointsRequestDTO creditPointsRequestDTO = Utils.getCreditPoints(transactionId);

		Assertions.assertEquals(transactionId, creditTransactionsResponseDTO.getTransactionId());
		Assertions.assertEquals(creditPointsRequestDTO.getDocument(), creditTransactionsResponseDTO.getDocument());
		Assertions.assertEquals(creditPointsRequestDTO.getAmount(), creditTransactionsResponseDTO.getAmount());
		Assertions.assertEquals(creditPointsRequestDTO.getCreditAmount(), creditTransactionsResponseDTO.getCreditAmount());
		Assertions.assertEquals(CreditTransactionStatusEnum.CONFIRMADO.getValue(), creditTransactionsResponseDTO.getStatus());
		Assertions.assertNotNull(creditTransactionsResponseDTO.getDateTime());
		Assertions.assertNotNull(creditTransactionsResponseDTO.getDescription());

		return true;
	}
}
