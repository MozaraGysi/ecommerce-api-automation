package OtherServices.Data;

import OtherServices.Utils.Utils;

import static Common.Utils.EnvConfig.getConfigValue;
import static OtherServices.Utils.Utils.getBaseUrlConfigMapped;

public class DataTest {

	public static String getBaseUrl() {
		return getConfigValue(getBaseUrlConfigMapped(), Utils.getBrand(), "url");
	}

}

