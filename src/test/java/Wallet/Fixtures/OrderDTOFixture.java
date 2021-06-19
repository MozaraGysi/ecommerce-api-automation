package Wallet.Fixtures;

import Wallet.DTOs.OrderDTO;

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
}
