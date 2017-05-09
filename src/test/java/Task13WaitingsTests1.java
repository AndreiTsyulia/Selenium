import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import LiteCart.CartBlock;
import LiteCart.MainPage;
import LiteCart.ProductBlock;

/**
 * Created by Andrei_Tsyulia on 5/9/2017.
 */
public class Task13WaitingsTests1
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
        driver.get("http://localhost/litecart");
    }


    @Test
    public void putFirstDuckTest()
    {
        SoftAssert softAssert = new SoftAssert();

        mainPage.isMainPage();
        mainPage.goToProductBlock();
        productBlock.isProductBlock();
        productBlock.selectSize();
        int ducksIn = productBlock.getDucksInCart();
        productBlock.addToCart();
        softAssert.assertTrue(productBlock.isIncreasingDucks(ducksIn));

        driver.get("http://localhost/litecart");
        mainPage.clickPopularProducts();
        mainPage.goToProductBlockPopular();
        productBlock.isProductBlock();
        productBlock.selectSize();
        ducksIn = productBlock.getDucksInCart();
        productBlock.addToCart();
        productBlock.isIncreasingDucks(ducksIn);
        softAssert.assertTrue(productBlock.isIncreasingDucks(ducksIn));

        driver.get("http://localhost/litecart");
        mainPage.clickLatestProducts();
        mainPage.goToProductBlockLatest();
        productBlock.isProductBlock();
        productBlock.selectSize();
        ducksIn = productBlock.getDucksInCart();
        productBlock.addToCart();
        productBlock.isIncreasingDucks(ducksIn);
        softAssert.assertTrue(productBlock.isIncreasingDucks(ducksIn));

        productBlock.goToCart();
        cartBlock.isCartBlock();
        softAssert.assertTrue(cartBlock.deleteOneKindDuck());
        softAssert.assertAll();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass()
    {
        driver.quit();
    }
}
