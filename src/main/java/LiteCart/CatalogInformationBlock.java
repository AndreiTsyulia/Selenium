package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrei_Tsyulia on 5/2/2017.
 */
public class CatalogInformationBlock
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public CatalogInformationBlock(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private String pageFlag = "//a[text()='Information']/..";
    private String formManufacturerId = "//select[@name='manufacturer_id']";
    private String formManufacturerIdOptionTemplate = "//select[@name='manufacturer_id']/option[text()='%s']";
    private String formSupplierId = "//select[@name='supplier_id']";
    private String formSupplierIdOptionTemplate = "//select[@name='supplier_id']/option[text()='%s']";
    private String formKeywords = "//input[@name='keywords']";
    private String formShortDescription = "//input[@name='short_description[en]']";
    private String formDescription = "//textarea[@name='description[en]']";
    private String formAttributes = "//textarea[@name='attributes[en]']";
    private String formHeadTitle = "//input[@name='head_title[en]']";
    private String formMetaDescription = "//input[@name='meta_description[en]']";
    private String inPricesBlock = "//main[@id='main']//a[text()='Prices']";
    private String isPrices = "//a[text()='Prices']/..";

    public boolean isInformationBlock()
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

    public void fillManufacturer(String manufacturer)
    {
        By lFormManufacturerId = By.xpath(formManufacturerId);
        driver.findElement(lFormManufacturerId).click();
        By lFormManufacturerIdOptionTemplate = By.xpath(String.format(formManufacturerIdOptionTemplate, manufacturer));
        driver.findElement(lFormManufacturerIdOptionTemplate).click();
    }

    public void fillSupplier(String supplier)
    {
        By lFormSupplierId = By.xpath(formSupplierId);
        driver.findElement(lFormSupplierId).click();
        By lFormSupplierIdOptionTemplate = By.xpath(String.format(formSupplierIdOptionTemplate, supplier));
        driver.findElement(lFormSupplierIdOptionTemplate).click();
    }

    public void fillKeywords(String keywords)
    {
        By lFormKeywords = By.xpath(formKeywords);
        driver.findElement(lFormKeywords).sendKeys(keywords);
    }

    public void fillShortDescription(String shortDescription)
    {
        By lFormShortDescription = By.xpath(formShortDescription);
        driver.findElement(lFormShortDescription).sendKeys(shortDescription);
    }

    public void fillDescription(String description)
    {
        By lFormDescription = By.xpath(formDescription);
        driver.findElement(lFormDescription).sendKeys(description);
    }

    public void fillAttributes(String attributes)
    {
        By lFormAttributes = By.xpath(formAttributes);
        driver.findElement(lFormAttributes).sendKeys(attributes);
    }

    public void fillHeadTitle(String headTitle)
    {
        By lFormHeadTitle = By.xpath(formHeadTitle);
        driver.findElement(lFormHeadTitle).sendKeys(headTitle);
    }

    public void fillMetaDescription(String metaDescription)
    {
        By lFormMetaDescription = By.xpath(formMetaDescription);
        driver.findElement(lFormMetaDescription).sendKeys(metaDescription);
    }

    public void goToPricesBlock()
    {
        By lInPricesBlock = By.xpath(inPricesBlock);
        driver.findElement(lInPricesBlock).click();
        By lIsPrices = By.xpath(isPrices);
        wait.until(ExpectedConditions.attributeContains(driver.findElement(lIsPrices), "class", "active"));
    }
}