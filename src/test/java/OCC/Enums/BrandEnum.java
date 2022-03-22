package OCC.Enums;

public enum BrandEnum {
	AREZZO("arezzo"),
	ALEXANDREBIRMAN("birman"),
	ANACAPRI("anacapri"),
	ALME("alme"),
	FIEVER("fiever"),
	SCHUTZ("schutz"),
	VANS("vans"),
	ZZMALL("marketplacezz");

	private final String value;

	BrandEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
