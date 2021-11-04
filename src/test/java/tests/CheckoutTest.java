package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{

    private static final String ERROR_FIRST_NAME = "Error: First Name is required";
    private static final String ERROR_LAST_NAME = "Error: Last Name is required";
    private static final String ERROR_ZIP = "Error: Postal Code is required";

    @Test
    public void fillingFormWithValidCredentialsTest() {
        loginPage.openLoginPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openCartPage()
                .clickCheckoutBtn()
                .fillingCheckoutForm("Anna", "Ivanova", "123456");
        Assert.assertTrue(overviewPage.isFinishBtnDisplayed());
    }

    @Test
    public void fillingFormWithoutNameTest() {
        loginPage.openLoginPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openCartPage()
                .clickCheckoutBtn()
                .fillingCheckoutForm("", "Ivanova", "123456");
        Assert.assertEquals(checkoutPage.getErrorText(), ERROR_FIRST_NAME);
    }

    @Test
    public void fillingFormWithoutSurnameTest() {
        loginPage.openLoginPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openCartPage()
                .clickCheckoutBtn()
                .fillingCheckoutForm("Anna", "", "123456");
        Assert.assertEquals(checkoutPage.getErrorText(), ERROR_LAST_NAME);
    }

    @Test
    public void fillingFormWithoutZipTest() {
        loginPage.openLoginPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openCartPage()
                .clickCheckoutBtn()
                .fillingCheckoutForm("Anna", "Ivanova", "");
        Assert.assertEquals(checkoutPage.getErrorText(), ERROR_ZIP);
    }
}
