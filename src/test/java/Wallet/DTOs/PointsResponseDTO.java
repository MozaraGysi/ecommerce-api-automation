package Wallet.DTOs;

import Common.AbstractDTO;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class PointsResponseDTO extends AbstractDTO<PointsResponseDTO> {

	private String document;
	private BalanceAmountDTO balance;
	private ArrayList<StatementDTO> statements = new ArrayList<>();

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

	public BalanceAmountDTO getBalance() {
		return balance;
	}

	public void setBalance(BalanceAmountDTO balance) {
		this.balance = balance;
	}

	public ArrayList<StatementDTO> getStatements() {
		return statements;
	}

	public void setStatements(ArrayList<StatementDTO> statements) {
		this.statements = statements;
	}
}
