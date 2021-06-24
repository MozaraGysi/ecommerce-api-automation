package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class PointsResponseDTO {

	private String document;
	private BalanceAmountDTO balance;
	private ArrayList<StatementDTO> statements = new ArrayList<>();

	public static PointsResponseDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, PointsResponseDTO.class);
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
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
