import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by Andrei_Tsyulia on 4/20/2017.
 */
public class LitecartTest extends BaseTest
{


    @AfterClass(alwaysRun = true)
    public void afterClass()
    {
        driver.close();
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

