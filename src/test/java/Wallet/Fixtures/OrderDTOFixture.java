package Wallet.Fixtures;

import Wallet.DTOs.OrderDTO;
import Wallet.Utils.Utils;

public class OrderDTOFixture {

	private OrderDTO orderDTO;

	public OrderDTOFixture() {
		orderDTO = new OrderDTO();
		orderDTO.setId("123");
		orderDTO.setTotalPrice(100);
	}

	public OrderDTO build() {
		return orderDTO;
	}

	public OrderDTOFixture returnLastCreditPoints() {
		orderDTO.setId(Utils.getLastConfirmedCreditPoints().getRequestDTO().getOrder().getId());
		orderDTO.setTotalPrice(Utils.getLastConfirmedCreditPoints().getRequestDTO().getOrder().getTotalPrice());
		return this;
	}

	public OrderDTOFixture returnLastDebitPoints() {
		orderDTO.setId(Utils.getLastDebitPoints().getRequestDTO().getOrder().getId());
		orderDTO.setTotalPrice(Utils.getLastDebitPoints().getRequestDTO().getOrder().getTotalPrice());
		return this;
	}
}
