package Wallet.Fixtures;

import Wallet.DTOs.Request.OrderRequestDTO;
import Wallet.Utils.Utils;
import org.apache.commons.lang3.RandomStringUtils;

public class OrderDTOFixture {

	private OrderRequestDTO orderRequestDTO;

	public OrderDTOFixture() {
		orderRequestDTO = new OrderRequestDTO();
		orderRequestDTO.setId(RandomStringUtils.randomNumeric(6));
		orderRequestDTO.setTotalPrice(100);
	}

	public OrderRequestDTO build() {
		return orderRequestDTO;
	}

	public OrderDTOFixture returnLastCreditPoints() {
		orderRequestDTO.setId(Utils.getLastConfirmedCreditPoints().getRequestDTO().getOrder().getId());
		orderRequestDTO.setTotalPrice(Utils.getLastConfirmedCreditPoints().getRequestDTO().getOrder().getTotalPrice());
		return this;
	}

	public OrderDTOFixture returnLastDebitPoints() {
		orderRequestDTO.setId(Utils.getLastDebitPoints().getRequestDTO().getOrder().getId());
		orderRequestDTO.setTotalPrice(Utils.getLastDebitPoints().getRequestDTO().getOrder().getTotalPrice());
		return this;
	}
}
