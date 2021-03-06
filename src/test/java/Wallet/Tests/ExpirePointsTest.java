package Wallet.Tests;

import Wallet.Services.*;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

@DisabledIfSystemProperty(named = "excludeWallet", matches = "true")
public class ExpirePointsTest {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void getExpirePointsWithoutCustomersWithExpirePoints() {
		AuthService.getToken();
		ExpirePointsService.getExpirePointsWithoutCustomersWithExpirePoints();
	}

	@Test
	public void getExpirePointsWithCustomersWithExpirePoints() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPointsWithTypeQUANTIDADE_DE_PONTOSAndStatusCONFIRMADO();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		ExpirePointsService.getExpirePointsWithCustomersWithExpirePoints();
	}

	@Test
	public void getExpirePointsWithCustomersWithPartialExpirePoints() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPointsWithTypeQUANTIDADE_DE_PONTOSAndStatusCONFIRMADO();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsService.postDebitPointsWithTypeQUANTIDADE_DE_PONTOS();
		ExpirePointsService.getExpirePointsWithCustomersWithExpirePoints();
	}

	@Test
	public void getExpirePointsWithCustomersWithTwoTransactionsExpireAtSameDay() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPointsWithTypeQUANTIDADE_DE_PONTOSAndStatusCONFIRMADO();
		CreditPointsService.postCreditPointsWithTypeQUANTIDADE_DE_PONTOSAndStatusCONFIRMADO();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		ExpirePointsService.getExpirePointsWithCustomersWithExpirePoints();
	}
}
