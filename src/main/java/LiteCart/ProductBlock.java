package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrei_Tsyulia on 4/28/2017.
 */
public class ProductBlock
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public ProductBlock(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private String pageFlag = "//h1[@class='title']";
    private String nameOfProduct = "//h1[@class='title']";
    private String regularPrice = "//del[@class='regular-price']";
    private String campaignPrice = "//strong[@class='campaign-price']";
    private String packageSize = "//select[@name='options[Size]']";
    private String quantityDucksInCart = "//div[@id='cart']//span[@class='quantity']";
    private String btnAddCartProduct = "//button[@name='add_cart_product']";
    private String goToCart = "//div[@id='cart']";

    public boolean isProductBlock()
    {
        By lPageFlag = By.xpath(pageFlag);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lPageFlag));
        return driver.findElement(lPageFlag).isDisplayed();
    }

    public String getProductText()
    {
        By lNameOfProduct = By.xpath(nameOfProduct);
        String sNameOfProduct = driver.findElement(lNameOfProduct).getText();
        System.out.println(sNameOfProduct);
        return sNameOfProduct;
    }

    public String getRegularPrice()
    {
        By lRegularPrice = By.xpath(regularPrice);
        String sRegularPrice = driver.findElement(lRegularPrice).getText();
        System.out.println(sRegularPrice);
        return sRegularPrice;
    }

    public String getCampaignPrice()
    {
        By lCampaignPrice = By.xpath(campaignPrice);
        String sCampaignPrice = driver.findElement(lCampaignPrice).getText();
        System.out.println(sCampaignPrice);
        return sCampaignPrice;
    }

    public boolean checkTextLine()
    {
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

    public void selectSize()
    {
        By lPackageSize = By.xpath(packageSize);
        WebElement element = driver.findElement(lPackageSize);
        new Select(element).selectByValue("Small");
    }

    public int getDucksInCart()
    {
        By lQuantityDucksInCart = By.xpath(quantityDucksInCart);
        return Integer.parseInt(driver.findElement(lQuantityDucksInCart).getText());
    }

    public void addToCart()
    {
        By lBtnAddCartProduct = By.xpath(btnAddCartProduct);
        driver.findElement(lBtnAddCartProduct).click();
    }

    public boolean isIncreasingDucks(int ducksInCart)
    {
        try
        {
            By lQuantityDucksInCart = By.xpath(quantityDucksInCart);
            wait.until(ExpectedConditions.textToBePresentInElementLocated(lQuantityDucksInCart, "" + (ducksInCart + 1)));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public void goToCart()
    {
        By lGoToCart = By.xpath(goToCart);
        driver.findElement(lGoToCart).click();
    }
}
