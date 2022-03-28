package OtherServices.Data;

import OtherServices.Utils.Utils;

import static Common.Utils.EnvConfig.getConfigValue;
import static OtherServices.Utils.Utils.getBaseUrlConfigMapped;

public class DataTest {

	public static String getBaseUrl() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "url");
	}

	public static String getAuth() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "auth");
	}

	public static String getLoginTele() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "loginTele");
	}

	public static String getPasswordTele() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "passwordTele");
	}

	public static String getCustomerFirstName() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerFirstName");
	}

	public static String getCustomerLastName() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerLastName");
	}

	public static String getCustomerBirthday() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerBirthday");
	}

	public static String getCustomerCPF() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerCPF");
	}

	public static String getCustomerAppUser() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerAppUser");
	}

	public static String getCustomerNewsletter() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerNewsletter");
	}

	public static String getCustomerLandlinePhone() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerLandlinePhone");
	}

	public static String getCustomerMobilePhone() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerMobilePhone");
	}

	public static String getCustomerAddressName() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerAddressName");
	}

	public static String getCustomerStreetName() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerStreetName");
	}

	public static String getCustomerStreetNumber() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerStreetNumber");
	}

	public static String getCustomerComplement() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerComplement");
	}

	public static String getCustomerRemarks() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerRemarks");
	}

	public static String getCustomerPostalCode() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerPostalCode");
	}

	public static String getCustomerDistrict() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerDistrict");
	}

	public static String getCustomerTown() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerTown");
	}

	public static String getCustomerRegion() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "customerRegion");
	}

	public static String getEmployeeCpf() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "employeeCpf");
	}

	public static String getEmployeeName() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "employeeName");
	}

	public static String getEmployeePwd() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "employeePwd");
	}

	public static String getEmployeeBirthday() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "employeeBirthday");
	}

	public static String getEmployeeStreetName() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "employeeStreetName");
	}

	public static String getEmployeeStreetNumber() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "employeeStreetNumber");
	}

	public static String getEmployeePostalCode() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "employeePostalCode");
	}

	public static String getEmployeeDistrict() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "employeeDistrict");
	}

	public static String getEmployeeTown() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "employeeTown");
	}

	public static String getEmployeeRegion() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "employeeRegion");
	}

	public static String getAbacosLogin() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "abacosLogin");
	}

}

