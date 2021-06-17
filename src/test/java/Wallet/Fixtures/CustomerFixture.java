package Wallet.Fixtures;

import Wallet.Utils.Utils;
import com.google.gson.JsonObject;

public class CustomerFixture {

	public static JsonObject build() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("document", Utils.getCPF());
		jsonObject.addProperty("firstName", "Douglas");
		jsonObject.addProperty("lastName", "Golke");
		jsonObject.addProperty("birthday", "2000-01-22");
		jsonObject.addProperty("email", Utils.getEMAIL());
		jsonObject.addProperty("mobile", "5552998288513");
		return jsonObject;
	}
}
