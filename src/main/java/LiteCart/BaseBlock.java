package LiteCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrei_Tsyulia on 5/21/2017.
 */
public abstract class BaseBlock
{
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ManagerBlocks managerBlocks;

    // Конструктор
    public BaseBlock(ManagerBlocks managerBlocks)
    {
        this.managerBlocks = managerBlocks;
        driver = managerBlocks.getWebDriver();
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    // Конструктор
    public BaseBlock(WebDriver driver)
    {
        this.managerBlocks = null;
        this.driver =driver;
        wait = new WebDriverWait(driver, 5);
    }
}
