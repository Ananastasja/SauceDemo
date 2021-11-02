package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{

    private static final String ERROR_FIRST_NAME = "Error: First Name is required";
    private static final String ERROR_LAST_NAME = "Error: Last Name is required";
    private static final String ERROR_ZIP = "Error: Postal Code is required";

    @Test
    public void fillingFormWithValidCredentialsTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickCheckoutBtn();
        checkoutPage.fillingCheckoutForm("Anna", "Ivanova", "123456");
        overviewPage.findFinishBtn();
    }

    @Test
    public void fillingFormWithoutNameTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickCheckoutBtn();
        checkoutPage.fillingCheckoutForm("", "Ivanova", "123456");
        Assert.assertEquals(checkoutPage.getErrorText(), ERROR_FIRST_NAME);
    }

    @Test
    public void fillingFormWithoutSurnameTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickCheckoutBtn();
        checkoutPage.fillingCheckoutForm("Anna", "", "123456");
        Assert.assertEquals(checkoutPage.getErrorText(), ERROR_LAST_NAME);
    }

    @Test
    public void fillingFormWithoutZipTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickCheckoutBtn();
        checkoutPage.fillingCheckoutForm("Anna", "Ivanova", "");
        Assert.assertEquals(checkoutPage.getErrorText(), ERROR_ZIP);
    }
}
