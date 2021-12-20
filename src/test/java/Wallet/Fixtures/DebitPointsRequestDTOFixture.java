package Wallet.Fixtures;

import Wallet.DTOs.DebitPointsRequestDTO;
import Wallet.Enums.DebitPointsTypeEnum;
import Wallet.Utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DebitPointsRequestDTOFixture {

	private DebitPointsRequestDTO debitPointsRequestDTO;

	public DebitPointsRequestDTOFixture() {
		debitPointsRequestDTO = new DebitPointsRequestDTO();
		debitPointsRequestDTO.setDocument(Utils.getCPF());
		debitPointsRequestDTO.setAmount(4.91f);
		debitPointsRequestDTO.setStatus("CONFIRMADO");
		debitPointsRequestDTO.setType(DebitPointsTypeEnum.QUANTIDADE_DE_PONTOS.getValue());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		debitPointsRequestDTO.setDateTime(simpleDateFormat.format(new Date()));
		debitPointsRequestDTO.setOrder(new OrderDTOFixture().build());
	}

	public DebitPointsRequestDTO build() {
		return debitPointsRequestDTO;
	}

	public DebitPointsRequestDTOFixture type_VALOR_MONETARIO() {
		debitPointsRequestDTO.setType(DebitPointsTypeEnum.VALOR_MONETARIO.getValue());
		return this;
	}

	public DebitPointsRequestDTOFixture type_QUANTIDADE_DE_PONTOS() {
		debitPointsRequestDTO.setType(DebitPointsTypeEnum.QUANTIDADE_DE_PONTOS.getValue());
		return this;
	}

	public DebitPointsRequestDTOFixture withoutOrder() {
		debitPointsRequestDTO.setOrder(null);
		return this;
	}

	public DebitPointsRequestDTOFixture returnLastCreditPoints() {
		debitPointsRequestDTO.setAmount(Utils.getLastConfirmedCreditPoints().getRequestDTO().getCreditAmount());
		debitPointsRequestDTO.setType(DebitPointsTypeEnum.QUANTIDADE_DE_PONTOS.getValue());
		if (Objects.nonNull(Utils.getLastConfirmedCreditPoints().getRequestDTO().getOrder())) {
			debitPointsRequestDTO.setOrder(new OrderDTOFixture().returnLastCreditPoints().build());
		}
		return this;
	}

	public DebitPointsRequestDTOFixture withoutAvailableAmount() {
		debitPointsRequestDTO.setAmount(Utils.getAvailableAmount()+1);
		debitPointsRequestDTO.setType(DebitPointsTypeEnum.QUANTIDADE_DE_PONTOS.getValue());
		return this;
	}
}
