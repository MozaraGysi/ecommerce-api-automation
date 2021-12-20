package Wallet.Scenarios;

import Wallet.Services.*;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpirePoints {

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
		CustomerService.newUser();
		CreditPointsService.creditPointsWithTypeQUANTIDADE_DE_PONTOSAndStatusCONFIRMADO();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		ExpirePointsService.getExpirePointsWithCustomersWithExpirePoints();
	}

	@Test
	public void getExpirePointsWithCustomersWithPartialExpirePoints() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPointsWithTypeQUANTIDADE_DE_PONTOSAndStatusCONFIRMADO();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsService.debitPointsWithTypeQUANTIDADE_DE_PONTOS();
		ExpirePointsService.getExpirePointsWithCustomersWithExpirePoints();
	}

	@Test
	public void getExpirePointsWithCustomersWithTwoTransactionsExpireAtSameDay() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPointsWithTypeQUANTIDADE_DE_PONTOSAndStatusCONFIRMADO();
		CreditPointsService.creditPointsWithTypeQUANTIDADE_DE_PONTOSAndStatusCONFIRMADO();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		ExpirePointsService.getExpirePointsWithCustomersWithExpirePoints();
	}
}
