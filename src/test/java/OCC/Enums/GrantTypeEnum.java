package OCC.Enums;

public enum GrantTypeEnum {

	PASSWORD("password"),
	CLIENT_CREDENTIALS("client_credentials"),
	APPLE_ID("apple_id"),
	FACEBOOK("facebook");

	private final String value;

	GrantTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
