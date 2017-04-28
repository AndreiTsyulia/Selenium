package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Andrei_Tsyulia on 4/28/2017.
 */
public class EditCountriesBlock
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    private String pageFlag = "//main[@id='main']/h1";
    private String zonesRef = "//main[@id='main']//td[3]/input";

    public EditCountriesBlock(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


    public boolean isEditCountriesBlock()
    {
        By lPageFlag = By.xpath(pageFlag);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(lPageFlag, "Edit Country"));
        return driver.findElement(lPageFlag).isDisplayed();
    }

    public Boolean checkSortZones()
    {
        By lZonesRef = By.xpath(zonesRef);
        List<WebElement> elements = driver.findElements(lZonesRef);
        return checkSortByAlfabet(elements);
    }

    private Boolean checkSortByAlfabet(List<WebElement> elements)
    {
        for (int i = 1; i < elements.size(); i++)
        {
            if (elements.get(i - 1).getAttribute("value").compareTo(elements.get(i).getAttribute("value")) > 0)
            {
                return false;
            }
        }
        return true;
    }
}