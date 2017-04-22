import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LiteCart.AdminPanel;
import LiteCart.AdminPanelLogin;

/**
 * Created by Andrei_Tsyulia on 4/21/2017.
 */
public class LitecartTestIE extends BaseTest
{

    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        System.setProperty("webdriver.ie.driver", "D:\\VTB\\Drivers\\IE\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        adminPanelLogin = new AdminPanelLogin(driver);
        adminPanel = new AdminPanel(driver);
    }

    @Test
    public void litecartTest1()
    {
        driver.get("http://localhost/litecart/admin/");
        adminPanelLogin.typeUsername("admin");
        adminPanelLogin.typePassword("admin");
        adminPanelLogin.pressButton();
        Assert.assertTrue(adminPanel.isAdminPanel());
    }
}
