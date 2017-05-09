package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

    private String pageFlag = "//div[@id='rslides1_s0']/img";
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


    //---------------Блок товара---------------\/
    private String viewOfProduct = "//div[@id='view-full-page']/a";
    private String nameOfProduct = "//div[@id='box-campaigns']//div[@class='name']";
    private String campaignPrice = "//div[@id='box-campaigns']//strong[@class='campaign-price']";
    private String regularPrice = "//div[@id='box-campaigns']//s[@class='regular-price']";
    private String nameOfProductPopular = "//div[@id='box-most-popular']//div[@class='name']";
    private String nameOfProductLatest = "//div[@id='box-latest-products']//div[@class='name']";
    //---------------Блок товара---------------/\


    public boolean isMainPage()
    {
        By lPageFlag = By.xpath(pageFlag);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lPageFlag));
        return driver.findElement(lPageFlag).isDisplayed();
    }

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
        return (element.findElements(lStikers).size() == 1);
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
        return (element.findElements(lStikers).size() == 1);
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
        return (element.findElements(lStikers).size() == 1);
    }

    //---------------Блок товара---------------\/
    public String getProductText()
    {
        clickCampaignProducts();
        By lNameOfProduct = By.xpath(nameOfProduct);
        String sNameOfProduct = driver.findElement(lNameOfProduct).getText();
        System.out.println(sNameOfProduct);
        return sNameOfProduct;
    }

    public void goToProductBlock()
    {
        By lNameOfProduct = By.xpath(nameOfProduct);
        driver.findElement(lNameOfProduct).click();
        By lViewOfProduct = By.xpath(viewOfProduct);
        String driverName = driver.getClass().getSimpleName();
        System.out.println(driverName);
        if (driverName.equals("FirefoxDriver"))
        {
            try
            {
                wait.until(ExpectedConditions.elementToBeClickable(lViewOfProduct));
            }
            catch (Exception e)
            {
            }
        }
        if (driver.getCurrentUrl().equals("http://localhost/litecart/en/"))
        {
            driver.findElement(lViewOfProduct).click();
            wait.until(ExpectedConditions.urlContains("duck"));
        }
    }

    public void goToProductBlockPopular()
    {
        By lNameOfProductPopular = By.xpath(nameOfProductPopular);
        driver.findElement(lNameOfProductPopular).click();
        By lViewOfProduct = By.xpath(viewOfProduct);
        String driverName = driver.getClass().getSimpleName();
        System.out.println(driverName);
        if (driverName.equals("FirefoxDriver"))
        {
            try
            {
                wait.until(ExpectedConditions.elementToBeClickable(lViewOfProduct));
            }
            catch (Exception e)
            {
            }
        }
        if (driver.getCurrentUrl().equals("http://localhost/litecart/en/"))
        {
            driver.findElement(lViewOfProduct).click();
            wait.until(ExpectedConditions.urlContains("duck"));
        }
    }

    public void goToProductBlockLatest()
    {
        By lNameOfProductLatest = By.xpath(nameOfProductLatest);
        driver.findElement(lNameOfProductLatest).click();
        By lViewOfProduct = By.xpath(viewOfProduct);
        String driverName = driver.getClass().getSimpleName();
        System.out.println(driverName);
        if (driverName.equals("FirefoxDriver"))
        {
            try
            {
                wait.until(ExpectedConditions.elementToBeClickable(lViewOfProduct));
            }
            catch (Exception e)
            {
            }
        }
        if (driver.getCurrentUrl().equals("http://localhost/litecart/en/"))
        {
            driver.findElement(lViewOfProduct).click();
            wait.until(ExpectedConditions.urlContains("duck"));
        }
    }

    public String getRegularPrice()
    {
        clickCampaignProducts();
        By lRegularPrice = By.xpath(regularPrice);
        String sRegularPrice = driver.findElement(lRegularPrice).getText();
        System.out.println(sRegularPrice);
        return sRegularPrice;
    }

    public String getCampaignPrice()
    {
        clickCampaignProducts();
        By lCampaignPrice = By.xpath(campaignPrice);
        String sCampaignPrice = driver.findElement(lCampaignPrice).getText();
        System.out.println(sCampaignPrice);
        return sCampaignPrice;
    }

    public boolean checkTextLine()
    {
        clickCampaignProducts();
        By lRegularPrice = By.xpath(regularPrice);
        String sRegularPrice = driver.findElement(lRegularPrice).getTagName();
        System.out.println(sRegularPrice);
        if (sRegularPrice.equals("s") || sRegularPrice.equals("del") || sRegularPrice.equals("strike"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkRegularPriceColor()
    {
        clickCampaignProducts();
        By lRegularPrice = By.xpath(regularPrice);
        String sRegularPrice = driver.findElement(lRegularPrice).getCssValue("color");
        sRegularPrice = sRegularPrice.substring((sRegularPrice.indexOf("(") + 1), sRegularPrice.lastIndexOf(")"));
        System.out.println(sRegularPrice);
        String[] strColor = sRegularPrice.split(",");
        if (strColor[0].equals(strColor[1]) || strColor[1].equals(strColor[2]))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkCampaignPriceColor()
    {
        clickCampaignProducts();
        By lCampaignPrice = By.xpath(campaignPrice);
        String sCampaignPrice = driver.findElement(lCampaignPrice).getCssValue("color");
        sCampaignPrice = sCampaignPrice.substring((sCampaignPrice.indexOf("(") + 1), sCampaignPrice.lastIndexOf(")"));
        System.out.println(sCampaignPrice);
        String[] strColor = sCampaignPrice.split(",");
        if (Integer.parseInt(strColor[0]) != 0 || strColor[1].equals("0") || strColor[2].equals("0"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkBoldCampaignPrice()
    {
        clickCampaignProducts();
        By lCampaignPrice = By.xpath(campaignPrice);
        String sCampaignPrice = driver.findElement(lCampaignPrice).getTagName();
        System.out.println(sCampaignPrice);
        if (sCampaignPrice.equals("b") || sCampaignPrice.equals("strong"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean compareCampaignAndRegularPrices()
    {
        clickCampaignProducts();
        By lCampaignPrice = By.xpath(campaignPrice);
        Dimension sizeCampaignPrice = driver.findElement(lCampaignPrice).getSize();
        By lRegularPrice = By.xpath(regularPrice);
        Dimension sizeRegularPrice = driver.findElement(lRegularPrice).getSize();
        System.out.println("sizeCampaignPrice - " + sizeCampaignPrice.getHeight() * sizeCampaignPrice.getWidth() + ". "
            + "sizeRegularPrice - " + sizeRegularPrice.getWidth() * sizeRegularPrice.getHeight());
        if (sizeCampaignPrice.getHeight() * sizeCampaignPrice.getWidth() > sizeRegularPrice.getWidth() * sizeRegularPrice
            .getHeight())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //---------------Блок товара---------------/\
}
