package OCC.DTOs.Request;

import Common.AbstractDTO;

public class AddressRequestDTO extends AbstractDTO<AddressRequestDTO> {

	private String addressName;
	private String complement;
	private CountryRequestDTO country;
	private boolean defaultAddress;
	private String district;
	private String firstName;
	private String lastName;
	private String line1;
	private String line2;
	private String phone;
	private String postalCode;
	private String town;
	private String titleCode;
	private RegionRequestDTO region;

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public CountryRequestDTO getCountry() {
		return country;
	}

	public void setCountry(CountryRequestDTO country) {
		this.country = country;
	}

	public boolean isDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public RegionRequestDTO getRegion() {
		return region;
	}

	public void setRegion(RegionRequestDTO region) {
		this.region = region;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getTitleCode() {
		return titleCode;
	}

	public void setTitleCode(String titleCode) {
		this.titleCode = titleCode;
	}
}
