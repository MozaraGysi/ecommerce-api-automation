package Wallet.Fixtures;

import Wallet.DTOs.Request.CreditPointsRequestDTO;
import Wallet.DTOs.Request.OrderRequestDTO;
import Wallet.Enums.CreditPointsTypeEnum;
import Wallet.Enums.CreditTransactionStatusEnum;
import Wallet.Utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class CreditPointsRequestDTOFixture {

	private CreditPointsRequestDTO creditPointsRequestDTO;
	private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

	public CreditPointsRequestDTOFixture() {
		creditPointsRequestDTO = new CreditPointsRequestDTO();
		creditPointsRequestDTO.setDocument(Utils.getCPF());
		creditPointsRequestDTO.setAmount(660.66F);
		creditPointsRequestDTO.setType(CreditPointsTypeEnum.QUANTIDADE_DE_PONTOS.getValue());
		creditPointsRequestDTO.setStatus(CreditTransactionStatusEnum.CONFIRMADO.getValue());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
		creditPointsRequestDTO.setDateTime(simpleDateFormat.format(new Date()));
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

	public CreditPointsRequestDTOFixture status_CONFIRMADO() {
		creditPointsRequestDTO.setStatus(CreditTransactionStatusEnum.CONFIRMADO.getValue());
		return this;
	}

	public CreditPointsRequestDTOFixture status_PENDENTE() {
		creditPointsRequestDTO.setStatus(CreditTransactionStatusEnum.PENDENTE.getValue());
		return this;
	}

	public CreditPointsRequestDTOFixture withoutOrder() {
		creditPointsRequestDTO.setOrder(null);
		return this;
	}

	public CreditPointsRequestDTOFixture withOrder(OrderRequestDTO orderRequestDTO) {
		creditPointsRequestDTO.setOrder(orderRequestDTO);
		return this;
	}

	public CreditPointsRequestDTOFixture returnLastDebitPoints() {
		creditPointsRequestDTO.setAmount(Utils.getLastDebitPoints().getRequestDTO().getDebitAmount());
		creditPointsRequestDTO.setType(CreditPointsTypeEnum.QUANTIDADE_DE_PONTOS.getValue());
		if (Objects.nonNull(Utils.getLastDebitPoints().getRequestDTO().getOrder())) {
			creditPointsRequestDTO.setOrder(new OrderDTOFixture().returnLastDebitPoints().build());
		}
		return this;
	}
}
