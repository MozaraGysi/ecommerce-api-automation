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
		orderDTO.setId(Utils.getLastCreditPoints().getOrder().getId());
		orderDTO.setTotalPrice(Utils.getLastCreditPoints().getOrder().getTotalPrice());
		return this;
	}

	public OrderDTOFixture returnLastDebitPoints() {
		orderDTO.setId(Utils.getLastDebitPoints().getOrder().getId());
		orderDTO.setTotalPrice(Utils.getLastDebitPoints().getOrder().getTotalPrice());
		return this;
	}
}
