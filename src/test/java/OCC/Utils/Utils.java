package OCC.Utils;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Utils {

    public static String getBrand() {
        String brand = "";
        if (System.getProperty("brand") == null){
            System.out.println("Empresa não adicionada: Ex.: -Dbrand=Arezzo ");
        }else{
            brand = System.getProperty("brand");
        }
        return brand;
    }

    public static String getEnv() {
        String env = "";
        if (System.getProperty("env") == null){
            System.out.println("Env não adicionado: Ex.: -Denv=hml ");
        }else{
            env = System.getProperty("env");
        }
        return env;
    }

    public static String getBaseUrl() {
        StringBuilder fileName = new StringBuilder();
        fileName.append("src/test/resources/baseUrl.json");
        String jsonBaseUrl = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName.toString()))) {
            Gson gson = new Gson();
            Map<String, Object> element = gson.fromJson(bufferedReader, Map.class);
            jsonBaseUrl = ((Map<String, String>)((Map<String, Object>)element.get(getBrand())).get(getEnv())).get("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonBaseUrl;
    }

    public static String getSite_UID() {
        String brand = getBrand().toUpperCase();
        switch (brand) {
            case "AREZZO":
                return "arezzo";
            case "ALEXANDREBIRMAN":
                return "alexandrebirman";
            case "ANACAPRI":
                return "anacapri";
            case "ALME":
                return "alme";
            case "FIEVER":
                return "fiever";
            case "SCHUTZ":
                return "schutz";
            case "VANS":
                return "vans";
            case "ZZMALL":
                return "marketplacezz";
            default:
                return null;
        }
    }

}
