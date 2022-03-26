package OtherServices.Utils;

import Common.Utils.EnvConfig;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Utils {

	static String RESOURCE_NAME = "baseUrl";
	static Map<String, Object> BASEURL_CONFIG_MAPPED;

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

	public static Map<String, Object> getBaseUrlConfigMapped() {
		if (Objects.isNull(BASEURL_CONFIG_MAPPED)) {
			BASEURL_CONFIG_MAPPED = EnvConfig.getConfigs(RESOURCE_NAME, getEnv());
		}
		return BASEURL_CONFIG_MAPPED;
	}

	public static String getSite_UID() {
		String brand = getBrand().toUpperCase();
		switch (brand) {
			case "AREZZO":
				return "arezzo";
			case "ALEXANDREBIRMAN":
				return "alexandrebirman";
			case "ANACAPRI":
				return "anacapri";
			case "ALME":
				return "alme";
			case "FIEVER":
				return "fiever";
			case "SCHUTZ":
				return "schutz";
			case "VANS":
				return "vans";
			case "ZZMALL":
				return "marketplacezz";
			default:
				return null;
		}
	}

	public static String generateRandomString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		return salt.toString();
	}

}
