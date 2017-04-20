package Vtb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrei_Tsyulia on 4/11/2017.
 */
public class BlockHeader
{
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String MainMenuTemplate = "//table[@class='nav']//span[contains(text(),'%s')]";
    private String logotip = "//a[@class='logo-pic']/img";
    //'Частным', 'Среднему', 'Финансовым', 'Инвестиционные', 'Акционерам', 'ВТБ'
    private String internetbank = "//div[@class='internetbank']/a";


    public BlockHeader(WebDriver driver)
    {
        this.driver=driver;
        wait =new WebDriverWait(driver, 10);
    }


    public void pressLogotip()
    {
        By lLogotip = By.xpath(logotip);
        driver.findElement(lLogotip).click();
    }

    public void chooseMainMenu(String item)
    {
        By lMainMenu = By.xpath(String.format(MainMenuTemplate, item));
        driver.findElement(lMainMenu).click();
    }
}
