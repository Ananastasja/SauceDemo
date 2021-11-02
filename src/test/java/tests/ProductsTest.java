package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest{

    @Test
    public void addingTwoElementsIntoCartTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.addProductToCart("Sauce Labs Bike Light");
        Assert.assertEquals(productsPage.getNumberOfItemsInCart(), "2");
    }

    @Test
    public void deleteProductsFromCartTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.addProductToCart("Sauce Labs Bike Light");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.deleteProductFromCart("Sauce Labs Backpack");
        Assert.assertEquals(productsPage.getNumberOfItemsInCart(), "1");
    }

    @Test
    public void compareCartQuantityAndCartIconNumberTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        Assert.assertEquals(productsPage.getNumberOfItemsInCart(), cartPage.getQuantityOfProduct());
    }
}
