package V3;

import io.restassured.RestAssured;

public class URLSetter {

    public static String SetterURL()
    {
        String url;
        String Brand = "arezzo";
        String env = "HML";
        if(env.equals("PRD") && Brand.equals("arezzo"))
        {
            url = "www.arezzo.com.br/arezzocows";
        }
        else if(env.equals("PRD") && Brand.equals("schutz"))
        {
            url = "www.schutz.com.br/arezzocows";
        }
        else if(env.equals("PRD") && Brand.equals("ancapri"))
        {
            url = "www.anacapri.com.br/arezzocows";
        }
        else if(env.equals("PRD") && Brand.equals("alme"))
        {
            url = "www.somosalme.com.br/arezzocows";
        }
        else if(env.equals("PRD") && Brand.equals("fiever"))
        {
            url = "www.fiever.com.br/arezzocows";
        }
        else if(env.equals("PRD") && Brand.equals("vans"))
        {
            url = "www.vans.com.br/arezzocows";
        }
        else if(env.equals("HML") && Brand.equals("arezzo"))
        {
            url = "https://preprod.arezzo.com.br/arezzocows/";
        }
        else
            url = "preprod.arezzo.com.br/arezzocows";
        return url;
    }
}
