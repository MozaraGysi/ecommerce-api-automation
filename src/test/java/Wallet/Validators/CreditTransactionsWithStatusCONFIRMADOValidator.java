package Wallet.Validators;

import Wallet.DTOs.CreditTransactionsResponseDTO;
import Wallet.Enums.CreditTransactionStatusEnum;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class CreditTransactionsWithStatusCONFIRMADOValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		CreditTransactionsResponseDTO creditTransactionsResponseDTO = CreditTransactionsResponseDTO.fromJsonString(response.getBody().asString());

		Assertions.assertEquals(CreditTransactionStatusEnum.CONFIRMADO.getValue(), creditTransactionsResponseDTO.getStatus());

		return true;
	}
}
