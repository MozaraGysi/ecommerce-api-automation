package SuperApp;

public class URLSetter {
    public String SetterURL()
    {
        String url;
        String env = "HML";
        String Brand = "Arezzo";
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
        else if(env == "HML" && Brand == "Arezzo")
        {
            url = "www.preprod.arezzo.com.br";
        }
        else
            url = "preprod.arezzo.com.br";
        return url;
    }
}
