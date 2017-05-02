import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import Helper.User;
import LiteCart.MainPage;
import LiteCart.NewUserBlock;
import LiteCart.UserLoginBlock;

/**
 * Created by Andrei_Tsyulia on 5/2/2017.
 */
public class Task11UserTests
{
    protected WebDriver driver;
    protected MainPage mainPage;
    protected NewUserBlock newUserBlock;
    protected UserLoginBlock userLoginBlock;
    private User user;

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
        newUserBlock = new NewUserBlock(driver);
        userLoginBlock = new UserLoginBlock(driver);
        user=new User("123456789","no", "Andrei", "Tsyulia", "New York, 25 avenu, 5", "no", "12345",
            "New York", "United States", "New York", "12345678901","qwertyuiop");
        System.out.println(user.toString());
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod()
    {
        driver.get("http://localhost/litecart/");
        mainPage.isMainPage();
    }

    @Test
    public void registrationTest()
    {
        userLoginBlock.clicknewUserCreat();
        newUserBlock.isNewUserBlock();
        newUserBlock.fillTaxID(user.getTaxID());
        newUserBlock.fillCompany(user.getCompany());
        newUserBlock.fillFirstName(user.getFirstName());
        newUserBlock.fillLastName(user.getLastName());
        newUserBlock.fillAddress1(user.getAddress1());
        newUserBlock.fillAddress2(user.getAddress2());
        newUserBlock.fillPostcode(user.getPostcode());
        newUserBlock.fillCity(user.getCity());
        newUserBlock.fillCountry(user.getCountry());
        newUserBlock.fillState(user.getState());
        newUserBlock.fillEmail(user.getEmail());
        newUserBlock.fillPhone(user.getPhone());
        newUserBlock.fillPassword(user.getPassword());
        newUserBlock.fillConfirmPassword(user.getPassword());
        newUserBlock.createAccount();
        userLoginBlock.logOut();
        userLoginBlock.enterEmail(user.getEmail());
        userLoginBlock.enterPassword(user.getPassword());
        userLoginBlock.SignIn();
        userLoginBlock.logOut();
    }
    
    @AfterClass(alwaysRun = true)
    public void afterClass()
    {
        driver.quit();
    }
}
