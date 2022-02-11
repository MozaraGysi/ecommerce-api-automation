package Wallet.Fixtures;

import Wallet.DTOs.Request.DeleteDebitPointsRequestDTO;
import Wallet.Utils.Utils;

public class DeleteDebitPointsRequestDTOFixture {

	private DeleteDebitPointsRequestDTO deleteDebitPointsRequestDTO;

	public DeleteDebitPointsRequestDTOFixture() {
		deleteDebitPointsRequestDTO = new DeleteDebitPointsRequestDTO();
		deleteDebitPointsRequestDTO.setTransactionId(Utils.getLastDebitPoints().getTransactionId());
	}

	public DeleteDebitPointsRequestDTO build() {
		return deleteDebitPointsRequestDTO;
	}
}
