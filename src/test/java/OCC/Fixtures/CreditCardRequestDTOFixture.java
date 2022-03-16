package OCC.Fixtures;

import OCC.DTOs.Request.CreditCardRequestDTO;

public final class CreditCardRequestDTOFixture {

	private CreditCardRequestDTO creditCardDTO;

	private CreditCardRequestDTOFixture() {
		creditCardDTO = new CreditCardRequestDTO();
	}

	public static CreditCardRequestDTOFixture get(){
		return new CreditCardRequestDTOFixture();
	}

	public CreditCardRequestDTO build() {
		return creditCardDTO;
	}

	public CreditCardRequestDTOFixture defaultCreditCard() {
		creditCardDTO.setCardNumber("4444333322221111");
		creditCardDTO.setAccountHolderName("Automation User");
		creditCardDTO.setCpf("03834691046");
		creditCardDTO.setExpiryMonth(String.valueOf(3));
		creditCardDTO.setExpiryYear(String.valueOf(2030));
		creditCardDTO.setDefaultPayment(true);
		creditCardDTO.setSecurityCode(String.valueOf(737));
		creditCardDTO.setSaved(true);
		creditCardDTO.setInstallments((short) 1);
		return this;
	}
}
