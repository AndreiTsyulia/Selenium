package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrei_Tsyulia on 4/20/2017.
 */
public class AdminPanel
{
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String search = "//input[@name='query']";
    private String itemsMenu = "//li[@id='app-']/a";
    private String itemMenuLinkTemplate = "//ul[@id='box-apps-menu']/li[%s]/a";
    private String catalogItemMenu = "//li[@id='app-']/a/span[contains(text(),'Catalog')]";
    private String itemMenuTemplate = "//ul[@id='box-apps-menu']/li[%s]";
    private String subItemsMenu = "//ul[@class='docs']/li";
    private String subItemMenuTemplate = "//ul[@class='docs']/li[%s]";
    private String blockTitle = "//main[@id='main']/h1";
    private String addNewProduct = "//main[@id='main']//a[contains(text(),'Add New Product')]";
    private String addNewProductTemplate = "//a[text()='%s']";


    public AdminPanel(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public boolean isAdminPanel()
    {
        By lSearch = By.xpath(search);
        wait.until(ExpectedConditions.presenceOfElementLocated(lSearch));
        return driver.findElement(lSearch).isDisplayed();
    }

    public int getMenuItems()
    {
        By lItemsMenu = By.xpath(itemsMenu);
        return driver.findElements(lItemsMenu).size();
    }

    public int getSubMenuItems()
    {
        By lSubItemsMenu = By.xpath(subItemsMenu);
        return driver.findElements(lSubItemsMenu).size();
    }

    public boolean checkBlockTitle()
    {
        By lBlockTitle = By.xpath(blockTitle);
        return driver.findElement(lBlockTitle).isDisplayed();
    }

    public void clickItemMenu(int i)
    {
        By lItemMenuTemplate = By.xpath(String.format(itemMenuTemplate, "" + i));
        By lItemMenuLinkTemplate = By.xpath(String.format(itemMenuLinkTemplate, "" + i));
        driver.findElement(lItemMenuLinkTemplate).click();
        wait.until(ExpectedConditions.attributeContains(lItemMenuTemplate, "class", "selected"));
    }

    public void clickSubItemMenu(int i)
    {
        By lSubItemMenuTemplate = By.xpath(String.format(subItemMenuTemplate, "" + i));
        driver.findElement(lSubItemMenuTemplate).click();
        wait.until(ExpectedConditions.attributeContains(lSubItemMenuTemplate, "class", "selected"));
    }

    public void goToCatalog()
    {
        By lCatalogItemMenu = By.xpath(catalogItemMenu);
        driver.findElement(lCatalogItemMenu).click();
    }

    public void pressAddNewProduct()
    {
        By lAddNewProduct = By.xpath(addNewProduct);
        driver.findElement(lAddNewProduct).click();
    }

    public boolean isDuckPresent(String name)
    {
        By lAddNewProductTemplate = By.xpath(String.format(addNewProductTemplate, name));
        return driver.findElement(lAddNewProductTemplate).isDisplayed();
    }

    public void goToNewProduct(String name)
    {
        By lAddNewProductTemplate = By.xpath(String.format(addNewProductTemplate, name));
        driver.findElement(lAddNewProductTemplate).click();
    }
}
