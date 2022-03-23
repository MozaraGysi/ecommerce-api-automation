package Wallet.Data;

import static Common.Utils.EnvConfig.getConfigValue;
import static Wallet.Utils.Utils.getWalletConfigMapped;

public class WalletDataTest {

	public static String getClientId() {
		return getConfigValue(getWalletConfigMapped(), "clientId");
	}

	public static String getClientSecret() {
		return getConfigValue(getWalletConfigMapped(), "clientSecret");
	}

	public static String getBaseUrl() {
		return getConfigValue(getWalletConfigMapped(), "baseUrl");
	}

	public static String getBaseAuthUrl() {
		return getConfigValue(getWalletConfigMapped(), "baseAuthUrl");
	}

	public static String getLoginEmail() {
		return getConfigValue(getWalletConfigMapped(), "loginEmail");
	}

	public static String getLoginDomain() {
		return getConfigValue(getWalletConfigMapped(), "loginDomain");
	}

}

