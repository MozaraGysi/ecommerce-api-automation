package OCC.Data;

import java.util.List;
import java.util.Locale;

import static Common.Utils.EnvConfig.*;
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

	public static String getProductSellerExterno(){
		return getProducts("SellerExterno").get(0).concat("-36");
	}

	public static String getBaseUrl(boolean auth){
		if(auth){
			return getConfigValue(getConfigMappedBaseUrl(), getBrand().toLowerCase(Locale.ROOT));
		}
		return getConfigValue(getConfigMappedBaseUrl(), getBrand().toLowerCase(Locale.ROOT)) + URL_COMPLEMENT();
	}

	public static String getUser(String user){
		return getConfigValue(getMappedUsers(),user);
	}

}

