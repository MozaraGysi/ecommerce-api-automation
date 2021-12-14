package Wallet.Scenarios;

import Wallet.Services.*;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Crédito de pontos")
public class CreditPoints {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	@DisplayName("Credito de pontos com o tipo VALOR MONETÁRIO")
	public void creditPointsWithTypeVALOR_MONETARIO() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPointsWithTypeVALOR_MONETARIOAndStatusPENDENTE();
		CreditTransactionsService.getPendingCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePointsWithPendingCredits();
		PointsService.getPointsPending();
		CreditPointsService.creditPointsWithTypeVALOR_MONETARIOAndStatusCONFIRMADO();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void creditPointsWithTypeQUANTIDADE_DE_PONTOS() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPointsWithTypeQUANTIDADE_DE_PONTOSAndStatusCONFIRMADO();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void creditPointsWithStatusPENDENTE() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPointsWithTypeVALOR_MONETARIOAndStatusPENDENTE();
		CreditTransactionsService.getPendingCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePointsWithPendingCredits();
		PointsService.getPointsPending();
	}

	@Test
	public void creditPointsWithoutOrder() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPointsWithoutOrder();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void creditPointsWithoutAuthentication() {
		CreditPointsService.creditPointsWithoutAuthentication();
	}

	@Test
	public void doubleCreditPoints() {
		AuthService.getToken();
		CustomerService.newUser();
		BalancePointsService.getBalancePointsWithoutTransactions();
		PointsService.getPointsWithoutTransactions();
		CreditPointsService.creditPoints();
		BalancePointsService.getBalancePointsWithoutTransactions();
		PointsService.getPointsWithoutTransactions();
		CreditTransactionsService.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsService.getBalancePointsWithoutTransactions();
		PointsService.getPointsWithoutTransactions();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
		CreditPointsService.creditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
		CreditPointsService.creditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void doubleCreditPoints_typeVALOR_MONETARIO() {
		AuthService.getToken();
		CustomerService.newUser();
		BalancePointsService.getBalancePointsWithoutTransactions();
		PointsService.getPointsWithoutTransactions();
		CreditPointsService.creditPointsWithTypeVALOR_MONETARIOAndStatusPENDENTE();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		CreditPointsService.creditPointsWithTypeVALOR_MONETARIOAndStatusCONFIRMADO();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		////
		CreditPointsService.creditPointsWithTypeVALOR_MONETARIOAndStatusPENDENTE();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		CreditPointsService.creditPointsWithTypeVALOR_MONETARIOAndStatusCONFIRMADO();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
	}

	@Test
	public void doubleCreditPointsPending_typeVALOR_MONETARIO() {
		AuthService.getToken();
		CustomerService.newUser();
		BalancePointsService.getBalancePointsWithoutTransactions();
		PointsService.getPointsWithoutTransactions();
		CreditPointsService.creditPointsWithTypeVALOR_MONETARIOAndStatusPENDENTE();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		////
		CreditPointsService.creditPointsWithTypeVALOR_MONETARIOAndStatusPENDENTE();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		///
		CreditPointsService.creditPointsWithTypeVALOR_MONETARIOAndStatusCONFIRMADO();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		////
		CreditPointsService.creditPointsWithTypeVALOR_MONETARIOAndStatusCONFIRMADO();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
	}

	@Test
	public void deleteCreditPoints() {
		AuthService.getToken();
		CustomerService.newUser();
		CreditPointsService.creditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		CreditPointsService.deleteCreditPoints();
	}
}
