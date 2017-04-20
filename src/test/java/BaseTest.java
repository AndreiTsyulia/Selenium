import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import LiteCart.AdminPanel;
import LiteCart.AdminPanelLogin;
import Vtb.BlockHeader;


/**
 * Created by Andrei_Tsyulia on 4/20/2017.
 */
public class BaseTest
{
    protected WebDriver driver;
    protected BlockHeader blockHeader;
    protected AdminPanelLogin adminPanelLogin;
    protected AdminPanel adminPanel;

    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver","D:\\VTB\\Drivers\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        blockHeader = new BlockHeader(driver);
        adminPanelLogin = new AdminPanelLogin(driver);
        adminPanel = new AdminPanel(driver);
    }


    @AfterClass(alwaysRun = true)
    public void afterClass()
    {
        driver.close();
    }

}
