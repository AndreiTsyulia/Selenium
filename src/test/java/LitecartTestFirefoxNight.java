import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LiteCart.AdminPanel;
import LiteCart.AdminPanelLogin;

/**
 * Created by Andrei_Tsyulia on 4/22/2017.
 */
public class LitecartTestFirefoxNight extends BaseTest
{

    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        System.setProperty("webdriver.gecko.driver","D:\\VTB\\Drivers\\Firefox\\geckodriver.exe");
        DesiredCapabilities cap = new DesiredCapabilities();
        FirefoxOptions options = new FirefoxOptions();
        options.setLegacy(true);
        options.setBinary("C:\\Program Files (x86)\\Nightly\\firefox.exe");
        cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        cap.setCapability(FirefoxDriver.MARIONETTE, true);
        driver = new FirefoxDriver(cap);


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
