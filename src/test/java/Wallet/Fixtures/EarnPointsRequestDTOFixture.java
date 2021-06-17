package Wallet.Fixtures;

import Wallet.DTOs.EarnPointsRequestDTO;
import Wallet.Utils.Utils;

public class EarnPointsRequestDTOFixture {

	public static EarnPointsRequestDTO build() {
		EarnPointsRequestDTO earnPointsRequestDTO = new EarnPointsRequestDTO();
		earnPointsRequestDTO.setDocument(Utils.getCPF());
		earnPointsRequestDTO.setAmount(100.00f);
		earnPointsRequestDTO.setType("VALOR_MONETARIO");
		earnPointsRequestDTO.setStatus("CONFIRMADO");
		earnPointsRequestDTO.setDateTime("2004-02-12T14:18:20+00:00");
		earnPointsRequestDTO.setOrder(OrderDTOFixture.build());
//		earnPointsRequestDTO.setExtra();
		return earnPointsRequestDTO;
	}
}
