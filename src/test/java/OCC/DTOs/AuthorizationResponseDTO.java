package OCC.DTOs;

import Common.AbstractDTO;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class AuthorizationResponseDTO extends AbstractDTO<AuthorizationResponseDTO> {

	private Map<String,String> cookies;

	@SerializedName("access_token")
	private String accessToken;

	@SerializedName("token_type")
	private String tokenType;

	@SerializedName("refresh_token")
	private String refreshToken;

	@SerializedName("expires_in")
	private String expiresIn;

	@SerializedName("scope")
	private String scope;

	public Map<String, String> getCookies() {
		return cookies;
	}

	public void setCookies(Map<String, String> cookies) {
		this.cookies = cookies;
	}
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
}
