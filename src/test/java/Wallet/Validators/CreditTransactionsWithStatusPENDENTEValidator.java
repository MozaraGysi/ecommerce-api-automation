package Wallet.Validators;

import Common.Validators.Validator;
import Wallet.DTOs.CreditPointsRequestDTO;
import Wallet.DTOs.CreditTransactionsResponseDTO;
import Wallet.Enums.CreditTransactionStatusEnum;
import Wallet.Utils.Utils;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class CreditTransactionsWithStatusPENDENTEValidator implements Validator {

	private String transactionId;

	public CreditTransactionsWithStatusPENDENTEValidator(String transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public boolean validate(Response response) {
		CreditTransactionsResponseDTO creditTransactionsResponseDTO = new CreditTransactionsResponseDTO().fromJsonString(response.getBody().asString());

		CreditPointsRequestDTO creditPointsRequestDTO = Utils.getCreditPoints(transactionId);

		Assertions.assertEquals(transactionId, creditTransactionsResponseDTO.getTransactionId());
		Assertions.assertEquals(creditPointsRequestDTO.getDocument(), creditTransactionsResponseDTO.getDocument());
		Assertions.assertEquals(creditPointsRequestDTO.getAmount(), creditTransactionsResponseDTO.getAmount());
		Assertions.assertEquals(creditPointsRequestDTO.getAmount(), creditTransactionsResponseDTO.getCreditAmount());
		Assertions.assertEquals(CreditTransactionStatusEnum.PENDENTE.getValue(), creditTransactionsResponseDTO.getStatus());
		Assertions.assertNotNull(creditTransactionsResponseDTO.getDateTime());
		Assertions.assertNotNull(creditTransactionsResponseDTO.getDescription());

		return true;
	}
}
