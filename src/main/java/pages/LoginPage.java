package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
        log.info(String.format("Type text: '%s' into username input on Login page", username));
        log.debug("Locator is: " + USERNAME_INPUT);
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        log.info(String.format("Type text: '%s' into password input on Login page", password));
        log.debug("Locator is: " + PASSWORD_INPUT);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        log.info("Click 'Login' button on Login page");
        log.debug("Locator is: " + LOGIN_BUTTON);
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
