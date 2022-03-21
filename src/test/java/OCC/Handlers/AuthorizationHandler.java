package OCC.Handlers;

import OCC.DTOs.Response.AuthorizationResponseDTO;
import io.restassured.response.Response;

public final class AuthorizationHandler {

	static AuthorizationResponseDTO authorizationResponseDTO;

	public static void handleAuthorization(Response response) {
		authorizationResponseDTO = new AuthorizationResponseDTO().fromJsonString(response.getBody().asString());
		authorizationResponseDTO.setCookies(response.getCookies());
	}

	public static AuthorizationResponseDTO getAuthorization() {
		return authorizationResponseDTO;
	}

	public static void clear() {
		authorizationResponseDTO = null;
	}
}
