package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrei_Tsyulia on 5/2/2017.
 */
public class CatalogPricesBlock
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public CatalogPricesBlock(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private String pageFlag = "//a[text()='Information']/..";
    private String formPurchasePrice = "//input[@name='purchase_price']";
    private String formPurchasePriceCurrencyCode = "//select[@name='purchase_price_currency_code']";
    private String formPurchasePriceCurrencyCodeOptionTemplate =
        "//select[@name='purchase_price_currency_code']/option[text()='%s']";
    private String formTaxClassId = "//select[@name='tax_class_id']";
    private String formTaxClassIdOptionTemplate = "//select[@name='tax_class_id']/option[text()='%s']";
    private String formPricesUSD = "//input[@name='prices[USD]']";
    private String formPricesEUR = "//input[@name='prices[EUR]']";
    private String formSave = "//button[@name='save']";


    public boolean isPricesBlock()
    {
        By lPageFlag = By.xpath(pageFlag);
        String str = "";
        try
        {
            str = driver.findElement(lPageFlag).getAttribute("class");
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
        if (str.equals("active"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void fillPurchasePrice(String purchasePrice)
    {
        By lFormPurchasePrice = By.xpath(formPurchasePrice);
        driver.findElement(lFormPurchasePrice).sendKeys(purchasePrice);
    }

    public void fillVal(String val)
    {
        By lFormPurchasePriceCurrencyCode = By.xpath(formPurchasePriceCurrencyCode);
        driver.findElement(lFormPurchasePriceCurrencyCode).click();
        By lFormPurchasePriceCurrencyCodeOptionTemplate = By.xpath(String.format
            (formPurchasePriceCurrencyCodeOptionTemplate, val));
        driver.findElement(lFormPurchasePriceCurrencyCodeOptionTemplate).click();
    }

    public void fillTaxClass(String taxClass)
    {
        By lFormTaxClassId = By.xpath(formTaxClassId);
        driver.findElement(lFormTaxClassId).click();
        By lFormTaxClassIdOptionTemplate = By.xpath(String.format(formTaxClassIdOptionTemplate, taxClass));
        driver.findElement(lFormTaxClassIdOptionTemplate).click();
    }

    public void fillPriceUSD(String priceUSD)
    {
        By lFormPricesUSD = By.xpath(formPricesUSD);
        driver.findElement(lFormPricesUSD).sendKeys(priceUSD);
    }

    public void fillPriceEUR(String priceEUR)
    {
        By lFormPricesEUR = By.xpath(formPricesEUR);
        driver.findElement(lFormPricesEUR).sendKeys(priceEUR);
    }

    public void savePricesInformation()
    {
        By lFormSave = By.xpath(formSave);
        driver.findElement(lFormSave).click();
    }
}