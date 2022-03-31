package V3.Utils;

import Common.Utils.EnvConfig;

import java.util.Map;
import java.util.Objects;

public class Utils {

	static String RESOURCE_NAME = "WebService";
	static Map<String, Object> WEBSERVICE_CONFIG_MAPPED;

	public static String getBrand() {
		String brand = "";
		if (System.getProperty("brand") == null) {
			System.out.println("Empresa não adicionada: Ex.: -Dbrand=Arezzo ");
		} else {
			brand = System.getProperty("brand");
		}
		return brand;
	}

	private static String getEnv() {
		String env = "";
		if (System.getProperty("env") == null) {
			System.out.println("Env não adicionado: Ex.: -Denv=hml ");
		} else {
			env = System.getProperty("env");
		}
		return env;
	}

	public static Map<String, Object> getWSUrlConfigMapped() {
		if (Objects.isNull(WEBSERVICE_CONFIG_MAPPED)) {
			WEBSERVICE_CONFIG_MAPPED = EnvConfig.getConfigs(RESOURCE_NAME, getEnv());
		}
		return WEBSERVICE_CONFIG_MAPPED;
	}

}
