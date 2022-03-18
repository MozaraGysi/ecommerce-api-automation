package OCC.Handlers;

import OCC.DTOs.AuthorizationResponseDTO;

public final class AuthorizationHandler {

	static AuthorizationResponseDTO authorizationResponseDTO;

	public static void setAuthorization(AuthorizationResponseDTO authorizationResponseDTO) {
		AuthorizationHandler.authorizationResponseDTO = authorizationResponseDTO;

	}

	public static AuthorizationResponseDTO getAuthorization() {
		return authorizationResponseDTO;
	}

	public static void clear() {
		authorizationResponseDTO = null;
	}
}
