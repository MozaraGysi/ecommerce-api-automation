package OtherServices.Tests;

import OtherServices.Utils.*;
import OtherServices.Pages.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class PrateleiraInfinita {

    @Test
    @Tag("ZZNet")
    public void PrateleiraInfinitaNewCustomer()
    {
        String clientToken = TokenUtils.ClientToken();
        ZZNetAPI.CreateCustomer(clientToken);
        ZZNetAPI.LoginTeleSalesAndSwitchToCustomer();
        String CSFRToken = ZZNetAPI.CSFRToken();
        ZZNetAPI.RegisterCart(CSFRToken);
    }
    @Test
    @Tag("ZZNet")
    public void PrateleiraInfinitaNewEmployee()
    {
        String clientToken = TokenUtils.ClientToken();
        ZZNetAPI.CreateEmployee(clientToken);
        ZZNetAPI.LoginTeleSalesAndSwitchToCustomer();
        String CSFRToken = ZZNetAPI.CSFRToken();
        ZZNetAPI.RegisterCart(CSFRToken);
    }
}