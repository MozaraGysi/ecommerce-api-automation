package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CustomerRequestDTO {

	private String document;
	private String firstName;
	private String lastName;
	private String email;
	private String birthday;
	private Long mobile;

	public static CustomerRequestDTO fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, CustomerRequestDTO.class);
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
}
