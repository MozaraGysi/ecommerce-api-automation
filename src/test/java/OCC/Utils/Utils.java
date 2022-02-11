package OCC.Utils;

import Common.Utils.GenerateCPF;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    static String CSRFTOKEN;
    static String JSESSIONID;
    static String ACCESS_TOKEN;
    static String ID_ADDRESS;
    static String EMAIL;



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
                return "birman";
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

    public static List<String> getProduct(String param) {

        StringBuilder fileName = new StringBuilder();
        fileName.append("src/test/resources/product.json");
        List<String> sku = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName.toString()))) {
            Gson gson = new Gson();
            Map<String, Object> element = gson.fromJson(bufferedReader, Map.class);
            sku.addAll(((Map<String, List<String>>)((Map<String, Object>)((Map<String, Object>)element.get(param)).get(getBrand())).get(getEnv())).get("sku"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sku;
    }

    public static String getUrlNavigation(String param) {
        StringBuilder fileName = new StringBuilder();
        fileName.append("src/test/resources/urlNavigation.json");
        String jsonUrlNavigation = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName.toString()))) {
            Gson gson = new Gson();
            Map<String, Object> element = gson.fromJson(bufferedReader, Map.class);
            jsonUrlNavigation = ((Map<String, String>)((Map<String, Object>)((Map<String, Object>)element.get(param)).get(getBrand())).get(getEnv())).get("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonUrlNavigation;
    }

    public static String getUser(String param) {
        StringBuilder fileName = new StringBuilder();
        fileName.append("src/test/resources/users.json");
        String jsonUsers = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName.toString()))) {
            Gson gson = new Gson();
            Map<String, Object> element = gson.fromJson(bufferedReader, Map.class);
            jsonUsers = ((Map<String, String>)element.get(param)).get("email");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonUsers;
    }

    public static String getUserAuthBrand(){
        if(getEnv().equals("hml")){
            return "descomplica";
        }else{
            return "integ";
        }
    }

    public static String getPassAuthBrand(){
        if(getEnv().equals("hml")){
            return "descomplica";
        }else{
            return "ulPap1ed";
        }
    }

    public static String email(){
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyHHmmssSSS"));
        String email = "rrsetcwi+"+data+"@gmail.com";
        setEMAIL(email);
        System.out.println(email);
        return email;
    }

    public static String setEMAIL(String email){
        EMAIL = email;
        return EMAIL;
    }

    public static String getEMAIL(){
        return EMAIL;
    }

    public static String setACCESS_TOKEN(String access_token){
        ACCESS_TOKEN = access_token;
        return ACCESS_TOKEN;
    }

    public static String getACCESS_TOKEN(){
        return ACCESS_TOKEN;
    }

    public static String setID_ADDRESS(ArrayList id_adrress){
        ID_ADDRESS = id_adrress.get(0).toString().replace("[","").replace("]","");
        return ID_ADDRESS;
    }

    public static String getID_ADDRESS(){
        return ID_ADDRESS;
    }


    public static String setJSESSIONID(String jsessionID){
        JSESSIONID = jsessionID;
        return JSESSIONID;
    }

    public static String getJSESSIONID(){
        return JSESSIONID;
    }

    public static String setCSRFTOKEN(String csrf){
        CSRFTOKEN = csrf;
        return CSRFTOKEN;
    }

    public static String getCSRFTOKEN(){
        return CSRFTOKEN;
    }

    static Map<String,String> cookies = new HashMap<>();

    public static Map<String,String> getCookies(){
        return cookies;
    }

    public static void setCookies(Map<String,String> cookie){
        cookies = cookie;
    }

    public static String cpf(){
        GenerateCPF newCPF = new GenerateCPF();
        String cpf = newCPF.cpfFinal(true);
        System.out.print(cpf);
        return cpf;
    }

//    static long _timestamp = 0;
//
//    public static long timestamp(){
//        if(_timestamp == 0){
//            _timestamp = System.currentTimeMillis();
//            return _timestamp;
//        }else{
//            _timestamp = _timestamp +1;
//            return _timestamp;
//        }

//    }

}
