package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void addProductToCartTest(String username, String password, String productName, String expectedPrice) {
        loginPage.openLoginPage()
                .login(username, password)
                .addProductToCart(productName);
        cartPage.openCartPage();
        Assert.assertEquals(cartPage.getProductPrice(productName), expectedPrice);
    }
}
