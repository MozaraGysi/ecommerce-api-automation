package Wallet.DTOs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;

public abstract class AbstractWalletDTO<T> {
	public T fromJsonString(String jsonString) {
		return new Gson().fromJson(jsonString, (Type) getClass());
	}

	public JsonObject toJson() {
		return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
	}

}
