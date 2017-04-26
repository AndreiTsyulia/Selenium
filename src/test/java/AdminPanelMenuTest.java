import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import LiteCart.AdminPanel;
import LiteCart.AdminPanelLogin;

/**
 * Created by Andrei_Tsyulia on 4/25/2017.
 */
public class AdminPanelMenuTest extends BaseTest
{
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

    }

    @Test
    public void checkH1()
    {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://localhost/litecart/admin/");
        adminPanelLogin.doLogin("admin", "admin");
        adminPanel.isAdminPanel();
        int numberOfMenuItems = adminPanel.getMenuItems();

        for (int i = 1; i <= numberOfMenuItems; i++)
        {
            adminPanel.clickItemMenu(i);
            softAssert.assertTrue(adminPanel.checkBlockTitle());

            int numberOfSubMenuItems = adminPanel.getSubMenuItems();
            System.out.println(numberOfSubMenuItems);
            for (int j = 1; j <= numberOfSubMenuItems; j++)
            {
                adminPanel.clickSubItemMenu(j);
                softAssert.assertTrue(adminPanel.checkBlockTitle());
            }
        }
        softAssert.assertAll();
    }
}
