package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrei_Tsyulia on 5/2/2017.
 */
public class UserLoginBlock
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public UserLoginBlock(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private String newUserCreat = "//div[@id='box-account-login']//p/a";
    private String formEmail = "//div[@id='box-account-login']//input[@name='email']";
    private String formPassword = "//div[@id='box-account-login']//input[@name='password']";
    private String logOut = "//div[@id='box-account']//a[text()='Logout']";
    private String signIn = "//div[@id='box-account-login']//button[@name='login']";

    public void clicknewUserCreat()
    {
        By lNewUserCreat = By.xpath(newUserCreat);
        driver.findElement(lNewUserCreat).click();
    }

    public void logOut()
    {
        By lLogOut = By.xpath(logOut);
        driver.findElement(lLogOut).click();
    }

    public void enterEmail(String email)
    {
        By lFormEmail = By.xpath(formEmail);
        driver.findElement(lFormEmail).sendKeys(email);
    }

    public void enterPassword(String pass)
    {
        By lFormPassword = By.xpath(formPassword);
        driver.findElement(lFormPassword).sendKeys(pass);
    }

    public void SignIn()
    {
        By lSignIn = By.xpath(signIn);
        driver.findElement(lSignIn).click();
    }
}
