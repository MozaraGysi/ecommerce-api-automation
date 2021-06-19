package Wallet.Fixtures;

import Wallet.DTOs.DebitPointsRequestDTO;
import Wallet.Utils.Utils;

public class DebitPointsRequestDTOFixture {

	private DebitPointsRequestDTO debitPointsRequestDTO;

	public DebitPointsRequestDTOFixture() {
		debitPointsRequestDTO = new DebitPointsRequestDTO();
		debitPointsRequestDTO.setDocument(Utils.getCPF());
		debitPointsRequestDTO.setAmount(100);
		debitPointsRequestDTO.setStatus("CONFIRMADO");
		debitPointsRequestDTO.setType("VALOR_MONETARIO");
		debitPointsRequestDTO.setDateTime("2004-02-12T14:18:20+00:00");
		debitPointsRequestDTO.setOrder(new OrderDTOFixture().build());
	}

	public DebitPointsRequestDTO build() {
		return debitPointsRequestDTO;
	}
}
