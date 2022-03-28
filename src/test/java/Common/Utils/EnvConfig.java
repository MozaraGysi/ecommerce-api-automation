package Common.Utils;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.ArrayUtils;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static OCC.Utils.Utils.OCC_API_NAME;
import static Wallet.Utils.Utils.WALLET_API_NAME;

public class EnvConfig {

	static String API_CONFIG_PATH = "src/test/resources/%s/%s-config.yml";
	static String OCC_PRODUCT_CONFIG_PATH = "src/test/resources/%s/product/%s-config.yml";
	static String OCC_BASE_URL_CONFIG_PATH = "src/test/resources/%s/baseUrl/%s-config.yml";

	public static Map<String, Object> getConfigs(final String api, final String env) {
		Map<String, Object> element = null;
		try {
			if (env != null || api != null) {
				InputStream inputStream = new FileInputStream(String.format(API_CONFIG_PATH, api, env));
				element = new Yaml(new Constructor(Object.class)).load(inputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return element;
	}

	public static Map<String, Object> getConfigsBaseUrl(final String api, final String env) {
		Map<String, Object> element = null;
		try {
			if (env != null || api != null) {
				InputStream inputStream = new FileInputStream(String.format(OCC_BASE_URL_CONFIG_PATH, api, env));
				element = new Yaml(new Constructor(Object.class)).load(inputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return element;
	}

	public static Map<String, Object> getConfigsProduct(final String api, final String env) {
		Map<String, Object> element = null;
		try {
			if (env != null || api != null) {
				InputStream inputStream = new FileInputStream(String.format(OCC_PRODUCT_CONFIG_PATH, api, env));
				element = new Yaml(new Constructor(Object.class)).load(inputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return element;
	}

	public static String getConfigValue(Object configObject, String... valuePath) {
		List<String> list = getConfigValueList(configObject, valuePath);
		return !list.isEmpty() ? list.get(0) : "";
	}

	public static List<String> getConfigValueList(Object configObject, String... valuePath) {
		String[] nextKeys = new String[valuePath.length - 1];
		System.arraycopy(valuePath, 1, nextKeys, 0, valuePath.length - 1);
		if (configObject instanceof Map) {
			configObject = ((Map<?, ?>) configObject).get(valuePath[0]);
			return getConfigValueList(configObject, ArrayUtils.isEmpty(nextKeys) ? new String[1] : nextKeys);
		} else if (configObject instanceof List) {
			return (List<String>) configObject;
		} else if (configObject instanceof String) {
			return Lists.newArrayList(configObject.toString());
		}
		return Lists.newArrayList();
	}

}
