package Wallet.Fixtures;

import Wallet.DTOs.CustomerRequestDTO;
import Wallet.Utils.Utils;

public class CustomerRequestDTOFixture {

	public static CustomerRequestDTO build() {
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
		customerRequestDTO.setDocument(Utils.getCPF());
		customerRequestDTO.setFirstName("Leonardo");
		customerRequestDTO.setLastName("Wille");
		customerRequestDTO.setEmail(Utils.getEMAIL());
		customerRequestDTO.setBirthday("2000-01-22");
		customerRequestDTO.setMobile(5551998288513L);
		return customerRequestDTO;
	}
}
