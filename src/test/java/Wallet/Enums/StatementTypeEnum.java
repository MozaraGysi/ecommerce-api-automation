package Wallet.Enums;

import java.util.Arrays;
import java.util.Optional;

public enum StatementTypeEnum {

	CREDITO("CREDITO"), DEBITO("DEBITO");

	private String value;

	StatementTypeEnum(String value) {
		this.value = value;
	}

	public static StatementTypeEnum getByValue(final String value) {
		return Arrays.stream(StatementTypeEnum.values())
				.filter(origin -> origin.getValue().equals(value))
				.findFirst()
				.orElse(null);
	}

	public static String getValueByStatementTypeEnum(final StatementTypeEnum statementTypeEnum) {
		return Optional.ofNullable(statementTypeEnum)
				.map(StatementTypeEnum::getValue)
				.orElse(null);
	}

	public String getValue() {
		return value;
	}
}
