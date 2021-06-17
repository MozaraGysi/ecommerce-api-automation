package Wallet.Pages;

import Wallet.APIClient;
import Wallet.DTOs.CustomerRequestDTO;
import Wallet.Fixtures.CustomerRequestDTOFixture;
import Wallet.Validators.StatusCodeBadRequestValidator;
import Wallet.Validators.StatusCodeCreatedValidator;
import Wallet.Validators.Validator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class CustomerPage {

	public static void newUser() {
		CustomerRequestDTO customerRequestDTO = CustomerRequestDTOFixture.build();

		Response response = APIClient.POST_customers(customerRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void newUserWithoutCPF() {
		CustomerRequestDTO customerRequestDTO = CustomerRequestDTOFixture.build();
		customerRequestDTO.setDocument(null);

		Response response = APIClient.POST_customers(customerRequestDTO.toJson());

		List<Validator> validators = Arrays.asList();
		// TODO: Add after remove API mocks
		//new StatusCodeBadRequestValidator();
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void newUserWithoutFirstName() {
		CustomerRequestDTO customerRequestDTO = CustomerRequestDTOFixture.build();
		customerRequestDTO.setFirstName(null);

		Response response = APIClient.POST_customers(customerRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeBadRequestValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void newUserWithoutLastName() {
		CustomerRequestDTO customerRequestDTO = CustomerRequestDTOFixture.build();
		customerRequestDTO.setLastName(null);

		Response response = APIClient.POST_customers(customerRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeBadRequestValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}
}
