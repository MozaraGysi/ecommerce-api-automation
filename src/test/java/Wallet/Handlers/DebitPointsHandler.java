package Wallet.Handlers;

import Wallet.DTOs.Request.DebitPointsRequestDTO;

public class DebitPointsHandler {

	private String transactionId;
	private DebitPointsRequestDTO requestDTO;

	public DebitPointsHandler(String transactionId, DebitPointsRequestDTO requestDTO) {
		this.transactionId = transactionId;
		this.requestDTO = requestDTO;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public DebitPointsRequestDTO getRequestDTO() {
		return requestDTO;
	}

	public void setRequestDTO(DebitPointsRequestDTO requestDTO) {
		this.requestDTO = requestDTO;
	}
}
