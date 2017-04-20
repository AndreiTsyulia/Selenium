package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrei_Tsyulia on 4/20/2017.
 */
public class AdminPanelLogin
{
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String username ="//input[@name='username']";
    private String password ="//input[@name='password']";
    private String login ="//button[@name='login']";


    public AdminPanelLogin(WebDriver driver)
    {
        this.driver=driver;
        wait =new WebDriverWait(driver, 10);
    }

    public void typeUsername(String item)
    {
        By lUsername = By.xpath(username);
        driver.findElement(lUsername).sendKeys(item);
    }

    public void typePassword(String item)
    {
        By lPassword = By.xpath(password);
        driver.findElement(lPassword).sendKeys(item);
    }

    public void pressButton()
    {
        By lPressBtn = By.xpath(login);
        driver.findElement(lPressBtn).click();
    }

}
