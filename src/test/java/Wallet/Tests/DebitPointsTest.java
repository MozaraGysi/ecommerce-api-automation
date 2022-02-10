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
		CustomerService.newUser();
		CreditPointsService.creditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsService.debitPointsWithTypeQUANTIDADE_DE_PONTOS();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void debitPointsWithTypeVALOR_MONETARIO() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsService.debitPointsWithTypeVALOR_MONETARIO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void debitPointsWithoutOrder() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsService.debitPointsWithoutOrder();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void debitPointsWithoutAuthentication() {
		DebitPointsService.debitPointsWithoutAuthentication();
	}

	@Test
	public void debitPointsWithoutAvailableAmount() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsService.debitPointsWithoutAvailableAmount();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void deleteDebitPoints() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		DebitPointsService.debitPoints();
		DebitPointsService.deletedDebitPoints();
	}
}
