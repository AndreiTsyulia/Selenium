import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LiteCart.AdminPanel;
import LiteCart.AdminPanelLogin;

/**
 * Created by Andrei_Tsyulia on 4/22/2017.
 */
public class Task5FirefoxESRTests
{
    protected WebDriver driver;
    protected AdminPanelLogin adminPanelLogin;
    protected AdminPanel adminPanel;

    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        DesiredCapabilities cap = new DesiredCapabilities();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla FirefoxESR\\firefox.exe");
        options.setLegacy(true);
        cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        cap.setCapability(FirefoxDriver.MARIONETTE, false);
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

    @AfterClass(alwaysRun = true)
    public void afterClass()
    {
        driver.quit();
    }
}

