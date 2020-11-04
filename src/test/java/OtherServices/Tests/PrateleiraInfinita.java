package OtherServices.Tests;

import OtherServices.Utils.*;
import OtherServices.Pages.*;
import org.junit.Test;

public class PrateleiraInfinita {
    
    @Test
    public void PrateleiraInfinitaNewCustomer()
    {
        String clientToken = TokenUtils.ClientToken();
        ZZNetAPI.CreateCustomer(clientToken);
        ZZNetAPI.LoginTeleSalesAndSwitchToCustomer();
        String CSFRToken = ZZNetAPI.CSFRToken();
        ZZNetAPI.RegisterCart(CSFRToken);
    }
    @Test
    public void PrateleiraInfinitaNewEmployee()
    {
        String clientToken = TokenUtils.ClientToken();
        ZZNetAPI.CreateEmployee(clientToken);
        ZZNetAPI.LoginTeleSalesAndSwitchToCustomer();
        String CSFRToken = ZZNetAPI.CSFRToken();
        ZZNetAPI.RegisterCart(CSFRToken);
    }
}