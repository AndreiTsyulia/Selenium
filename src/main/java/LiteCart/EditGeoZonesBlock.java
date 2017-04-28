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
public class EditGeoZonesBlock
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    private String pageFlag = "//main[@id='main']/h1";
    private String zonesRef = "//main[@id='main']//td[3]";

    public EditGeoZonesBlock(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public boolean isEditGeoZonesBlock()
    {
        By lPageFlag = By.xpath(pageFlag);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(lPageFlag, "Edit Geo Zone"));
        return driver.findElement(lPageFlag).isDisplayed();
    }

    public boolean checkSortZones()
    {
        By lZonesRef = By.xpath(zonesRef);
        List<WebElement> elements = driver.findElements(lZonesRef);
        return checkSortByAlfabet(elements);
    }

    private Boolean checkSortByAlfabet(List<WebElement> elements)
    {
        for (int i = 1; i < elements.size(); i++)
        {
            if (elements.get(i - 1).getText().compareTo(elements.get(i).getText()) > 0)
            {
                return false;
            }
        }
        return true;
    }
}