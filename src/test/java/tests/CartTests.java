package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    @Description("Add product to cart")
    public void addProductToCartTest() {
        productSteps.loginAndAddProductToCart("standard_user", "secret_sauce", "Sauce Labs Bolt T-Shirt");
        cartPage.openCartPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }
}
