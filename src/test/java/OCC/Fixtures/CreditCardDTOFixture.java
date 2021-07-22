package OCC.Fixtures;

import OCC.DTOs.CartDTO;
import OCC.DTOs.CreditCardDTO;

public class CreditCardDTOFixture {

	private CreditCardDTO creditCardDTO;

	public CreditCardDTOFixture() {
		creditCardDTO = new CreditCardDTO();
		creditCardDTO.setCardNumber("4444333322221111");
		creditCardDTO.setAccountHolderName("Automation User");
		creditCardDTO.setCpf("03834691046");
		creditCardDTO.setExpiryMonth(String.valueOf(3));
		creditCardDTO.setExpiryYear(String.valueOf(2030));
		creditCardDTO.setDefaultPayment(true);
		creditCardDTO.setSecurityCode(String.valueOf(737));
		creditCardDTO.setSaved(true);
		creditCardDTO.setInstallments((short) 1);

	}

	public CreditCardDTO build() {
		return creditCardDTO;
	}
}
