package Wallet.Enums;

import java.util.Arrays;
import java.util.Optional;

public enum DebitPointsTypeEnum {

	VALOR_MONETARIO("VALOR_MONETARIO"), QUANTIDADE_DE_PONTOS("QUANTIDADE_DE_PONTOS");

	private String value;

	DebitPointsTypeEnum(String value) {
		this.value = value;
	}

	public static DebitPointsTypeEnum getByValue(final String value) {
		return Arrays.stream(DebitPointsTypeEnum.values())
				.filter(origin -> origin.getValue().equals(value))
				.findFirst()
				.orElse(null);
	}

	public static String getValueByCreditPointsTypeEnum(final DebitPointsTypeEnum debitPointsTypeEnum) {
		return Optional.ofNullable(debitPointsTypeEnum)
				.map(DebitPointsTypeEnum::getValue)
				.orElse(null);
	}

	public String getValue() {
		return value;
	}
}
