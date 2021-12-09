package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By USERNAME_INPUT = By.xpath("//*[@id='user-name']");
    private static final By PASSWORD_INPUT = By.xpath("//*[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    private static final By ERROR_TEXT = By.xpath("//h3");
    private static final By BOT_LOGO = By.xpath("//*[@class='bot-column']");

    public LoginPage openLoginPage() {
        openUrl("");
        return this;
    }

    @Step("Login as username: '{username}' with password: '{password}'")
    public ProductsPage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_TEXT).getText();
    }

    public void waitForPageToOpen() {
        waitForElementLocated(BOT_LOGO, 10);
    }

    public void typeTextInIframe() {
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        driver.findElement(By.id("tinymce")).click();
        driver.switchTo().defaultContent();
    }
}
