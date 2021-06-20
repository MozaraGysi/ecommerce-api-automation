package Wallet.Validators;

import Wallet.DTOs.PointsResponseDTO;
import Wallet.DTOs.StatementDTO;
import Wallet.Enums.StatementStatusEnum;
import Wallet.Enums.StatementTypeEnum;
import Wallet.Utils.Utils;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Objects;

public class PointsValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		PointsResponseDTO pointsResponseDTO = PointsResponseDTO.fromJsonString(response.getBody().asString());

		Assertions.assertEquals(Utils.getCPF(), pointsResponseDTO.getDocument());

		Assertions.assertNotNull(pointsResponseDTO.getBalance());
		Assertions.assertEquals(Utils.getAvailableAmount(), pointsResponseDTO.getBalance().getAvailable());
		Assertions.assertEquals(0, pointsResponseDTO.getBalance().getPendingCredits());
		Assertions.assertEquals(0, pointsResponseDTO.getBalance().getPendingDebits());

		if (Objects.nonNull(Utils.getCreditTransactionId())) {
			StatementDTO lastCreditPointsStatement = pointsResponseDTO.getStatements().stream()
					.filter(statementDTO -> StatementTypeEnum.CREDITO.getValue().equals(statementDTO.getType()))
					.filter(statementDTO -> statementDTO.getTransactionId().equals(Utils.getCreditTransactionId()))
					.findFirst()
					.orElse(null);

			Assertions.assertNotNull(lastCreditPointsStatement);
			Assertions.assertEquals(Utils.getLastCreditPoints().getCreditAmount(), lastCreditPointsStatement.getAmount());
			Assertions.assertEquals(StatementStatusEnum.CONFIRMADO.getValue(), lastCreditPointsStatement.getStatus());
			Assertions.assertNotNull(lastCreditPointsStatement.getDateTime());
			Assertions.assertNotNull(lastCreditPointsStatement.getExpireAt());
			Assertions.assertNotNull(lastCreditPointsStatement.getDescription());
			if (Objects.nonNull(Utils.getLastCreditPoints().getOrder())) {
				Assertions.assertEquals(Utils.getLastCreditPoints().getOrder().getId(), lastCreditPointsStatement.getOrder().getId());
				Assertions.assertEquals(Utils.getLastCreditPoints().getOrder().getTotalPrice(), lastCreditPointsStatement.getOrder().getTotalPrice());
			}
		}

		if (Objects.nonNull(Utils.getDebitTransactionId())) {
			StatementDTO lastDebitPointsStatement = pointsResponseDTO.getStatements().stream()
					.filter(statementDTO -> StatementTypeEnum.DEBITO.getValue().equals(statementDTO.getType()))
					.filter(statementDTO -> statementDTO.getTransactionId().equals(Utils.getDebitTransactionId()))
					.findFirst()
					.orElse(null);

			Assertions.assertNotNull(lastDebitPointsStatement);
			Assertions.assertEquals(Utils.getLastDebitPoints().getDebitAmount(), lastDebitPointsStatement.getAmount());
			Assertions.assertEquals(StatementStatusEnum.CONFIRMADO.getValue(), lastDebitPointsStatement.getStatus());
			Assertions.assertNotNull(lastDebitPointsStatement.getDateTime());
			Assertions.assertNotNull(lastDebitPointsStatement.getExpireAt());
			Assertions.assertNotNull(lastDebitPointsStatement.getDescription());
			if (Objects.nonNull(Utils.getLastDebitPoints().getOrder())) {
				Assertions.assertEquals(Utils.getLastDebitPoints().getOrder().getId(), lastDebitPointsStatement.getOrder().getId());
				Assertions.assertEquals(Utils.getLastDebitPoints().getOrder().getTotalPrice(), lastDebitPointsStatement.getOrder().getTotalPrice());
			}
		}

		return true;
	}
}
