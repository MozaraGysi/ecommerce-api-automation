package Wallet.Validators;

import Common.Validators.Validator;
import Wallet.DTOs.Response.CustomerExpirePointsResponseDTO;
import Wallet.DTOs.Response.ExpirePointsResponseDTO;
import Wallet.Utils.Utils;
import io.restassured.response.Response;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.stream.Collectors;

public class ExpirePointsWithCustomersWithExpirePointsValidator implements Validator {

	@Override
	public boolean validate(Response response) {
		ExpirePointsResponseDTO expirePointsResponseDTO = new ExpirePointsResponseDTO().fromJsonString(response.getBody().asString());

		Assertions.assertTrue(CollectionUtils.isNotEmpty(expirePointsResponseDTO.getCustomers()));

		List<CustomerExpirePointsResponseDTO> customerExpirePoints = expirePointsResponseDTO.getCustomers()
				.stream()
				.filter(customer -> customer.getDocument().equals(Utils.getCPF()))
				.collect(Collectors.toList());

		Assertions.assertEquals(1, customerExpirePoints.size());
		Assertions.assertEquals(Double.valueOf(String.valueOf(Utils.getAvailableAmount())), customerExpirePoints.get(0).getAmount());

		return true;
	}
}