import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import LiteCart.MainPage;
import LiteCart.ProductBlock;

/**
 * Created by Andrei_Tsyulia on 4/28/2017.
 */
public class Task10AttributeChromeTests
{
    protected WebDriver driver;
    protected MainPage mainPage;
    protected ProductBlock productBlock;

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
        productBlock = new ProductBlock(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod()
    {
        driver.get("http://localhost/litecart");
        mainPage.isMainPage();
    }

    @Test
    public void checkTextTest()
    {
        String textOnMainPage = mainPage.getProductText();
        mainPage.goToProductBlock();
        productBlock.isProductBlock();
        Assert.assertEquals(productBlock.getProductText(), textOnMainPage);
    }

    @Test
    public void checkRegularPrice()
    {
        String regularPriceOnMainPage = mainPage.getRegularPrice();
        mainPage.goToProductBlock();
        productBlock.isProductBlock();
        Assert.assertEquals(productBlock.getRegularPrice(), regularPriceOnMainPage);
    }

    @Test
    public void checkCampaignPrice()
    {
        String campaignPriceOnMainPage = mainPage.getCampaignPrice();
        mainPage.goToProductBlock();
        productBlock.isProductBlock();
        Assert.assertEquals(productBlock.getCampaignPrice(), campaignPriceOnMainPage);
    }

    @Test
    public void checkTextDecorationOnMainPage()
    {
        Assert.assertTrue(mainPage.checkTextLine());
    }

    @Test
    public void checkTextDecorationOnProductBlock()
    {
        mainPage.goToProductBlock();
        Assert.assertTrue(productBlock.checkTextLine());
    }

    @Test
    public void checkRegularPriceColorOnMainPage()
    {
        Assert.assertTrue(mainPage.checkRegularPriceColor());
    }

    @Test
    public void checkRegularPriceColorOnProductBlock()
    {
        mainPage.goToProductBlock();
        Assert.assertTrue(productBlock.checkRegularPriceColor());
    }

    @Test
    public void checkCampaignPriceColorOnMainPage()
    {
        Assert.assertTrue(mainPage.checkCampaignPriceColor());
    }

    @Test
    public void checkCampaignPriceColorOnProductBlock()
    {
        mainPage.goToProductBlock();
        Assert.assertTrue(productBlock.checkCampaignPriceColor());
    }

    @Test
    public void checkBoldCampaignPriceOnMainPage()
    {
        Assert.assertTrue(mainPage.checkBoldCampaignPrice());
    }

    @Test
    public void checkBoldCampaignPriceOnProductBlock()
    {
        mainPage.goToProductBlock();
        Assert.assertTrue(productBlock.checkBoldCampaignPrice());
    }

    @Test
    public void compareCampaignAndRegularPricesOnMainPage()
    {
        Assert.assertTrue(mainPage.compareCampaignAndRegularPrices());
    }

    @Test
    public void compareCampaignAndRegularPricesOnProductBlock()
    {
        mainPage.goToProductBlock();
        Assert.assertTrue(productBlock.compareCampaignAndRegularPrices());
    }


    @AfterClass(alwaysRun = true)
    public void afterClass()
    {
        driver.quit();
    }
}