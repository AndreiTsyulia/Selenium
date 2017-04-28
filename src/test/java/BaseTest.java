import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import LiteCart.AdminPanel;
import LiteCart.AdminPanelLogin;
import LiteCart.CountriesBlock;
import LiteCart.EditCountriesBlock;
import LiteCart.EditGeoZonesBlock;
import LiteCart.GeoZonesBlock;
import LiteCart.MainPage;


/**
 * Created by Andrei_Tsyulia on 4/20/2017.
 */
public class BaseTest
{
    protected WebDriver driver;
    protected AdminPanelLogin adminPanelLogin;
    protected AdminPanel adminPanel;
    protected MainPage mainPage;
    protected CountriesBlock countriesBlock;
    protected EditCountriesBlock editCountriesBlock;
    protected GeoZonesBlock geoZonesBlock;
    protected EditGeoZonesBlock editGeoZonesBlock;


    @BeforeClass(alwaysRun = true)
    public void beforeBaseClass()
    {

        System.setProperty("webdriver.chrome.driver", "D:\\VTB\\Drivers\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        ((RemoteWebDriver) driver).setLogLevel(Level.FINEST);
        driver.manage().window().maximize();
        adminPanelLogin = new AdminPanelLogin(driver);
        adminPanel = new AdminPanel(driver);
        mainPage = new MainPage(driver);
        countriesBlock = new CountriesBlock(driver);
        editCountriesBlock = new EditCountriesBlock(driver);
        geoZonesBlock = new GeoZonesBlock(driver);
        editGeoZonesBlock = new EditGeoZonesBlock(driver);
    }


    @AfterClass(alwaysRun = true)
    public void afterBaseClass()
    {
        driver.quit();
    }

}
