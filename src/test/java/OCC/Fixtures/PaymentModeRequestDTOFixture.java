package OCC.Fixtures;

import OCC.DTOs.Request.PaymentModeRequestDTO;

public final class PaymentModeRequestDTOFixture {

	private PaymentModeRequestDTO paymentRequestDTO;

	private PaymentModeRequestDTOFixture() {
		paymentRequestDTO = new PaymentModeRequestDTO();
	}

	public static PaymentModeRequestDTOFixture get(){
		return new PaymentModeRequestDTOFixture();
	}

	public PaymentModeRequestDTO build() {
		return paymentRequestDTO;
	}

	private PaymentModeRequestDTOFixture random() {
		return this;
	}

	public static PaymentModeRequestDTOFixture getRandom() {
		return PaymentModeRequestDTOFixture.get().random();
	}

}