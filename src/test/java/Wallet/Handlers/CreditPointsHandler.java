package Wallet.Handlers;

import Wallet.DTOs.CreditPointsRequestDTO;

public class CreditPointsHandler {

	private String transactionId;
	private CreditPointsRequestDTO requestDTO;
	private boolean confirmed;

	public CreditPointsHandler(String transactionId, CreditPointsRequestDTO requestDTO) {
		this.transactionId = transactionId;
		this.requestDTO = requestDTO;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public CreditPointsRequestDTO getRequestDTO() {
		return requestDTO;
	}

	public void setRequestDTO(CreditPointsRequestDTO requestDTO) {
		this.requestDTO = requestDTO;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
}
