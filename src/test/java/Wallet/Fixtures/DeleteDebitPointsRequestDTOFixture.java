package Wallet.Fixtures;

import Wallet.DTOs.DeleteDebitPointsRequestDTO;
import Wallet.Utils.Utils;

public class DeleteDebitPointsRequestDTOFixture {

	private DeleteDebitPointsRequestDTO deleteDebitPointsRequestDTO;

	public DeleteDebitPointsRequestDTOFixture() {
		deleteDebitPointsRequestDTO = new DeleteDebitPointsRequestDTO();
		deleteDebitPointsRequestDTO.setTransactionId(Utils.getDebitTransactionId());
	}

	public DeleteDebitPointsRequestDTO build() {
		return deleteDebitPointsRequestDTO;
	}
}
