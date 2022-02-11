package Wallet.Tests;

import Wallet.Services.*;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

@DisabledIfSystemProperty(named = "excludeWallet", matches = "true")
public class DebitPointsTest {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void debitPointsWithTypeQUANTIDADE_DE_PONTOS() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsService.postDebitPointsWithTypeQUANTIDADE_DE_PONTOS();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void debitPointsWithTypeVALOR_MONETARIO() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsService.postDebitPointsWithTypeVALOR_MONETARIO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void debitPointsWithoutOrder() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsService.postDebitPointsWithoutOrder();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void debitPointsWithoutAuthentication() {
		DebitPointsService.postDebitPointsWithoutAuthentication();
	}

	@Test
	public void debitPointsWithoutAvailableAmount() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsService.postDebitPointsWithoutAvailableAmount();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void deleteDebitPoints() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsService.postDebitPoints();
		DebitPointsService.deletedDebitPoints();
	}
}
