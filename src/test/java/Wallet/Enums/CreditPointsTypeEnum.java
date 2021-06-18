package Wallet.Enums;

import java.util.Arrays;
import java.util.Optional;

public enum CreditPointsTypeEnum {

	VALOR_MONETARIO("VALOR_MONETARIO"), QUANTIDADE_DE_PONTOS("QUANTIDADE_DE_PONTOS");

	private String value;

	CreditPointsTypeEnum(String value) {
		this.value = value;
	}

	public static CreditPointsTypeEnum getByValue(final String value) {
		return Arrays.stream(CreditPointsTypeEnum.values())
				.filter(origin -> origin.getValue().equals(value))
				.findFirst()
				.orElse(null);
	}

	public static String getValueByCreditTransactionStatusEnum(final CreditPointsTypeEnum creditTransactionStatusEnum) {
		return Optional.ofNullable(creditTransactionStatusEnum)
				.map(CreditPointsTypeEnum::getValue)
				.orElse(null);
	}

	public String getValue() {
		return value;
	}
}
