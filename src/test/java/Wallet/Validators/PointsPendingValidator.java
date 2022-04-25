package Wallet.Validators;

import Common.Validators.Validator;
import Wallet.DTOs.Response.PointsResponseDTO;
import Wallet.DTOs.Response.StatementResponseDTO;
import Wallet.Enums.StatementStatusEnum;
import Wallet.Enums.StatementTypeEnum;
import Wallet.Handlers.CreditPointsHandler;
import Wallet.Utils.Utils;
import io.restassured.response.Response;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class PointsPendingValidator implements Validator {

	@Override
	public void validate(Response response) {
		PointsResponseDTO pointsResponseDTO = new PointsResponseDTO().fromJsonString(response.getBody().asString());

		assertEquals(Utils.getCPF(), pointsResponseDTO.getDocument());

		assertNotNull(pointsResponseDTO.getBalance());
		assertEquals(Utils.getAvailableAmount(), pointsResponseDTO.getBalance().getAvailable());
		assertEquals(Utils.getPendingAmount(), pointsResponseDTO.getBalance().getPendingCredits());
		assertEquals(0, pointsResponseDTO.getBalance().getPendingDebits());

		Utils.getCreditPoints().stream().filter(CreditPointsHandler::isConfirmed)
				.forEach(creditPointsHandler -> {
					StatementResponseDTO creditPointsStatement = pointsResponseDTO.getStatements().stream()
							.filter(statementResponseDTO -> StatementTypeEnum.CREDITO.getValue().equals(statementResponseDTO.getType()))
							.filter(statementResponseDTO -> statementResponseDTO.getTransactionId().equals(creditPointsHandler.getTransactionId()))
							.findFirst()
							.orElse(null);

					assertNotNull(creditPointsStatement);
					assertEquals(creditPointsHandler.getRequestDTO().getCreditAmount(), creditPointsStatement.getAmount());
					assertEquals(StatementStatusEnum.PENDENTE.getValue(), creditPointsStatement.getStatus());
					assertNotNull(creditPointsStatement.getDateTime());
					assertNotNull(creditPointsStatement.getExpireAt());
					assertNotNull(creditPointsStatement.getDescription());
					if (Objects.nonNull(creditPointsHandler.getRequestDTO().getOrder())) {
						assertEquals(creditPointsHandler.getRequestDTO().getOrder().getId(), creditPointsStatement.getOrder().getId());
						assertEquals(creditPointsHandler.getRequestDTO().getOrder().getTotalPrice(), creditPointsStatement.getOrder().getTotalPrice());
					}
				});

		Utils.getDebitPoints().forEach(debitPointsHandler -> {
			StatementResponseDTO debitPointsStatement = pointsResponseDTO.getStatements().stream()
					.filter(statementResponseDTO -> StatementTypeEnum.DEBITO.getValue().equals(statementResponseDTO.getType()))
					.filter(statementResponseDTO -> statementResponseDTO.getTransactionId().equals(debitPointsHandler.getTransactionId()))
					.findFirst()
					.orElse(null);

			assertNotNull(debitPointsStatement);
			assertEquals(Utils.getLastDebitPoints().getRequestDTO().getDebitAmount(), debitPointsStatement.getAmount());
			assertEquals(StatementStatusEnum.CONFIRMADO.getValue(), debitPointsStatement.getStatus());
			assertNotNull(debitPointsStatement.getDateTime());
			assertNotNull(debitPointsStatement.getExpireAt());
			assertNotNull(debitPointsStatement.getDescription());
			if (Objects.nonNull(Utils.getLastDebitPoints().getRequestDTO().getOrder())) {
				assertEquals(Utils.getLastDebitPoints().getRequestDTO().getOrder().getId(), debitPointsStatement.getOrder().getId());
				assertEquals(Utils.getLastDebitPoints().getRequestDTO().getOrder().getTotalPrice(), debitPointsStatement.getOrder().getTotalPrice());
			}
		});

	}
}
