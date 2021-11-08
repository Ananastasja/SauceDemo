package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DetailsTest extends BaseTest{

    @Test
    public void compareNameOnDetailsPageTest() {
        loginPage.openLoginPage()
                .login("standard_user", "secret_sauce")
                .openDetailsPage("Sauce Labs Backpack");
        Assert.assertEquals(detailsPage.getDetailsProductName(), "Sauce Labs Backpack");
    }

    @Test
    public void comparePriceOnDetailsPageTest() {
        loginPage.openLoginPage()
                .login("standard_user", "secret_sauce")
                .openDetailsPage("Sauce Labs Backpack");
        Assert.assertEquals(detailsPage.getDetailsProductPrice(), "$29.99");
    }
}
