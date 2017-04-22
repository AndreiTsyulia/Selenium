import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LiteCart.AdminPanel;
import LiteCart.AdminPanelLogin;

/**
 * Created by Andrei_Tsyulia on 4/21/2017.
 */
public class LitecartTestFirefox extends BaseTest
{

    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        System.setProperty("webdriver.gecko.driver","D:\\VTB\\Drivers\\Firefox\\geckodriver.exe");
        driver = new FirefoxDriver();
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
