package Wallet.DTOs.Response;

import Wallet.DTOs.AbstractWalletDTO;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class PointsResponseDTO extends AbstractWalletDTO<PointsResponseDTO> {

	private String document;
	private BalanceAmountResponseDTO balance;
	private ArrayList<StatementResponseDTO> statements = new ArrayList<>();

	@Override
	public PointsResponseDTO fromJsonString(String jsonString) {
		return super.fromJsonString(jsonString);
	}

	@Override
	public JsonObject toJson() {
		return super.toJson();
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public BalanceAmountResponseDTO getBalance() {
		return balance;
	}

	public void setBalance(BalanceAmountResponseDTO balance) {
		this.balance = balance;
	}

	public ArrayList<StatementResponseDTO> getStatements() {
		return statements;
	}

	public void setStatements(ArrayList<StatementResponseDTO> statements) {
		this.statements = statements;
	}
}
