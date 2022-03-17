package OCC.Utils;

import Common.Utils.GenerateCPF;
import OCC.Handlers.AuthorizationHandler;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Utils {

    static String CSRFTOKEN;
    static String JSESSIONID;
    static String ACCESS_TOKEN;
    static String ID_ADDRESS;
    static String EMAIL;
    static String BASE_URL_JSON_PATH = "src/test/resources/baseUrl.json";
    static String PRODUCT_JSON_PATH= "src/test/resources/product.json";
    static String USER_JSON_PATH= "src/test/resources/users.json";
    static Map<String, Object> BASE_URL_JSON_MAPPED;
    static Map<String, Object> PRODUCT_JSON_MAPPED;
    static Map<String, Object> USER_JSON_MAPPED;

    public static void init() {
        ACCESS_TOKEN = null;
        EMAIL = null;
        JSESSIONID = null;
        CSRFTOKEN = null;
        ID_ADDRESS = null;
        BASE_URL_JSON_MAPPED = null;
        PRODUCT_JSON_MAPPED = null;
        USER_JSON_MAPPED = null;
        AuthorizationHandler.clear();
    }

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

    public static String getBaseUrl(boolean auth) {
        String baseUrl = ((Map<String, String>) ((Map<String, Object>) getBaseUrlJsonMapped().get(getBrand())).get(getEnv())).get("url");
        return auth ? baseUrl : baseUrl + "arezzocoocc/v2/" + getSite_UID() + "/";
    }

    public static List<String> getProduct(String param) {
        return ((Map<String, List<String>>) ((Map<String, Object>) ((Map<String, Object>) getProductJsonMapped().get(param)).get(getBrand())).get(getEnv())).get("sku");
    }

    public static String getUser(String param) {
        return ((Map<String, String>) getUserJsonMapped().get(param)).get("email");
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

    public static String cpf(){
        GenerateCPF newCPF = new GenerateCPF();
        String cpf = newCPF.cpfFinal(true);
        System.out.print(cpf);
        return cpf;
    }

    private static Map<String, Object> getBaseUrlJsonMapped() {
        if (Objects.isNull(BASE_URL_JSON_MAPPED)) {
            BASE_URL_JSON_MAPPED = readJson(BASE_URL_JSON_PATH);
        }
        return BASE_URL_JSON_MAPPED;
    }

    private static Map<String, Object> getProductJsonMapped() {
        if (Objects.isNull(PRODUCT_JSON_MAPPED)) {
            PRODUCT_JSON_MAPPED = readJson(PRODUCT_JSON_PATH);
        }
        return PRODUCT_JSON_MAPPED;
    }

    private static Map<String, Object> getUserJsonMapped() {
        if (Objects.isNull(USER_JSON_MAPPED)) {
            USER_JSON_MAPPED = readJson(USER_JSON_PATH);
        }
        return USER_JSON_MAPPED;
    }

    private static Map<String, Object> readJson(String jsonFilePath) {
        StringBuilder fileName = new StringBuilder();
        fileName.append(jsonFilePath);
        Map<String, Object> element = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName.toString()))) {
            Gson gson = new Gson();
            element = gson.fromJson(bufferedReader, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return element;
    }

}
