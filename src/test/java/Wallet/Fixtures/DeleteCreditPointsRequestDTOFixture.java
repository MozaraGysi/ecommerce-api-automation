package Wallet.Fixtures;

import Wallet.DTOs.DeleteCreditPointsRequestDTO;
import Wallet.Utils.Utils;

public class DeleteCreditPointsRequestDTOFixture {

	public static DeleteCreditPointsRequestDTO build() {
		DeleteCreditPointsRequestDTO deleteCreditPointsRequestDTO = new DeleteCreditPointsRequestDTO();
		deleteCreditPointsRequestDTO.setTransactionId(Utils.getTRANSACTION_ID());
		return deleteCreditPointsRequestDTO;
	}
}
