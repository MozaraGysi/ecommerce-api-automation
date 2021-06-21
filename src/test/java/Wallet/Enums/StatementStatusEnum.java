package Wallet.Enums;

import java.util.Arrays;
import java.util.Optional;

public enum StatementStatusEnum {

	CONFIRMADO("CONFIRMADO");

	private String value;

	StatementStatusEnum(String value) {
		this.value = value;
	}

	public static StatementStatusEnum getByValue(final String value) {
		return Arrays.stream(StatementStatusEnum.values())
				.filter(origin -> origin.getValue().equals(value))
				.findFirst()
				.orElse(null);
	}

	public static String getValueByStatementStatusEnum(final StatementStatusEnum statementStatusEnum) {
		return Optional.ofNullable(statementStatusEnum)
				.map(StatementStatusEnum::getValue)
				.orElse(null);
	}

	public String getValue() {
		return value;
	}
}
