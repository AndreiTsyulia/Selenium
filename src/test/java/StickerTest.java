import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import LiteCart.MainPage;

/**
 * Created by Andrei_Tsyulia on 4/25/2017.
 */
public class StickerTest extends BaseTest
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
        mainPage = new MainPage(driver);
    }

    @Test
    public void checkStickers()
    {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://localhost/litecart/");

        mainPage.clickCampaignProducts();
        int numberOfProductsInCampaign = mainPage.getProductsInCampaign();

        for (int i = 1; i <= numberOfProductsInCampaign; i++)
        {
            softAssert.assertTrue(mainPage.checkStikerInCampaign(i));
        }

        mainPage.clickPopularProducts();
        int numberOfProductsInPopular = mainPage.getProductsInPopular();

        for (int i = 1; i <= numberOfProductsInPopular; i++)
        {
            softAssert.assertTrue(mainPage.checkStikerInPopular(i));
        }

        mainPage.clickLatestProducts();
        int numberOfProductsInLatest = mainPage.getProductsInLatest();

        for (int i = 1; i <= numberOfProductsInLatest; i++)
        {
            softAssert.assertTrue(mainPage.checkStikerInLatest(i));
        }
        softAssert.assertAll();
    }
}
