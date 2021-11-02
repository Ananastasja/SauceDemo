package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final String ERROR_TEXT_USERNAME = "Epic sadface: Username is required";
    private static final String ERROR_TEXT_PASSWORD = "Epic sadface: Password is required";
    private static final String ERROR_TEXT_INVALID_CREDENTIALS = "Epic sadface: Username and password do not match any user in this service";

    @Test
    public void loginWithUsernameTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessage(), ERROR_TEXT_PASSWORD);
    }

    @Test
    public void loginWithPasswordTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), ERROR_TEXT_USERNAME);
    }

    @Test
    public void loginWithEmptyFieldsTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getErrorMessage(), ERROR_TEXT_USERNAME);
    }

    @Test
    public void loginWithInvalidCredentialsTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("hello", "123");
        Assert.assertEquals(loginPage.getErrorMessage(), ERROR_TEXT_INVALID_CREDENTIALS);
    }

    @Test
    public void loginWithValidCredentialsTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
    }
}
