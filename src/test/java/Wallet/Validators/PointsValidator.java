package Wallet.Validators;

import Common.Validators.Validator;
import Wallet.DTOs.PointsResponseDTO;
import Wallet.DTOs.StatementDTO;
import Wallet.Enums.StatementStatusEnum;
import Wallet.Enums.StatementTypeEnum;
import Wallet.Handlers.CreditPointsHandler;
import Wallet.Utils.Utils;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Objects;

public class PointsValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		PointsResponseDTO pointsResponseDTO = new PointsResponseDTO().fromJsonString(response.getBody().asString());

		Assertions.assertEquals(Utils.getCPF(), pointsResponseDTO.getDocument());

		Assertions.assertNotNull(pointsResponseDTO.getBalance());
		Assertions.assertEquals(Utils.getAvailableAmount(), pointsResponseDTO.getBalance().getAvailable());
		Assertions.assertEquals(Utils.getPendingAmount(), pointsResponseDTO.getBalance().getPendingCredits());
		Assertions.assertEquals(0, pointsResponseDTO.getBalance().getPendingDebits());

		Utils.getCreditPoints().stream().filter(CreditPointsHandler::isConfirmed)
				.forEach(creditPointsHandler -> {
					StatementDTO creditPointsStatement = pointsResponseDTO.getStatements().stream()
							.filter(statementDTO -> StatementTypeEnum.CREDITO.getValue().equals(statementDTO.getType()))
							.filter(statementDTO -> statementDTO.getTransactionId().equals(creditPointsHandler.getTransactionId()))
							.findFirst()
							.orElse(null);

					Assertions.assertNotNull(creditPointsStatement);
					Assertions.assertEquals(creditPointsHandler.getRequestDTO().getCreditAmount(), creditPointsStatement.getAmount());
					Assertions.assertEquals(StatementStatusEnum.CONFIRMADO.getValue(), creditPointsStatement.getStatus());
					Assertions.assertNotNull(creditPointsStatement.getDateTime());
					Assertions.assertNotNull(creditPointsStatement.getExpireAt());
					Assertions.assertNotNull(creditPointsStatement.getDescription());
					if (Objects.nonNull(creditPointsHandler.getRequestDTO().getOrder())) {
						Assertions.assertEquals(creditPointsHandler.getRequestDTO().getOrder().getId(), creditPointsStatement.getOrder().getId());
						Assertions.assertEquals(creditPointsHandler.getRequestDTO().getOrder().getTotalPrice(), creditPointsStatement.getOrder().getTotalPrice());
					}
				});

		Utils.getDebitPoints().forEach(debitPointsHandler -> {
			StatementDTO debitPointsStatement = pointsResponseDTO.getStatements().stream()
					.filter(statementDTO -> StatementTypeEnum.DEBITO.getValue().equals(statementDTO.getType()))
					.filter(statementDTO -> statementDTO.getTransactionId().equals(debitPointsHandler.getTransactionId()))
					.findFirst()
					.orElse(null);

			Assertions.assertNotNull(debitPointsStatement);
			Assertions.assertEquals(Utils.getLastDebitPoints().getRequestDTO().getDebitAmount(), debitPointsStatement.getAmount());
			Assertions.assertEquals(StatementStatusEnum.CONFIRMADO.getValue(), debitPointsStatement.getStatus());
			Assertions.assertNotNull(debitPointsStatement.getDateTime());
			Assertions.assertNotNull(debitPointsStatement.getExpireAt());
			Assertions.assertNotNull(debitPointsStatement.getDescription());
			if (Objects.nonNull(Utils.getLastDebitPoints().getRequestDTO().getOrder())) {
				Assertions.assertEquals(Utils.getLastDebitPoints().getRequestDTO().getOrder().getId(), debitPointsStatement.getOrder().getId());
				Assertions.assertEquals(Utils.getLastDebitPoints().getRequestDTO().getOrder().getTotalPrice(), debitPointsStatement.getOrder().getTotalPrice());
			}
		});

		return true;
	}
}
