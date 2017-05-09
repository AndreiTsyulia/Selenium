package LiteCart;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Andrei_Tsyulia on 5/5/2017.
 */
public class CartBlock
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public CartBlock(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private String pageFlag = "//div[@id='box-checkout-cart']/h2";
    private String quantityDucksInCart = "//div[@id='box-checkout-cart']//input[contains(@name,'[quantity]')]";
    private String updateCartItem = "//button[@name='update_cart_item']";
    private String tableFlag = "//div[@id='order_confirmation-wrapper']//tbody/tr[1]/td[2]";
    private String thereAreNoItemsInYourCart = "//div[@id='box-checkout']//p/em";
    private String deleteButton = "//div[@id='box-checkout-cart']//button[@class='btn btn-danger']";

    public boolean isCartBlock()
    {
        By lPageFlag = By.xpath(pageFlag);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lPageFlag));
        return driver.findElement(lPageFlag).isDisplayed();
    }

    public int getDucksInCart()
    {
        By lQuantityDucksInCart = By.xpath(quantityDucksInCart);
        return Integer.parseInt(driver.findElement(lQuantityDucksInCart).getAttribute("value"));
    }

    public void deleteOneDuck()
    {
        By lQuantityDucksInCart = By.xpath(quantityDucksInCart);
        WebElement element = driver.findElement(lQuantityDucksInCart);
        int number = Integer.parseInt(element.getAttribute("value"));
        element.clear();
        element.sendKeys("" + (number - 1));

        By lTableFlag = By.xpath(tableFlag);
        WebElement elementTab = driver.findElement(lTableFlag);

        By lUpdateCartItem = By.xpath(updateCartItem);
        driver.findElement(lUpdateCartItem).click();

        wait.until(ExpectedConditions.stalenessOf(elementTab));

        if (number != 1)
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(lTableFlag));
        }
        else
        {
            By lThereAreNoItemsInYourCart = By.xpath(thereAreNoItemsInYourCart);
            wait.until(ExpectedConditions.presenceOfElementLocated(lThereAreNoItemsInYourCart));
        }
    }

    public boolean deleteOneKindDuck()
    {
        try
        {
            By lDeleteButton = By.xpath(deleteButton);
            By lTableFlag = By.xpath(tableFlag);
            WebElement elementTab = driver.findElement(lTableFlag);
            driver.findElement(lDeleteButton).click();
            wait.until(ExpectedConditions.stalenessOf(elementTab));
            wait.until(ExpectedConditions.presenceOfElementLocated(lTableFlag));

            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public boolean isDecreasingDucks(int ducksInCart)
    {
        if (ducksInCart != 1)
        {
            By lQuantityDucksInCart = By.xpath(quantityDucksInCart);
            return Integer.parseInt(driver.findElement(lQuantityDucksInCart).getAttribute("value")) + 1 == ducksInCart;
        }
        else
        {
            By lThereAreNoItemsInYourCart = By.xpath(thereAreNoItemsInYourCart);
            wait.until(ExpectedConditions.presenceOfElementLocated(lThereAreNoItemsInYourCart));
            return true;
        }
    }

    public int getNumberOfDuckKind()
    {
        By lDeleteButton = By.xpath(deleteButton);
        List<WebElement> list = driver.findElements(lDeleteButton);
        return list.size();
    }

    public boolean deleteLastKindDuck()
    {
        try
        {
            By lDeleteButton = By.xpath(deleteButton);
            By lTableFlag = By.xpath(tableFlag);
            WebElement elementTab = driver.findElement(lTableFlag);
            driver.findElement(lDeleteButton).click();
            wait.until(ExpectedConditions.stalenessOf(elementTab));
            By lThereAreNoItemsInYourCart = By.xpath(thereAreNoItemsInYourCart);
            wait.until(ExpectedConditions.presenceOfElementLocated(lThereAreNoItemsInYourCart));
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }
}
