package OCC.Fixtures;

import OCC.DTOs.Request.DeliveryModeRequestDTO;

public final class DeliveryModesRequestDTOFixture {

	private DeliveryModeRequestDTO deliveryModeRequestDTO;

	private DeliveryModesRequestDTOFixture() {
		deliveryModeRequestDTO = new DeliveryModeRequestDTO();
	}

	public static DeliveryModesRequestDTOFixture get(){
		return new DeliveryModesRequestDTOFixture();
	}

	public DeliveryModeRequestDTO build() {
		return deliveryModeRequestDTO;
	}

	private DeliveryModesRequestDTOFixture random() {
		return this;
	}

	public static DeliveryModesRequestDTOFixture getRandom() {
		return DeliveryModesRequestDTOFixture.get().random();
	}

}