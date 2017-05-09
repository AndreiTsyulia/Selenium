import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import LiteCart.AdminPanel;
import LiteCart.AdminPanelLogin;
import LiteCart.CountriesBlock;
import LiteCart.EditCountriesBlock;

/**
 * Created by Andrei_Tsyulia on 5/9/2017.
 */
public class Task14WindowsTests
{
    protected WebDriver driver;
    protected AdminPanelLogin adminPanelLogin;
    protected AdminPanel adminPanel;
    protected EditCountriesBlock editCountriesBlock;
    protected CountriesBlock countriesBlock;

    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\VTB\\Drivers\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        ((RemoteWebDriver) driver).setLogLevel(Level.FINEST);
        driver.manage().window().maximize();
        adminPanelLogin = new AdminPanelLogin(driver);
        adminPanel = new AdminPanel(driver);
        editCountriesBlock = new EditCountriesBlock(driver);
        countriesBlock = new CountriesBlock(driver);
    }

    @Test
    public void checkWindows()
    {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://localhost/litecart/admin/");
        adminPanelLogin.doLogin("admin", "admin");
        adminPanel.isAdminPanel();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        countriesBlock.isCountriesBlock();
        countriesBlock.goToSomeCountry();
        editCountriesBlock.isEditCountriesBlock();
        for (int i = 0; i < editCountriesBlock.countLinks(); i++)
        {
            softAssert.assertTrue(editCountriesBlock.checkWindow(i));
        }
        softAssert.assertAll();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass()
    {
        driver.quit();
    }
}
