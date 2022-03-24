package Common;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDTO<T> {

    private static String CONTENT_TYPE = "application/json";

    public T fromJsonString(String jsonString) {
        return new Gson().fromJson(jsonString, (Type) getClass());
    }

    public JsonObject toJson() {
        return new Gson().fromJson(new Gson().toJson(this), JsonObject.class);
    }

    public Map<String, Object> toMap() {
        return new Gson().fromJson(this.toJson().toString(), HashMap.class);
    }

    public String getContentType() { return CONTENT_TYPE; }
}
