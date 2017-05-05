import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import LiteCart.CartBlock;
import LiteCart.MainPage;
import LiteCart.ProductBlock;

/**
 * Created by Andrei_Tsyulia on 5/5/2017.
 */
public class Task13WaitingsTests
{
    protected WebDriver driver;
    protected MainPage mainPage;
    protected ProductBlock productBlock;
    protected CartBlock cartBlock;

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
        cartBlock = new CartBlock(driver);
    }


    @Test(priority = 1)
    public void putFirstDuckTest()
    {
        for (int i = 0; i < 3; i++)
        {
            driver.get("http://localhost/litecart");
            mainPage.isMainPage();
            mainPage.goToProductBlock();
            productBlock.isProductBlock();
            productBlock.selectSize();
            int ducksInCart = productBlock.getDucksInCart();
            productBlock.addToCart();
            Assert.assertTrue(productBlock.isIncreasingDucks(ducksInCart));
        }
    }

    @Test(priority = 2)
    public void deleteFirstDuck()
    {
        productBlock.goToCart();
        cartBlock.isCartBlock();
        int ducksInCart = cartBlock.getDucksInCart();
        cartBlock.deleteOneDuck();
        Assert.assertTrue(cartBlock.isDecreasingDucks(ducksInCart));
    }

    @Test(priority = 3)
    public void deleteSecondDuck()
    {
        for (int i = 0; i < 2; i++)
        {
            int ducksInCart = cartBlock.getDucksInCart();
            cartBlock.deleteOneDuck();
            Assert.assertTrue(cartBlock.isDecreasingDucks(ducksInCart));
        }
    }

    @AfterClass(alwaysRun = true)
    public void afterClass()
    {
        driver.quit();
    }
}