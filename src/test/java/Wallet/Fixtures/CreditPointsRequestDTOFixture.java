package Wallet.Fixtures;

import Wallet.DTOs.CreditPointsRequestDTO;
import Wallet.Enums.CreditPointsTypeEnum;
import Wallet.Utils.Utils;

import java.util.Objects;

public class CreditPointsRequestDTOFixture {

	private CreditPointsRequestDTO creditPointsRequestDTO;

	public CreditPointsRequestDTOFixture() {
		creditPointsRequestDTO = new CreditPointsRequestDTO();
		creditPointsRequestDTO.setDocument(Utils.getCPF());
		creditPointsRequestDTO.setAmount(660.66f);
		creditPointsRequestDTO.setType(CreditPointsTypeEnum.VALOR_MONETARIO.getValue());
		creditPointsRequestDTO.setStatus("CONFIRMADO");
		creditPointsRequestDTO.setDateTime("2004-02-12T14:18:20+00:00");
		creditPointsRequestDTO.setOrder(new OrderDTOFixture().build());
	}

	public CreditPointsRequestDTO build() {
		return creditPointsRequestDTO;
	}

	public CreditPointsRequestDTOFixture type_VALOR_MONETARIO() {
		creditPointsRequestDTO.setType(CreditPointsTypeEnum.VALOR_MONETARIO.getValue());
		return this;
	}

	public CreditPointsRequestDTOFixture type_QUANTIDADE_DE_PONTOS() {
		creditPointsRequestDTO.setType(CreditPointsTypeEnum.QUANTIDADE_DE_PONTOS.getValue());
		return this;
	}

	public CreditPointsRequestDTOFixture withoutOrder() {
		creditPointsRequestDTO.setOrder(null);
		return this;
	}

	public CreditPointsRequestDTOFixture returnLastDebitPoints() {
		creditPointsRequestDTO.setAmount(Utils.getLastDebitPoints().getDebitAmount());
		creditPointsRequestDTO.setType(CreditPointsTypeEnum.QUANTIDADE_DE_PONTOS.getValue());
		if (Objects.nonNull(Utils.getLastDebitPoints())) {
			creditPointsRequestDTO.setOrder(new OrderDTOFixture().returnLastDebitPoints().build());
		}
		return this;
	}
}
