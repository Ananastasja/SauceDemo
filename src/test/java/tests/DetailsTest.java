package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DetailsTest extends BaseTest{

    @Test
    public void compareNameOnDetailsPageTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openDetailsPage("Sauce Labs Backpack");
        Assert.assertEquals(detailsPage.getDetailsProductName(), "Sauce Labs Backpack");
    }

    @Test
    public void comparePriceOnDetailsPageTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openDetailsPage("Sauce Labs Backpack");
        Assert.assertEquals(detailsPage.getDetailsProductPrice(), "$29.99");
    }
}
