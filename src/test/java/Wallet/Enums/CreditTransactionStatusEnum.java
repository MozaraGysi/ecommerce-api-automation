package Wallet.Enums;

import java.util.Arrays;
import java.util.Optional;

public enum CreditTransactionStatusEnum {

	PENDENTE("PENDENTE"), CONFIRMADO("CONFIRMADO");

	private String value;

	CreditTransactionStatusEnum(String value) {
		this.value = value;
	}

	public static CreditTransactionStatusEnum getByValue(final String value) {
		return Arrays.stream(CreditTransactionStatusEnum.values())
				.filter(origin -> origin.getValue().equals(value))
				.findFirst()
				.orElse(null);
	}

	public static String getValueByCreditTransactionStatusEnum(final CreditTransactionStatusEnum creditTransactionStatusEnum) {
		return Optional.ofNullable(creditTransactionStatusEnum)
				.map(CreditTransactionStatusEnum::getValue)
				.orElse(null);
	}

	public String getValue() {
		return value;
	}
}
