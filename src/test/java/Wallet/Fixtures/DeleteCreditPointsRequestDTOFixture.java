package Wallet.Fixtures;

import Wallet.DTOs.Request.DeleteCreditPointsRequestDTO;
import Wallet.Utils.Utils;

public class DeleteCreditPointsRequestDTOFixture {

	private DeleteCreditPointsRequestDTO deleteCreditPointsRequestDTO;

	public DeleteCreditPointsRequestDTOFixture() {
		deleteCreditPointsRequestDTO = new DeleteCreditPointsRequestDTO();
		deleteCreditPointsRequestDTO.setTransactionId(Utils.getLastConfirmedCreditPoints().getTransactionId());
	}

	public DeleteCreditPointsRequestDTO build() {
		return deleteCreditPointsRequestDTO;
	}
}
