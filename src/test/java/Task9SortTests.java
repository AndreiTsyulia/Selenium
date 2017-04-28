import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

/**
 * Created by Andrei_Tsyulia on 4/28/2017.
 */
public class Task9SortTests extends BaseTest
{
    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        driver.get("http://localhost/litecart/admin/");
        adminPanelLogin.doLogin("admin", "admin");
        adminPanel.isAdminPanel();
    }

    @Test
    public void checkCountrySort()
    {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        countriesBlock.isCountriesBlock();
        Assert.assertTrue(countriesBlock.checkSortCountries());
    }

    @Test
    public void checkCountryZoneSort()
    {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        countriesBlock.isCountriesBlock();
        ArrayList<Integer> countriesWithZone = countriesBlock.getCountriesWithZone();
        for (int i = 0; i < countriesWithZone.size(); i++)
        {
            countriesBlock.goToCountry(countriesWithZone.get(i));
            editCountriesBlock.isEditCountriesBlock();
            softAssert.assertTrue(editCountriesBlock.checkSortZones());
            driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            countriesBlock.isCountriesBlock();
        }
        softAssert.assertAll();
    }
}
