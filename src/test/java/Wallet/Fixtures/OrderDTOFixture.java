package Wallet.Fixtures;

import Wallet.DTOs.OrderDTO;

public class OrderDTOFixture {

	public static OrderDTO build() {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId("123");
		return orderDTO;
	}
}
