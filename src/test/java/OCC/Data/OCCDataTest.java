package OCC.Data;

import java.util.List;

import static Common.Utils.EnvConfig.getConfigValue;
import static Common.Utils.EnvConfig.getConfigValueList;
import static OCC.Utils.Utils.*;

public class OCCDataTest {

	public static String FIELDS = "FULL";
	public static String PAGE = "0";

	public static List<String> getProducts(String type) {
		return getConfigValueList(getConfigMappedProducts(), type, getBrand(), "sku");
	}

	public static String getProductPadrao(){
		return getProducts("Padrao").get(0);
	}

	public static String getProductSellerExterno() {
		return getProducts("SellerExterno").get(0).concat("-36");
	}

	public static List<String> getStores(String type, String valuePath) {
		return getConfigValueList(getConfigMappededStores(), type, getBrand(), valuePath);
	}

	public static String getDefaultPostalCode() {
		return getStores("Padrao", "DefaultPostalCode").get(0);
	}

	public static String getDefaultAddress() {
		return getStores("Padrao", "DefaultAddress").get(0);
	}

	public static String getDefaultWrongAddress() {
		return getStores("Padrao", "DefaultWrongAddress").get(0);
	}

	public static String getDefaultWrongPostalCode() {
		return getStores("Padrao", "DefaultWrongPostalCode").get(0);
	}

	public static Double getDefaultLatitude(){
		return Double.valueOf(getStores("Padrao", "DefaultLatitude").get(0));
	}

	public static Double getDefaultLongitude(){
		return Double.valueOf(getStores("Padrao", "DefaultLongitude").get(0));
	}

	public static String getBaseUrl(boolean auth) {
		if (auth) {
			return getConfigValue(getConfigMappedBaseUrl(), getBrand(), "url");
		}
		return getConfigValue(getConfigMappedBaseUrl(), getBrand(), "url") + URL_COMPLEMENT();
	}

	public static String getUser(String user) {
		return getConfigValue(getMappedUsers(), user);
	}

	public static String getFacebookToken() {
		return getConfigValue(getMappedUsers(), "FacebookToken");
	}

	public static String getDefaultUser() {
		return getConfigValue(getMappedUsers(), "DefaultUsername");
	}

	public static String getDefaultUserPassword() {
		return getConfigValue(getMappedUsers(), "DefaultUserPassword");
	}

	public static String getAppleUserUsername() {
		return getConfigValue(getMappedUsers(), "AppleUserUsername");
	}

	public static String getAppleUserAppledId() {
		return getConfigValue(getMappedUsers(), "AppleUserAppledId");
	}

	public static String getAppleUserFirstName() {
		return getConfigValue(getMappedUsers(), "AppleUserFirstName");
	}

	public static String getAppleUserLastName() {
		return getConfigValue(getMappedUsers(), "AppleUserLastName");
	}

}

