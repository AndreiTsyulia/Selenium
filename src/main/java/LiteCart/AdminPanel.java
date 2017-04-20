package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrei_Tsyulia on 4/20/2017.
 */
public class AdminPanel
{
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String search ="//input[@name='query']";


    public AdminPanel(WebDriver driver)
    {
        this.driver=driver;
        wait =new WebDriverWait(driver, 10);
    }

    public boolean isAdminPanel()
    {
        By lSearch = By.xpath(search);
        wait.until(ExpectedConditions.presenceOfElementLocated(lSearch));
        return driver.findElement(lSearch).isDisplayed();
    }
}
