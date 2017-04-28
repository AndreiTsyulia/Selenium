import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import LiteCart.AdminPanel;
import LiteCart.AdminPanelLogin;

/**
 * Created by Andrei_Tsyulia on 4/20/2017.
 */
public class Task4ChromeTests
{

    protected WebDriver driver;
    protected AdminPanelLogin adminPanelLogin;
    protected AdminPanel adminPanel;

    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver","D:\\VTB\\Drivers\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        ((RemoteWebDriver) driver).setLogLevel(Level.FINEST);
        driver.manage().window().maximize();
        adminPanelLogin = new AdminPanelLogin(driver);
        adminPanel = new AdminPanel(driver);
    }

    @Test
    public void litecartTest1()
    {
        driver.get("http://localhost/litecart/admin/");
        adminPanelLogin.doLogin("admin", "admin");
        Assert.assertTrue(adminPanel.isAdminPanel());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass()
    {
        driver.quit();
    }
}

