package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrei_Tsyulia on 4/25/2017.
 */
public class MainPage
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private String stikers = ".//div[contains(@class,'sticker')]";
    private String campaignProducts = "//a[contains(text(),'Campaign Products')]/..";
    private String productsInCampaign = "//div[@id='box-campaigns']//div[@class='product column shadow hover-light']";
    private String productInCampaignTemplate = "//div[@id='box-campaigns']/div/div[%s]";
    private String popularProducts = "//a[contains(text(),'Popular Products')]/..";
    private String productsInPopular = "//div[@id='box-most-popular']//div[@class='product column shadow hover-light']";
    private String productInPopularTemplate = "//div[@id='box-most-popular']/div/div[%s]";
    private String latestProducts = "//a[contains(text(),'Latest Products')]/..";
    private String productsInLatest = "//div[@id='box-latest-products']//div[@class='product column shadow hover-light']";
    private String productInLatestTemplate = "//div[@id='box-latest-products']/div/div[%s]";

    public void clickCampaignProducts()
    {
        By lCampaignProducts = By.xpath(campaignProducts);
        driver.findElement(lCampaignProducts).click();
        wait.until(ExpectedConditions.attributeContains(lCampaignProducts, "class", "active"));
    }

    public int getProductsInCampaign()
    {
        By lProductsInCampaign = By.xpath(productsInCampaign);
        return driver.findElements(lProductsInCampaign).size();
    }

    public boolean checkStikerInCampaign(int j)
    {
        By lProductInCampaignTemplate = By.xpath(String.format(productInCampaignTemplate, "" + j));
        WebElement element = driver.findElement(lProductInCampaignTemplate);
        By lStikers = By.xpath(stikers);
        return element.findElement(lStikers).isDisplayed();
    }

    public void clickPopularProducts()
    {
        By lPopularProducts = By.xpath(popularProducts);
        driver.findElement(lPopularProducts).click();
        wait.until(ExpectedConditions.attributeContains(lPopularProducts, "class", "active"));
    }

    public int getProductsInPopular()
    {
        By lProductsInPopular = By.xpath(productsInPopular);
        return driver.findElements(lProductsInPopular).size();
    }

    public boolean checkStikerInPopular(int j)
    {
        By lProductInPopularTemplate = By.xpath(String.format(productInPopularTemplate, "" + j));
        WebElement element = driver.findElement(lProductInPopularTemplate);
        By lStikers = By.xpath(stikers);
        return element.findElement(lStikers).isDisplayed();
    }

    public void clickLatestProducts()
    {
        By lLatestProducts = By.xpath(latestProducts);
        driver.findElement(lLatestProducts).click();
        wait.until(ExpectedConditions.attributeContains(lLatestProducts, "class", "active"));
    }

    public int getProductsInLatest()
    {
        By lProductsInLatest = By.xpath(productsInLatest);
        return driver.findElements(lProductsInLatest).size();
    }

    public boolean checkStikerInLatest(int j)
    {
        By lProductInLatestTemplate = By.xpath(String.format(productInLatestTemplate, "" + j));
        WebElement element = driver.findElement(lProductInLatestTemplate);
        By lStikers = By.xpath(stikers);
        return element.findElement(lStikers).isDisplayed();
    }
}
