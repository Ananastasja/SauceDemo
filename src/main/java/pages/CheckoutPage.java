package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private static final By CHECKOUT_FIRST_NAME = By.xpath("//*[@data-test='firstName']");
    private static final By CHECKOUT_LAST_NAME = By.xpath("//*[@data-test='lastName']");
    private static final By CHECKOUT_ZIP = By.xpath("//*[@data-test='postalCode']");
    private static final By CONTINUE_BTN = By.xpath("//*[@data-test='continue']");
    private static final By ERROR_TEXT_CHECKOUT = By.xpath("//h3");

    public OverviewPage fillingCheckoutForm(String name, String surname, String zip) {
        waitForElementLocated(CONTINUE_BTN, 5);
        log.info(String.format("Type text: '%s' into first name field on Checkout page", name));
        log.debug("Locator is: " + CHECKOUT_FIRST_NAME);
        driver.findElement(CHECKOUT_FIRST_NAME).sendKeys(name);
        log.info(String.format("Type text: '%s' into last name field on Checkout page", surname));
        log.debug("Locator is: " + CHECKOUT_LAST_NAME);
        driver.findElement(CHECKOUT_LAST_NAME).sendKeys(surname);
        log.info(String.format("Type text: '%s' into zip field on Checkout page", zip));
        log.debug("Locator is: " + CHECKOUT_ZIP);
        driver.findElement(CHECKOUT_ZIP).sendKeys(zip);
        log.info("Click 'Continue' button on Checkout page");
        log.debug("Locator is: " + CONTINUE_BTN);
        driver.findElement(CONTINUE_BTN).click();
        return new OverviewPage(driver);
    }

    public String getErrorText() {
       return driver.findElement(ERROR_TEXT_CHECKOUT).getText();
    }
}
