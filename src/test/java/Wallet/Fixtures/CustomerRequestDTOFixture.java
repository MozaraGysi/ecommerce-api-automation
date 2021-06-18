package Wallet.Fixtures;

import Wallet.DTOs.CustomerRequestDTO;
import Wallet.Utils.Utils;

public class CustomerRequestDTOFixture {

	private CustomerRequestDTO customerRequestDTO;

	public CustomerRequestDTOFixture() {
		customerRequestDTO = new CustomerRequestDTO();
		customerRequestDTO.setDocument(Utils.getCPF());
		customerRequestDTO.setFirstName("Leonardo");
		customerRequestDTO.setLastName("Wille");
		customerRequestDTO.setEmail(Utils.getEMAIL());
		customerRequestDTO.setBirthday("2000-01-22");
		customerRequestDTO.setMobile(5551998288513L);
	}

	public CustomerRequestDTO build() {
		return customerRequestDTO;
	}

	public CustomerRequestDTOFixture withoutDocument() {
		customerRequestDTO.setDocument(null);
		return this;
	}

	public CustomerRequestDTOFixture withoutFirstName() {
		customerRequestDTO.setFirstName(null);
		return this;
	}

	public CustomerRequestDTOFixture withoutLastName() {
		customerRequestDTO.setLastName(null);
		return this;
	}
}
