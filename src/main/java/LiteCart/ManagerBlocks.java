package LiteCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by Andrei_Tsyulia on 5/19/2017.
 */
public class ManagerBlocks
{
    public WebDriver driver;
    public MainPage mainPage;
    public ProductBlock productBlock;
    public CartBlock cartBlock;
    int ducksIn;

    /**
     * Конструктор
     *
     * @param driver
     */
    public ManagerBlocks(WebDriver driver) {
        this.driver = driver;
        mainPage = initElements(new MainPage(this));
        productBlock = initElements(new ProductBlock(this));
        cartBlock = initElements(new CartBlock(this));
    }

    /**
     * Метод инициализирующий страницы (block)
     *
     * @param block
     */
    private <T extends BaseBlock> T initElements(T block) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), block);
        return block;
    }

    /**
     * @return the driver
     */
    public WebDriver getWebDriver() {
        return driver;
    }


    public void addDuckFromProductBlockToCart()
    {
        goToMainPage();
        mainPage.goToProductBlock();
        addOneDuck();
    }

    public void addDuckFromPopularBlockToCart()
    {
        goToMainPage();
        mainPage.clickPopularProducts();
        mainPage.goToProductBlockPopular();
        addOneDuck();
    }

    public void addDuckFromLatestBlockToCart()
    {
        goToMainPage();
        mainPage.clickLatestProducts();
        mainPage.goToProductBlockLatest();
        addOneDuck();
    }

    private void goToMainPage()
    {
        driver.get("http://localhost/litecart");
        mainPage.isMainPage();
    }

    private void addOneDuck()
    {
        productBlock.isProductBlock();
        productBlock.selectSize();
        ducksIn = productBlock.getDucksInCart();
        productBlock.addToCart();
    }

    public boolean checkIncreasingDucksInCart()
    {
        return productBlock.isIncreasingDucks(ducksIn);
    }

    public boolean deleteOneKindDuck()
    {
        return cartBlock.deleteOneKindDuck();
    }

    public void goToCart()
    {
        productBlock.goToCart();
        cartBlock.isCartBlock();
    }

    public int getNumberOfDuckKind()
    {
        return cartBlock.getNumberOfDuckKind();
    }

    public boolean deleteLastKindDuck()
    {
        return cartBlock.deleteLastKindDuck();
    }
}
