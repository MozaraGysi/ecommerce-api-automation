package OCC.Fixtures;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

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

	private CreditCardRequestDTOFixture random() {
		return this
		.withCardNumber(RandomStringUtils.random(16, false, true))
		.withAccountHolderName(RandomStringUtils.random(7, true, false))
		.withCpf(RandomStringUtils.random(1, false, true))
		.withExpiryMonth(String.valueOf(RandomUtils.nextInt(1, 12)))
		.withExpiryYear(String.valueOf(RandomUtils.nextInt(2023, 2099)))
		.withDefaultPayment(RandomUtils.nextBoolean())
		.withSecurityCode(String.valueOf(RandomUtils.nextInt(0, 999)))
		.withSaved(RandomUtils.nextBoolean())
		.withInstallments((short) RandomUtils.nextInt(1, 9));
	}

	public static CreditCardRequestDTOFixture getRandom() {
		return CreditCardRequestDTOFixture.get().random();
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


		public CreditCardRequestDTOFixture withCardNumber(String cardNumber){
			creditCardDTO.setCardNumber(cardNumber);
			return this;
		}

		public CreditCardRequestDTOFixture withAccountHolderName(String accountHolderName){
			creditCardDTO.setAccountHolderName(accountHolderName);
			return this;
		}

		public CreditCardRequestDTOFixture withCpf(String cpf){
			creditCardDTO.setCpf(cpf);
			return this;
		}

		public CreditCardRequestDTOFixture withExpiryMonth(String expiryMonth){
			creditCardDTO.setExpiryMonth(expiryMonth);
			return this;
		}

		public CreditCardRequestDTOFixture withExpiryYear(String expiryYear){
			creditCardDTO.setExpiryYear(expiryYear);
			return this;
		}

		public CreditCardRequestDTOFixture withDefaultPayment(boolean defaultPayment){
			creditCardDTO.setDefaultPayment(defaultPayment);
			return this;
		}

		public CreditCardRequestDTOFixture withSecurityCode(String securityCode){
			creditCardDTO.setSecurityCode(securityCode);
			return this;
		}

		public CreditCardRequestDTOFixture withSaved(boolean saved){
			creditCardDTO.setSaved(saved);
			return this;
		}

		public CreditCardRequestDTOFixture withInstallments(short installments){
			creditCardDTO.setInstallments(installments);
			return this;
		}


}
