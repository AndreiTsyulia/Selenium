import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import Helper.Product;
import LiteCart.AdminPanel;
import LiteCart.AdminPanelLogin;
import LiteCart.CatalogGeneralBlock;
import LiteCart.CatalogInformationBlock;
import LiteCart.CatalogPricesBlock;

/**
 * Created by Andrei_Tsyulia on 5/2/2017.
 */
public class Task12NewProductTests
{
    protected WebDriver driver;
    protected AdminPanelLogin adminPanelLogin;
    protected AdminPanel adminPanel;
    protected CatalogGeneralBlock catalogGeneralBlock;
    protected CatalogInformationBlock catalogInformationBlock;
    protected CatalogPricesBlock catalogPricesBlock;
    private Product product;

    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\VTB\\Drivers\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        ((RemoteWebDriver) driver).setLogLevel(Level.FINEST);
        driver.manage().window().maximize();
        adminPanelLogin = new AdminPanelLogin(driver);
        adminPanel = new AdminPanel(driver);
        catalogGeneralBlock = new CatalogGeneralBlock(driver);
        catalogInformationBlock = new CatalogInformationBlock(driver);
        catalogPricesBlock = new CatalogPricesBlock(driver);
        String[] massive = {"[Root]", "Rubber Ducks"};
        product = new Product(true, massive, "Root", "Unisex", "2017-05-05", "2018-05-05", "code", "Ducks Family", "DF00543",
            "GTIN00543", "TARIC00543", "30", "pcs", "0.3", "kg", "20", "20", "30", "cm", "3-5 days", "Sold out", "ducks.jpg",
            "ACME Corp.", "-- Select --", "Duck", "Duck", "Ducks famely", "Instructions", "Ducks Family", "Buy duck",
            "30", "US Dollars", "-- Select --", "30", "33");
        System.out.println(product.toString());
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod()
    {
        driver.get("http://localhost/litecart/admin/");
        adminPanelLogin.doLogin("admin", "admin");
        adminPanel.isAdminPanel();
    }

    @Test
    public void addNewProduct()
    {
        adminPanel.goToCatalog();
        adminPanel.pressAddNewProduct();
        catalogGeneralBlock.isCatalogGeneralBlock();
        catalogGeneralBlock.fillStatus(product.isStatus());
        catalogGeneralBlock.fillDefaultCategory(product.getDefaultCategory());
        catalogGeneralBlock.fillProductGroups(product.getProductGroups());
        catalogGeneralBlock.fillDateValidFrom(product.getDateValidFrom());
        catalogGeneralBlock.fillDateValidTo(product.getDateValidTo());
        catalogGeneralBlock.fillCode(product.getCode());
        catalogGeneralBlock.fillName(product.getName());
        catalogGeneralBlock.fillSku(product.getSku());
        catalogGeneralBlock.fillGtin(product.getGtin());
        catalogGeneralBlock.fillTaric(product.getTaric());
        catalogGeneralBlock.fillCategories(product.getCategories());
        catalogGeneralBlock.fillQuantity(product.getQuantity());
        catalogGeneralBlock.fillQuantityMeasure(product.getQuantityMeasure());
        catalogGeneralBlock.fillWeight(product.getWeight());
        catalogGeneralBlock.fillWeightMeasure(product.getWeightMeasure());
        catalogGeneralBlock.fillWidth(product.getWidth());
        catalogGeneralBlock.fillHeight(product.getHeight());
        catalogGeneralBlock.fillLength(product.getLength());
        catalogGeneralBlock.fillSizeMeasure(product.getSizeMeasure());
        catalogGeneralBlock.fillDeliveryStatus(product.getDeliveryStatus());
        catalogGeneralBlock.fillSoldOutStatus(product.getSoldOutStatus());
        catalogGeneralBlock.fillPathOfImage(product.getPathOfImage());
        catalogGeneralBlock.goToInformationBlock();
        catalogInformationBlock.isInformationBlock();
        catalogInformationBlock.fillManufacturer(product.getManufacturer());
        catalogInformationBlock.fillSupplier(product.getSupplier());
        catalogInformationBlock.fillKeywords(product.getKeywords());
        catalogInformationBlock.fillShortDescription(product.getShortDescription());
        catalogInformationBlock.fillDescription(product.getDescription());
        catalogInformationBlock.fillAttributes(product.getAttributes());
        catalogInformationBlock.fillHeadTitle(product.getHeadTitle());
        catalogInformationBlock.fillMetaDescription(product.getMetaDescription());
        catalogInformationBlock.goToPricesBlock();
        catalogPricesBlock.isPricesBlock();
        catalogPricesBlock.fillPurchasePrice(product.getPurchasePrice());
        catalogPricesBlock.fillVal(product.getVal());
        catalogPricesBlock.fillTaxClass(product.getTaxClass());
        catalogPricesBlock.fillPriceUSD(product.getPriceUSD());
        catalogPricesBlock.fillPriceEUR(product.getPriceEUR());
        catalogPricesBlock.savePricesInformation();
        adminPanel.goToCatalog();
        Assert.assertTrue(adminPanel.isDuckPresent(product.getName()));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass()
    {
        driver.quit();
    }
}
