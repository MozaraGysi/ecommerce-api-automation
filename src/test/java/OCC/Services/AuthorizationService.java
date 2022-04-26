package OCC.Services;

import Common.Validators.StatusCodeOKValidator;
import Common.Validators.Validator;
import OCC.DTOs.Request.AuthorizationRequestDTO;
import OCC.Fixtures.AuthorizationRequestDTOFixture;
import OCC.Handlers.AuthorizationHandler;
import OCC.Utils.APIClient;
import OCC.Validators.AnonymousAuthorizationValidator;
import OCC.Validators.CustomerAuthorizationValidator;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class AuthorizationService {

	public static void CustomerToken() {
		AuthorizationRequestDTO authorizationRequestDTO = AuthorizationRequestDTOFixture
				.getRandom()
				.withDefaultUser()
				.build();

		Response response = APIClient.postAuthorization(authorizationRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new CustomerAuthorizationValidator());
		validators.stream().forEach(validator -> validator.validate(response));

		AuthorizationHandler.handleAuthorization(response);
	}

	public static void CustomerTokenNewUser() {
		AuthorizationRequestDTO authorizationRequestDTO = AuthorizationRequestDTOFixture
				.getRandom()
				.build();

		Response response = APIClient.postAuthorization(authorizationRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new CustomerAuthorizationValidator());
		validators.stream().forEach(validator -> validator.validate(response));

		AuthorizationHandler.handleAuthorization(response);
	}

	public static void AnonymousAuth() {
		AuthorizationRequestDTO authorizationRequestDTO = AuthorizationRequestDTOFixture
				.getRandom()
				.withAnonymousUser()
				.build();

		Response response = APIClient.postAuthorization(authorizationRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new AnonymousAuthorizationValidator());
		validators.stream().forEach(validator -> validator.validate(response));

		AuthorizationHandler.handleAuthorization(response);
	}

	public static void RegisterCustomerAppleID() {
		AuthorizationRequestDTO authorizationRequestDTO = AuthorizationRequestDTOFixture
				.getRandom()
				.withAppleUser()
				.build();

		Response response = APIClient.postAuthorization(authorizationRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new CustomerAuthorizationValidator());
		validators.stream().forEach(validator -> validator.validate(response));

		AuthorizationHandler.handleAuthorization(response);
	}

	public static void RegisterCustomerFacebook() {
		AuthorizationRequestDTO authorizationRequestDTO = AuthorizationRequestDTOFixture
				.getRandom()
				.withFacebookUser()
				.build();

		Response response = APIClient.postAuthorization(authorizationRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeOKValidator(), new CustomerAuthorizationValidator());
		validators.stream().forEach(validator -> validator.validate(response));

		AuthorizationHandler.handleAuthorization(response);
	}
}
