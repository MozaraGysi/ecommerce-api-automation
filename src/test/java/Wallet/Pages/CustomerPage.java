package Wallet.Pages;

import Wallet.APIClient;
import Wallet.DTOs.CustomerRequestDTO;
import Wallet.Fixtures.CustomerRequestDTOFixture;
import Wallet.Validators.StatusCodeBadRequestValidator;
import Wallet.Validators.StatusCodeCreatedValidator;
import Wallet.Validators.StatusCodeUnprocessableEntityValidator;
import Wallet.Validators.Validator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class CustomerPage {

	public static void newUser() {
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTOFixture().build();

		Response response = APIClient.POST_customers(customerRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void newUserWithoutCPF() {
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTOFixture().withoutDocument().build();

		Response response = APIClient.POST_customers(customerRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeBadRequestValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void newUserWithoutFirstName() {
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTOFixture().withoutFirstName().build();

		Response response = APIClient.POST_customers(customerRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeUnprocessableEntityValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void newUserWithoutLastName() {
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTOFixture().withoutLastName().build();

		Response response = APIClient.POST_customers(customerRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeUnprocessableEntityValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}
}
