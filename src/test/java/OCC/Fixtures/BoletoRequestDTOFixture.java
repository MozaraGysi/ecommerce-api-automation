package OCC.Fixtures;

import OCC.DTOs.Request.BoletoRequestDTO;
import OCC.DTOs.Request.CreditCardRequestDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public final class BoletoRequestDTOFixture {

	private BoletoRequestDTO boletoRequestDTO;

	private BoletoRequestDTOFixture() {
		boletoRequestDTO = new BoletoRequestDTO();
	}

	public static BoletoRequestDTOFixture get(){
		return new BoletoRequestDTOFixture();
	}

	public BoletoRequestDTO build() {
		return boletoRequestDTO;
	}

	private BoletoRequestDTOFixture random() {
		return this;
	}

	public static BoletoRequestDTOFixture getRandom() {
		return BoletoRequestDTOFixture.get().random();
	}

}