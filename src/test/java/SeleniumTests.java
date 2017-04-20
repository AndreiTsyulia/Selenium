import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Vtb.BlockHeader;

/**
 * Created by Andrei_Tsyulia on 4/20/2017.
 */
public class SeleniumTests
{

    protected WebDriver driver;
    BlockHeader blockHeader;

    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver","D:\\VTB\\Drivers\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        blockHeader = new BlockHeader(driver);
        driver.get("http://www.vtb.ru/");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass()
    {
        driver.close();
    }

    @Test
    public void test1()
    {
        blockHeader.chooseMainMenu("Финансовым");
        blockHeader.pressLogotip();
        Assert.assertEquals("http://www.vtb.ru/", driver.getCurrentUrl());
    }

    @Test
    public void test2()
    {
        blockHeader.chooseMainMenu("Частным");
        blockHeader.pressLogotip();
        Assert.assertEquals("http://www.vtb.ru/", driver.getCurrentUrl());
    }

}
