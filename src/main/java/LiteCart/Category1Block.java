package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrei_Tsyulia on 5/17/2017.
 */
public class Category1Block
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Category1Block(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private String pageFlag = "//main[@id='main']/h1[contains(text(),'Catalog')]";
    private String closeFolder = "//main[@id='main']//td[3]/i[@class='fa fa-folder']/following-sibling::a";
    private String products = "//main[@id='main']//td[3]/a";

    public boolean isCategory1Block()
    {
        By lPageFlag = By.xpath(pageFlag);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lPageFlag));
        return driver.findElement(lPageFlag).isDisplayed();
    }

    public boolean hasCloseFolder()
    {
        try
        {
            By lCloseFolder = By.xpath(closeFolder);
            driver.findElement(lCloseFolder).isDisplayed();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }

    }
    public void openAllFolders()
    {
        while (hasCloseFolder()){
            By lCloseFolder = By.xpath(closeFolder);
            driver.findElement(lCloseFolder).click();
        }
    }

    public int countLinks()
    {
        By lProducts = By.xpath(products);
        return driver.findElements(lProducts).size();
    }

    public void goToEditProduct(int i)
    {
        By lProducts = By.xpath(products);
        driver.findElements(lProducts).get(i).click();
    }
}
