package OCC.Handlers;

import OCC.DTOs.AuthorizationResponseDTO;

public final class AuthorizationHandler {

	static AuthorizationResponseDTO authorizationResponseDTO;

	public static void addAuthorization(AuthorizationResponseDTO authorizationResponseDTO) {
		AuthorizationHandler.authorizationResponseDTO = authorizationResponseDTO;

	}

	public static AuthorizationResponseDTO getAuthorization() {
		return authorizationResponseDTO;
	}
}
