import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import LiteCart.AdminPanel;
import LiteCart.AdminPanelLogin;
import LiteCart.MainPage;
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
    protected MainPage mainPage;




    @AfterClass(alwaysRun = true)
    public void afterClass()
    {
        driver.quit();
    }

}
