package OCC;

public class URLSetter {
    public static String SetterURL()
    {
        String url;
        String env = "HML";
        String Brand = "MKTP";
        if(env == "PRD" && Brand == "Arezzo")
        {
            url = "www.arezzo.com.br";
        }
        else if(env == "PRD" && Brand == "Schutz")
        {
            url = "www.schutz.com.br";
        }
        else if(env == "PRD" && Brand == "Ancapri")
        {
            url = "www.anacapri.com.br";
        }
        else if(env == "PRD" && Brand == "Alme")
        {
            url = "www.somosalme.com.br";
        }
        else if(env == "PRD" && Brand == "Fiever")
        {
            url = "www.fiever.com.br";
        }
        else if(env == "PRD" && Brand == "Vans")
        {
            url = "www.vans.com.br";
        }
        else if(env == "HML" && Brand == "MKTP")
        {
            url = "https://preprod.zzmall.com.br/arezzocoocc";
        }
        else
            url = "https://preprod.zzmall.com.br/arezzocoocc";
        return url;
    }
}
