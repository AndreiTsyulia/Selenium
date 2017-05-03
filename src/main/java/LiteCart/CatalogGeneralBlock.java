package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

/**
 * Created by Andrei_Tsyulia on 5/2/2017.
 */
public class CatalogGeneralBlock
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public CatalogGeneralBlock(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private String pageFlag = "//main[@id='main']//a[text()='General']/..";
    private String btnEnabled = "//div[@id='tab-general']//label[contains(text(),'Enabled')]";
    private String checkBoxCategories = "//div[@id='tab-general']//input[@name='categories[]']";
    private String checkBoxCategoriesTemplate = "//div[%s]/label/input[@name='categories[]']";
    private String categoryNamesTemplate = "//div[%s]/label/input[@name='categories[]']/..";
    private String formDefaultCategory = "//select[@name='default_category_id']";
    private String optionDefaultCategory = "//select[@name='default_category_id']/option[text()='%s']";
    private String optionProductGroups = "//label[contains(text(),'%s')]/input[@name='product_groups[]']";
    private String formDateValidFrom = "//input[@name='date_valid_from']";
    private String formDateValidTo = "//input[@name='date_valid_to']";
    private String formCode = "//input[@name='code']";
    private String formName = "//input[@name='name[en]']";
    private String formSku = "//input[@name='sku']";
    private String formGtin = "//input[@name='gtin']";
    private String formTaric = "//input[@name='taric']";
    private String formQuantity = "//input[@name='quantity']";
    private String formQuantityUnitId = "//select[@name='quantity_unit_id']";
    private String formQuantityUnitIdTemplate = "//select[@name='quantity_unit_id']/option[text()='%s']";
    private String formWeight = "//input[@name='weight']";
    private String formWeightClass = "//select[@name='weight_class']";
    private String formWeightClassOptionTemplate = "//select[@name='weight_class']/option[text()='%s']";
    private String formWidth = "//input[@name='dim_x']";
    private String formHeight = "//input[@name='dim_y']";
    private String formLength = "//input[@name='dim_z']";
    private String formDimClass = "//select[@name='dim_class']";
    private String formDimClassOptionTemplate = "//select[@name='dim_class']/option[text()='%s']";
    private String formDeliveryStatusId = "//select[@name='delivery_status_id']";
    private String formDeliveryStatusIdOptionTemplate = "//select[@name='delivery_status_id']/option[text()='%s']";
    private String formSoldOutStatusId = "//select[@name='sold_out_status_id']";
    private String formSoldOutStatusIdOptionTemplate = "//select[@name='sold_out_status_id']/option[text()='%s']";
    private String formNewImages = "//input[@name='new_images[]']";
    private String informationBlock = "//main[@id='main']//a[text()='Information']";
    private String isInformation = "//a[text()='Information']/..";
    private String formDelete = "//button[@name='delete']";

    public boolean isCatalogGeneralBlock()
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

    public void fillStatus(boolean status)
    {
        By lBtnEnabled = By.xpath(btnEnabled);
        WebElement element = driver.findElement(lBtnEnabled);
        if (status)
        {
            if (element.getAttribute("class").contains("active"))
            {
            }
            else
            {
                element.click();
            }
        }
        else
        {
            if (element.getAttribute("class").contains("active"))
            {
                element.click();
            }
        }
    }

    public void fillCategories(String[] categories)
    {
        By lCheckBoxCategories = By.xpath(checkBoxCategories);
        int y = driver.findElements(lCheckBoxCategories).size();
        if (categories != null)
        {
            for (int i = 0; i < categories.length; i++)
            {
                String str = categories[i];
                for (int j = 1; j <= y; j++)
                {
                    By lCheckBoxCategoriesTemplate = By.xpath(String.format(checkBoxCategoriesTemplate, j));
                    WebElement checkBox = driver.findElement(lCheckBoxCategoriesTemplate);
                    By lCategoryNamesTemplate = By.xpath(String.format(categoryNamesTemplate, j));
                    WebElement label = driver.findElement(lCategoryNamesTemplate);
                    String str2 = label.getText();
                    System.out.println("categories[" + i + "] - " + categories[i] + " lCategoryNamesTemplate - " + str2);
                    if (str.equals(str2))
                    {
                        try
                        {
                            if (checkBox.getAttribute("checked").equals("checked"))
                            {
                            }
                        }
                        catch (NullPointerException e)
                        {
                            checkBox.click();
                        }
                    }
                    else
                    {
                        try
                        {
                            if (checkBox.getAttribute("checked").equals("checked"))
                            {
                                checkBox.click();
                            }
                        }
                        catch (NullPointerException e)
                        {
                        }
                    }
                }
            }
        }
    }

    public void fillDefaultCategory(String defaultCategory)
    {
        By lFormDefaultCategory = By.xpath(formDefaultCategory);
        driver.findElement(lFormDefaultCategory).click();
        By lOptionDefaultCategory = By.xpath(String.format(optionDefaultCategory, defaultCategory));
        driver.findElement(lOptionDefaultCategory).click();
    }

    public void fillProductGroups(String productGroups)
    {
        By lOptionProductGroups = By.xpath(String.format(optionProductGroups, productGroups));
        driver.findElement(lOptionProductGroups).click();
    }

    public void fillDateValidFrom(String dateValidFrom)
    {
        By lFormDateValidFrom = By.xpath(formDateValidFrom);
        driver.findElement(lFormDateValidFrom).sendKeys(dateValidFrom);

    }

    public void fillDateValidTo(String dateValidTo)
    {
        By lFormDateValidTo = By.xpath(formDateValidTo);
        driver.findElement(lFormDateValidTo).sendKeys(dateValidTo);
    }

    public void fillCode(String code)
    {
        By lFormCode = By.xpath(formCode);
        driver.findElement(lFormCode).sendKeys(code);
    }

    public void fillName(String name)
    {
        By lFormName = By.xpath(formName);
        driver.findElement(lFormName).sendKeys(name);
    }

    public void fillSku(String sku)
    {
        By lFormSku = By.xpath(formSku);
        driver.findElement(lFormSku).sendKeys(sku);
    }

    public void fillGtin(String gtin)
    {
        By lFormGtin = By.xpath(formGtin);
        driver.findElement(lFormGtin).sendKeys(gtin);
    }

    public void fillTaric(String taric)
    {
        By lFormTaric = By.xpath(formTaric);
        driver.findElement(lFormTaric).sendKeys(taric);
    }

    public void fillQuantity(String quantity)
    {
        By lFormQuantity = By.xpath(formQuantity);
        driver.findElement(lFormQuantity).sendKeys(quantity);
    }

    public void fillQuantityMeasure(String quantityMeasure)
    {
        By lFormQuantityUnitId = By.xpath(formQuantityUnitId);
        driver.findElement(lFormQuantityUnitId).click();
        By lFormQuantityUnitIdTemplate = By.xpath(String.format(formQuantityUnitIdTemplate, quantityMeasure));
        driver.findElement(lFormQuantityUnitIdTemplate).click();
    }

    public void fillWeight(String weight)
    {
        By lFormWeight = By.xpath(formWeight);
        driver.findElement(lFormWeight).sendKeys(weight);
    }

    public void fillWeightMeasure(String weightMeasure)
    {
        By lFormWeightClass = By.xpath(formWeightClass);
        driver.findElement(lFormWeightClass).click();
        By lFormWeightClassOptionTemplate = By.xpath(String.format(formWeightClassOptionTemplate, weightMeasure));
        driver.findElement(lFormWeightClassOptionTemplate).click();
    }

    public void fillWidth(String width)
    {
        By lFormWidth = By.xpath(formWidth);
        driver.findElement(lFormWidth).sendKeys(width);
    }

    public void fillHeight(String height)
    {
        By lFormHeight = By.xpath(formHeight);
        driver.findElement(lFormHeight).sendKeys(height);
    }

    public void fillLength(String length)
    {
        By lFormLength = By.xpath(formLength);
        driver.findElement(lFormLength).sendKeys(length);
    }

    public void fillSizeMeasure(String sizeMeasure)
    {
        By lFormDimClass = By.xpath(formDimClass);
        driver.findElement(lFormDimClass).click();
        By lFormDimClassOptionTemplate = By.xpath(String.format(formDimClassOptionTemplate, sizeMeasure));
        driver.findElement(lFormDimClassOptionTemplate).click();
    }

    public void fillDeliveryStatus(String deliveryStatus)
    {
        By lFormDeliveryStatusId = By.xpath(formDeliveryStatusId);
        driver.findElement(lFormDeliveryStatusId).click();
        By lFormDeliveryStatusIdOptionTemplate = By.xpath(String.format(formDeliveryStatusIdOptionTemplate, deliveryStatus));
        driver.findElement(lFormDeliveryStatusIdOptionTemplate).click();
    }

    public void fillSoldOutStatus(String soldOutStatus)
    {
        By lFormSoldOutStatusId = By.xpath(formSoldOutStatusId);
        driver.findElement(lFormSoldOutStatusId).click();
        By lFormSoldOutStatusIdOptionTemplate = By.xpath(String.format(formSoldOutStatusIdOptionTemplate, soldOutStatus));
        driver.findElement(lFormSoldOutStatusIdOptionTemplate).click();
    }

    public void fillPathOfImage(String pathOfImage)
    {
        By lFormNewImages = By.xpath(formNewImages);
        String path = new File(pathOfImage).getAbsolutePath();
        driver.findElement(lFormNewImages).sendKeys(path);
    }

    public void goToInformationBlock()
    {
        By lInformationBlock = By.xpath(informationBlock);
        driver.findElement(lInformationBlock).click();
        By lIsInformation = By.xpath(isInformation);
        wait.until(ExpectedConditions.attributeContains(driver.findElement(lIsInformation), "class", "active"));
    }

    public void deleteNewProduct()
    {
        By lFormDelete = By.xpath(formDelete);
        driver.findElement(lFormDelete).click();
    }
}
