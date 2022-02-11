package Wallet.Tests;

import Wallet.Services.*;
import Wallet.Utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

@DisabledIfSystemProperty(named = "excludeWallet", matches = "true")
public class CreditPointsTest {

	@BeforeEach
	public void init() {
		Utils.init();
	}

	@Test
	public void creditPointsWithTypeVALOR_MONETARIO() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPointsWithTypeVALOR_MONETARIOAndStatusPENDENTE();
		CreditTransactionsService.getPendingCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePointsWithPendingCredits();
		PointsService.getPointsPending();
		CreditPointsService.postCreditPointsWithTypeVALOR_MONETARIOAndStatusCONFIRMADOByOrderPendingIndex(0);
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void creditPointsWithTypeQUANTIDADE_DE_PONTOS() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPointsWithTypeQUANTIDADE_DE_PONTOSAndStatusCONFIRMADO();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void creditPointsWithStatusPENDENTE() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPointsWithTypeVALOR_MONETARIOAndStatusPENDENTE();
		CreditTransactionsService.getPendingCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePointsWithPendingCredits();
		PointsService.getPointsPending();
	}

	@Test
	public void creditPointsWithoutOrder() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPointsWithoutOrder();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void creditPointsWithoutAuthentication() {
		CreditPointsService.postCreditPointsWithoutAuthentication();
	}

	@Test
	public void doubleCreditPoints() {
		AuthService.getToken();
		CustomerService.postNewUser();
		BalancePointsService.getBalancePointsWithoutTransactions();
		PointsService.getPointsWithoutTransactions();
		CreditPointsService.postCreditPoints();
		BalancePointsService.getBalancePointsWithoutTransactions();
		PointsService.getPointsWithoutTransactions();
		CreditTransactionsService.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsService.getBalancePointsWithoutTransactions();
		PointsService.getPointsWithoutTransactions();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
		CreditPointsService.postCreditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusPENDENTE();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
		CreditPointsService.postCreditPoints();
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
		CustomerService.postNewUser();
		BalancePointsService.getBalancePointsWithoutTransactions();
		PointsService.getPointsWithoutTransactions();
		CreditPointsService.postCreditPointsWithTypeVALOR_MONETARIOAndStatusPENDENTE();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		CreditPointsService.postCreditPointsWithTypeVALOR_MONETARIOAndStatusCONFIRMADOByOrderPendingIndex(0);
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		CreditPointsService.postCreditPointsWithTypeVALOR_MONETARIOAndStatusPENDENTE();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		CreditPointsService.postCreditPointsWithTypeVALOR_MONETARIOAndStatusCONFIRMADOByOrderPendingIndex(1);
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
	}

	@Test
	public void doubleCreditPointsPending_typeVALOR_MONETARIO() {
		AuthService.getToken();
		CustomerService.postNewUser();
		BalancePointsService.getBalancePointsWithoutTransactions();
		PointsService.getPointsWithoutTransactions();
		CreditPointsService.postCreditPointsWithTypeVALOR_MONETARIOAndStatusPENDENTE();
		CreditTransactionsService.getPendingCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePointsWithPendingCredits();
		PointsService.getPointsPending();
		CreditPointsService.postCreditPointsWithTypeVALOR_MONETARIOAndStatusPENDENTE();
		CreditTransactionsService.getPendingCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePointsWithPendingCredits();
		PointsService.getPointsPending();
		CreditPointsService.postCreditPointsWithTypeVALOR_MONETARIOAndStatusCONFIRMADOByOrderPendingIndex(0);
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
		CreditPointsService.postCreditPointsWithTypeVALOR_MONETARIOAndStatusCONFIRMADOByOrderPendingIndex(1);
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void doubleCreditPointsPending_typeVALOR_MONETARIO_ChangeTheOrderOfConfirmations() {
		AuthService.getToken();
		CustomerService.postNewUser();
		BalancePointsService.getBalancePointsWithoutTransactions();
		PointsService.getPointsWithoutTransactions();
		CreditPointsService.postCreditPointsWithTypeVALOR_MONETARIOAndStatusPENDENTE();
		CreditTransactionsService.getPendingCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePointsWithPendingCredits();
		PointsService.getPointsPending();
		CreditPointsService.postCreditPointsWithTypeVALOR_MONETARIOAndStatusPENDENTE();
		CreditTransactionsService.getPendingCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePointsWithPendingCredits();
		PointsService.getPointsPending();
		CreditPointsService.postCreditPointsWithTypeVALOR_MONETARIOAndStatusCONFIRMADOByOrderPendingIndex(1);
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
		CreditPointsService.postCreditPointsWithTypeVALOR_MONETARIOAndStatusCONFIRMADOByOrderPendingIndex(0);
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		BalancePointsService.getBalancePoints();
		PointsService.getPoints();
	}

	@Test
	public void deleteCreditPoints() {
		AuthService.getToken();
		CustomerService.postNewUser();
		CreditPointsService.postCreditPoints();
		CreditTransactionsService.getCreditTransactionsWithStatusCONFIRMADO();
		CreditPointsService.deleteCreditPoints();
	}
}
