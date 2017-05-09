package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

/**
 * Created by Andrei_Tsyulia on 4/28/2017.
 */
public class EditCountriesBlock
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    private String pageFlag = "//main[@id='main']/h1";
    private String zonesRef = "//main[@id='main']//td[3]/input";
    private String linksToExternalWindows = "//main[@id='main']//i[@class='fa fa-external-link']";

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

    public int countLinks()
    {
        By lLinksToWindows = By.xpath(linksToExternalWindows);
        return driver.findElements(lLinksToWindows).size();
    }

    public boolean checkWindow(int i)
    {
        By lLinksToWindows = By.xpath(linksToExternalWindows);
        List<WebElement> elements = driver.findElements(lLinksToWindows);
        String parentWindow = driver.getWindowHandle();
        Set<String> windowsBefore = driver.getWindowHandles();
        elements.get(i).click();
        String newWindow = wait.until(thereIsNewWindow(windowsBefore));
        driver.switchTo().window(newWindow);
        driver.close();
        driver.switchTo().window(parentWindow);
        Set<String> windowsAfter = driver.getWindowHandles();
        return windowsBefore.equals(windowsAfter) ? true : false;
    }

    public ExpectedCondition<String> thereIsNewWindow(final Set<String> windowsBefore)
    {
        return new ExpectedCondition<String>()
        {
            public String apply(WebDriver driver)
            {
                Set<String> windowsInWait = driver.getWindowHandles();
                windowsInWait.removeAll(windowsBefore);
                return windowsInWait.size() > 0 ? windowsInWait.iterator().next() : null;
            }
        };
    }
}