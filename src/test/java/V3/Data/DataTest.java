package V3.Data;

import V3.Utils.Utils;

import static Common.Utils.EnvConfig.getConfigValue;
import static V3.Utils.Utils.getWSUrlConfigMapped;

public class DataTest {

	public static String getWebServiceUrl() {
		return getConfigValue(getWSUrlConfigMapped(), Utils.getBrand(), "url");
	}

}
