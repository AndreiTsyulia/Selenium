package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrei_Tsyulia on 5/17/2017.
 */
public class EditProductBlock
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public EditProductBlock(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private String pageFlag = "//main[@id='main']/h1[contains(text(),'Edit Product')]";

    public boolean isEditProductBlock()
    {
        By lPageFlag = By.xpath(pageFlag);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lPageFlag));
        return driver.findElement(lPageFlag).isDisplayed();
    }

    public boolean checkLog()
    {
        int i = 0;
        for (LogEntry l : driver.manage().logs().get("browser").getAll())
        {
            System.out.println(l.getMessage());
            i++;
        }

        for (LogEntry l : driver.manage().logs().get("driver").getAll())
        {
            System.out.println(l.getMessage());
            i++;
        }

        for (LogEntry l : driver.manage().logs().get("client").getAll())
        {
            System.out.println(l.getMessage());
            i++;
        }
        if (i > 0)
        {
            return true;
        }
        else
        {
            System.out.println("Логов нет");
            return false;
        }
    }
}
