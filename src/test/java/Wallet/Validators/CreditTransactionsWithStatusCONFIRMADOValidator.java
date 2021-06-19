package Wallet.Validators;

import Wallet.DTOs.CreditTransactionsResponseDTO;
import Wallet.Enums.CreditTransactionStatusEnum;
import Wallet.Utils.Utils;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class CreditTransactionsWithStatusCONFIRMADOValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		CreditTransactionsResponseDTO creditTransactionsResponseDTO = CreditTransactionsResponseDTO.fromJsonString(response.getBody().asString());

		Assertions.assertEquals(Utils.getTransactionId(), creditTransactionsResponseDTO.getTransactionId());
		Assertions.assertEquals(Utils.getLastCreditPoints().getDocument(), creditTransactionsResponseDTO.getDocument());
		Assertions.assertEquals(Utils.getLastCreditPoints().getAmount(), creditTransactionsResponseDTO.getAmount());
		Assertions.assertEquals(Utils.getLastCreditPoints().getCreditAmount(), creditTransactionsResponseDTO.getCreditAmount());
		Assertions.assertEquals(CreditTransactionStatusEnum.CONFIRMADO.getValue(), creditTransactionsResponseDTO.getStatus());
		Assertions.assertNotNull(creditTransactionsResponseDTO.getDateTime());
		Assertions.assertNotNull(creditTransactionsResponseDTO.getDescription());

		return true;
	}
}
