import org.testng.annotations.Test;

/**
 * Created by Andrei_Tsyulia on 5/9/2017.
 */
public class Task19PageObjectTests extends BaseTests
{

    @Test
    public void addToCartDeleteFromCartTest()
    {
        liteCartShop.addDuckFromProductBlockToCart();
        softAssert.assertTrue(liteCartShop.checkIncreasingDucksInCart());

        liteCartShop.addDuckFromPopularBlockToCart();
        softAssert.assertTrue(liteCartShop.checkIncreasingDucksInCart());

        liteCartShop.addDuckFromLatestBlockToCart();
        softAssert.assertTrue(liteCartShop.checkIncreasingDucksInCart());

        liteCartShop.goToCart();
        for (int i = 0; i < liteCartShop.getNumberOfDuckKind() - 1; i++)
        {
            softAssert.assertTrue(liteCartShop.deleteOneKindDuck());
        }
        softAssert.assertTrue(liteCartShop.deleteLastKindDuck());

        softAssert.assertAll();
    }
}
