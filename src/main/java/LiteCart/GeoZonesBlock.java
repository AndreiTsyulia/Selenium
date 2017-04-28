package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrei_Tsyulia on 4/28/2017.
 */
public class GeoZonesBlock
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    private String pageFlag = "//main[@id='main']/h1";
    private String countriesWithZonesRef = "//main[@id='main']//td[3]/a";
    private String countryWithZonesRefTemplate = "//main[@id='main']//tr[%s]/td[3]/a";

    public GeoZonesBlock(WebDriver driver)
    {
        this.driver=driver;
        wait =new WebDriverWait(driver, 10);
    }

    public boolean isGeoZonesBlock()
    {
        By lPageFlag = By.xpath(pageFlag);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(lPageFlag, "Geo Zones"));
        return driver.findElement(lPageFlag).isDisplayed();
    }


    public int numberOfCountries()
    {
        By lCountriesWithZonesRef = By.xpath(countriesWithZonesRef);
        return driver.findElements(lCountriesWithZonesRef).size();
    }

    public void clickItemMenu(int i)
    {
        By lCountryWithZonesRefTemplate = By.xpath(String.format(countryWithZonesRefTemplate, "" + i));
        driver.findElement(lCountryWithZonesRefTemplate).click();
    }
}