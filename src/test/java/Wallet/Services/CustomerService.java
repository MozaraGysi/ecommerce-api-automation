package Wallet.Services;

import Common.Validators.*;
import Wallet.Utils.APIClient;
import Wallet.DTOs.Request.CustomerRequestDTO;
import Wallet.Fixtures.CustomerRequestDTOFixture;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class CustomerService {

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

	public static void newUserWithInvalidCPF() {
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTOFixture().withInvalidDocument().build();

		Response response = APIClient.POST_customers(customerRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeUnprocessableEntityValidator());
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

	public static void newUserWithoutAuthentication() {
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTOFixture().build();

		Response response = APIClient.POST_customers(customerRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeUnauthorizedValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}

	public static void newUserWithInvalidMobile() {
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTOFixture().withInvalidMobile().build();

		Response response = APIClient.POST_customers(customerRequestDTO.toJson());

		List<Validator> validators = Arrays.asList(new StatusCodeUnprocessableEntityValidator());
		Assertions.assertTrue(validators.stream().allMatch(validator -> validator.validate(response)));
	}
}
