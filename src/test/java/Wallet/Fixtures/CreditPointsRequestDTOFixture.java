package Wallet.Fixtures;

import Wallet.DTOs.CreditPointsRequestDTO;
import Wallet.Utils.Utils;

public class CreditPointsRequestDTOFixture {

	public static CreditPointsRequestDTO build() {
		CreditPointsRequestDTO creditPointsRequestDTO = new CreditPointsRequestDTO();
		creditPointsRequestDTO.setDocument(Utils.getCPF());
		creditPointsRequestDTO.setAmount(100);
		creditPointsRequestDTO.setType("VALOR_MONETARIO");
		creditPointsRequestDTO.setStatus("CONFIRMADO");
		creditPointsRequestDTO.setDateTime("2004-02-12T14:18:20+00:00");
		creditPointsRequestDTO.setOrder(OrderDTOFixture.build());
//		creditPointsRequestDTO.setExtra();
		return creditPointsRequestDTO;
	}
}
