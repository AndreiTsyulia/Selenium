package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Andrei_Tsyulia on 4/28/2017.
 */
public class CountriesBlock
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    private String pageFlag = "//main[@id='main']/h1";
    private String countriesRef = "//main[@id='main']//td[5]/a";
    private String numberOfZones = "//main[@id='main']//td[6]";
    private String countryRefTemplate = "//main[@id='main']//tr[%s]/td[5]/a";

    public CountriesBlock(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public boolean isCountriesBlock()
    {
        By lPageFlag = By.xpath(pageFlag);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(lPageFlag, "Countries"));
        return driver.findElement(lPageFlag).isDisplayed();
    }

    public Boolean checkSortCountries()
    {
        By lCountriesRef = By.xpath(countriesRef);
        List<WebElement> elements = driver.findElements(lCountriesRef);
        return checkSortByAlfabet(elements);
    }

    public ArrayList<Integer> getCountriesWithZone()
    {
        ArrayList<Integer> countNumbersOfCountry = new ArrayList<Integer>();
        By lNumberOfZones = By.xpath(numberOfZones);
        List<WebElement> elements = driver.findElements(lNumberOfZones);
        for(int i=0;i<elements.size();i++){
            if(elements.get(i).getText().equals("0")){}else{
            countNumbersOfCountry.add(i+1);}
            }
        return countNumbersOfCountry;
    }

    public void goToCountry(int x){
        By lCountryRefTemplate = By.xpath(String.format(countryRefTemplate, "" + x));
        driver.findElement(lCountryRefTemplate).click();
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

    public void goToSomeCountry()
    {
        By lCountriesRef = By.xpath(countriesRef);
        goToCountry(new Random().nextInt(driver.findElements(lCountriesRef).size()));
    }
}
