import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Andrei_Tsyulia on 4/20/2017.
 */
public class SeleniumTests extends BaseTest
{

    @Test
    public void test1()
    {
        driver.get("http://www.vtb.ru/");
        blockHeader.chooseMainMenu("Финансовым");
        blockHeader.pressLogotip();
        Assert.assertEquals("http://www.vtb.ru/", driver.getCurrentUrl());
    }

    @Test
    public void test2()
    {
        driver.get("http://www.vtb.ru/");
        blockHeader.chooseMainMenu("Частным");
        blockHeader.pressLogotip();
        Assert.assertEquals("http://www.vtb.ru/", driver.getCurrentUrl());
    }

}
