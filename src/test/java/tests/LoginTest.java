package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final String ERROR_TEXT_USERNAME = "Epic sadface: Username is required";
    private static final String ERROR_TEXT_PASSWORD = "Epic sadface: Password is required";
    private static final String ERROR_TEXT_INVALID_CREDENTIALS = "Epic sadface: Username and password do not match any user in this service";
    private static final String PRODUCTS_URL = "https://www.saucedemo.com/inventory.html";

    @Test
    public void loginWithUsernameTest() {
        loginPage.openLoginPage()
                .login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessage(), ERROR_TEXT_PASSWORD);
    }

    @Test
    public void loginWithPasswordTest() {
        loginPage.openLoginPage()
                .login("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), ERROR_TEXT_USERNAME);
    }

    @Test
    public void loginWithEmptyFieldsTest() {
        loginPage.openLoginPage()
                .login("", "");
        Assert.assertEquals(loginPage.getErrorMessage(), ERROR_TEXT_USERNAME);
    }

    @Test
    public void loginWithInvalidCredentialsTest() {
        loginPage.openLoginPage()
                .login("hello", "123");
        Assert.assertEquals(loginPage.getErrorMessage(), ERROR_TEXT_INVALID_CREDENTIALS);
    }

    @Test
    public void loginWithValidCredentialsTest() {
        loginPage.openLoginPage()
                .login(System.getenv("username"), System.getenv("password"));
        Assert.assertEquals(productsPage.getProductPageUrl(), PRODUCTS_URL);
    }
}
