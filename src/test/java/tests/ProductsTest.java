package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest{

    @Test
    public void addingTwoElementsIntoCartTest() {
        loginPage.openLoginPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack")
                .addProductToCart("Sauce Labs Bike Light");
        Assert.assertEquals(productsPage.getNumberOfItemsInCart(), "2");
    }

    @Test
    public void deleteProductsFromCartTest() {
        loginPage.openLoginPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack")
                .addProductToCart("Sauce Labs Bike Light");
        cartPage.openCartPage()
                .deleteProductFromCart("Sauce Labs Backpack");
        Assert.assertEquals(productsPage.getNumberOfItemsInCart(), "1");
    }

    @Test
    public void compareCartQuantityAndCartIconNumberTest() {
        loginPage.openLoginPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack");
        cartPage.openCartPage();
        Assert.assertEquals(productsPage.getNumberOfItemsInCart(), cartPage.getQuantityOfProduct());
    }
}
