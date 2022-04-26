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

	public static void postNewUser() {
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTOFixture().build();

		Response response = APIClient.postCustomers(customerRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeCreatedValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	public static void postNewUserWithoutCPF() {
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTOFixture().withoutDocument().build();

		Response response = APIClient.postCustomers(customerRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeBadRequestValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	public static void postNewUserWithInvalidCPF() {
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTOFixture().withInvalidDocument().build();

		Response response = APIClient.postCustomers(customerRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeUnprocessableEntityValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	public static void postNewUserWithoutFirstName() {
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTOFixture().withoutFirstName().build();

		Response response = APIClient.postCustomers(customerRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeUnprocessableEntityValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	public static void postNewUserWithoutLastName() {
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTOFixture().withoutLastName().build();

		Response response = APIClient.postCustomers(customerRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeUnprocessableEntityValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	public static void postNewUserWithoutAuthentication() {
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTOFixture().build();

		Response response = APIClient.postCustomers(customerRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeUnauthorizedValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}

	public static void postNewUserWithInvalidMobile() {
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTOFixture().withInvalidMobile().build();

		Response response = APIClient.postCustomers(customerRequestDTO);

		List<Validator> validators = Arrays.asList(new StatusCodeUnprocessableEntityValidator());
		validators.stream().forEach(validator -> validator.validate(response));
	}
}
