package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        if (sRegularPrice.equals("s")||sRegularPrice.equals("del")||sRegularPrice.equals("strike"))
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
        sRegularPrice=sRegularPrice.substring((sRegularPrice.indexOf("(")+1),sRegularPrice.lastIndexOf(")"));
        System.out.println(sRegularPrice);
        String[] strColor=sRegularPrice.split(",");
        if (strColor[0].equals(strColor[1])||strColor[1].equals(strColor[2]))
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
        sCampaignPrice=sCampaignPrice.substring((sCampaignPrice.indexOf("(")+1),sCampaignPrice.lastIndexOf(")"));
        System.out.println(sCampaignPrice);
        String[] strColor=sCampaignPrice.split(",");
        if (Integer.parseInt(strColor[0])!=0||strColor[1].equals("0")||strColor[2].equals("0"))
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
        if (sCampaignPrice.equals("b")||sCampaignPrice.equals("strong"))
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
}
