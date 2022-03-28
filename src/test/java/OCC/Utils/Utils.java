package OCC.Utils;

import Common.Utils.EnvConfig;
import Common.Utils.GenerateCPF;
import OCC.Enums.BrandEnum;
import OCC.Handlers.AddressHandler;
import OCC.Handlers.AuthorizationHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;

import static OCC.Enums.BrandEnum.ALEXANDREBIRMAN;
import static OCC.Enums.BrandEnum.ALME;
import static OCC.Enums.BrandEnum.ANACAPRI;
import static OCC.Enums.BrandEnum.AREZZO;
import static OCC.Enums.BrandEnum.FIEVER;
import static OCC.Enums.BrandEnum.SCHUTZ;
import static OCC.Enums.BrandEnum.VANS;
import static OCC.Enums.BrandEnum.ZZMALL;

public class Utils {

    static String CSRFTOKEN;
    static String JSESSIONID;
    static String ACCESS_TOKEN;
    static String EMAIL;
    static Map<String, Object> OCC_CONFIG_MAPPED;
    public static String OCC_API_NAME = "OCC";

    public static void init() {
        ACCESS_TOKEN = null;
        EMAIL = null;
        JSESSIONID = null;
        CSRFTOKEN = null;
        OCC_CONFIG_MAPPED = null;
        AuthorizationHandler.clear();
        AddressHandler.clear();
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

    public static String getSiteUid() {
        String brand = getBrand().toUpperCase();
        switch (BrandEnum.valueOf(brand)) {
            case AREZZO:
                return AREZZO.getValue();
            case ALEXANDREBIRMAN:
                return ALEXANDREBIRMAN.getValue();
            case ANACAPRI:
                return ANACAPRI.getValue();
            case ALME:
                return ALME.getValue();
            case FIEVER:
                return FIEVER.getValue();
            case SCHUTZ:
                return SCHUTZ.getValue();
            case VANS:
                return VANS.getValue();
            case ZZMALL:
                return ZZMALL.getValue();
            default:
                return null;
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

    public static String getEmail(){
        return EMAIL;
    }

    public static String setJSessionId(String jsessionID){
        JSESSIONID = jsessionID;
        return JSESSIONID;
    }

    public static String getJSessionId(){
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

    public static String URL_COMPLEMENT(){
        return "arezzocoocc/v2/" + getSiteUid() + "/";
    }

    public static Map<String, Object> getMappedUsers(){
        if (Objects.isNull(OCC_CONFIG_MAPPED)) {
            OCC_CONFIG_MAPPED = EnvConfig.getConfigs(OCC_API_NAME, "users");
        }
        return OCC_CONFIG_MAPPED;
    }

    public static Map<String, Object> getConfigMappedProducts() {
        if (Objects.isNull(OCC_CONFIG_MAPPED)) {
            OCC_CONFIG_MAPPED = EnvConfig.getConfigsProduct(OCC_API_NAME, getEnv());
        }
        return OCC_CONFIG_MAPPED;
    }

    public static Map<String, Object> getConfigMappedBaseUrl() {
        if (Objects.isNull(OCC_CONFIG_MAPPED)) {
            OCC_CONFIG_MAPPED = EnvConfig.getConfigsBaseUrl(OCC_API_NAME, getEnv());
        }
        return OCC_CONFIG_MAPPED;
    }

}
