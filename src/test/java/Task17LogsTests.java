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
import LiteCart.Category1Block;
import LiteCart.EditProductBlock;

/**
 * Created by Andrei_Tsyulia on 5/17/2017.
 */
public class Task17LogsTests
{
    protected WebDriver driver;
    protected AdminPanelLogin adminPanelLogin;
    protected AdminPanel adminPanel;
    protected Category1Block category1Block;
    protected EditProductBlock editProductBlock;

    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        ((RemoteWebDriver) driver).setLogLevel(Level.FINEST);
        driver.manage().window().maximize();
        adminPanelLogin = new AdminPanelLogin(driver);
        adminPanel = new AdminPanel(driver);
        category1Block = new Category1Block(driver);
        editProductBlock = new EditProductBlock(driver);
    }

    @Test
    public void checkLogs()
    {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://localhost/litecart/admin/");
        adminPanelLogin.doLogin("admin", "admin");
        adminPanel.isAdminPanel();

        driver.get(" http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        category1Block.isCategory1Block();
        category1Block.openAllFolders();
        for (int i = 0; i < category1Block.countLinks(); i++)
        {
            category1Block.goToEditProduct(i);
            editProductBlock.isEditProductBlock();
            softAssert.assertFalse(editProductBlock.checkLog());
            driver.navigate().back();
            category1Block.isCategory1Block();
        }
        softAssert.assertAll();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass()
    {
        driver.quit();
    }
}
