package OCC.Data;

import static Common.Utils.EnvConfig.getConfigValue;
import static OCC.Utils.Utils.getOCCConfigMapped;

public class OCCDataTest {

	public static String getBaseAuthUrl() {
		return getConfigValue(getOCCConfigMapped(), "baseAuthUrl");
	}

}

