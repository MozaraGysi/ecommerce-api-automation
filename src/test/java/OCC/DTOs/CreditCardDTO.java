package OCC.DTOs;

import Common.AbstractDTO;

public class CreditCardDTO extends AbstractDTO<CreditCardDTO> {

	private String cardNumber;
	private String accountHolderName;
	private String cpf;
	private String expiryMonth;
	private String expiryYear;
	private boolean defaultPayment;
	private String securityCode;
	private boolean saved;
	private short installments;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	public boolean isDefaultPayment() {
		return defaultPayment;
	}

	public void setDefaultPayment(boolean defaultPayment) {
		this.defaultPayment = defaultPayment;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public boolean isSaved() {
		return saved;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}

	public short getInstallments() {
		return installments;
	}

	public void setInstallments(short installments) {
		this.installments = installments;
	}
}
