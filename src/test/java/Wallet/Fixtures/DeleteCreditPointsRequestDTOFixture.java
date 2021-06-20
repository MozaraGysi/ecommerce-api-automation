package Wallet.Fixtures;

import Wallet.DTOs.DeleteCreditPointsRequestDTO;
import Wallet.Utils.Utils;

public class DeleteCreditPointsRequestDTOFixture {

	private DeleteCreditPointsRequestDTO deleteCreditPointsRequestDTO;

	public DeleteCreditPointsRequestDTOFixture() {
		deleteCreditPointsRequestDTO = new DeleteCreditPointsRequestDTO();
		deleteCreditPointsRequestDTO.setTransactionId(Utils.getCreditTransactionId());
	}

	public DeleteCreditPointsRequestDTO build() {
		return deleteCreditPointsRequestDTO;
	}
}
