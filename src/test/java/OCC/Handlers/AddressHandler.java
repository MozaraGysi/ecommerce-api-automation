package OCC.Handlers;

import OCC.DTOs.Response.AddressResponseDTO;
import OCC.DTOs.Response.AuthorizationResponseDTO;
import io.restassured.response.Response;

import java.util.ArrayList;

public final class AddressHandler {

	static AddressResponseDTO addressResponseDTO;

	public static void handleAddress(Response response) {
		addressResponseDTO = new AddressResponseDTO().fromJsonString(response.getBody().asString());
		addressResponseDTO.setIdAddress(formatIdAddress(response.getBody().jsonPath().get("addresses.id")));
	}

	private static String formatIdAddress(ArrayList idAddress){
		return idAddress.get(0).toString().replace("[","").replace("]","");
	}

	public static AddressResponseDTO getAddress() {
		return addressResponseDTO;
	}

	public static void clear() {
		addressResponseDTO = null;
	}
}
