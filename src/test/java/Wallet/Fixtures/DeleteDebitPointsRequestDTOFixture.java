package Wallet.Fixtures;

import Wallet.DTOs.DeleteDebitPointsRequestDTO;
import Wallet.Utils.Utils;

public class DeleteDebitPointsRequestDTOFixture {

	public static DeleteDebitPointsRequestDTO build() {
		DeleteDebitPointsRequestDTO deleteDebitPointsRequestDTO = new DeleteDebitPointsRequestDTO();
		deleteDebitPointsRequestDTO.setTransactionId(Utils.getTRANSACTION_ID());
		return deleteDebitPointsRequestDTO;
	}
}
