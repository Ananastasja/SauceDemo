package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    @Description("Add product to cart")
    public void addProductToCartTest() {
        loginPage.openLoginPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Lab T-Shirt");
        cartPage.openCartPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Lab T-Shirt"), "15,99");
    }
}
