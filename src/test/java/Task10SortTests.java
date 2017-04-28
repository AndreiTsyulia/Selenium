import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by Andrei_Tsyulia on 4/28/2017.
 */
public class Task10SortTests extends BaseTest
{
    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        driver.get("http://localhost/litecart/admin/");
        adminPanelLogin.doLogin("admin", "admin");
        adminPanel.isAdminPanel();
    }

    @Test
    public void checkCountryZoneSort()
    {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        geoZonesBlock.isGeoZonesBlock();
        int numberOfCountries = geoZonesBlock.numberOfCountries();
        for (int i = 1; i <= numberOfCountries; i++)
        {
            geoZonesBlock.clickItemMenu(i);
            System.out.println("На странице Edit Geo Zones " + editGeoZonesBlock.isEditGeoZonesBlock());
            softAssert.assertTrue(editGeoZonesBlock.checkSortZones());
            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
            geoZonesBlock.isGeoZonesBlock();
        }
        softAssert.assertAll();
    }
}
