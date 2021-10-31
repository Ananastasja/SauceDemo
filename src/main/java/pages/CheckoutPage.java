package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private static final By CHECKOUT_FIRST_NAME = By.xpath("//*[@data-test='firstName']");
    private static final By CHECKOUT_LAST_NAME = By.xpath("//*[@data-test='lastName']");
    private static final By CHECKOUT_ZIP = By.xpath("//*[@data-test='postalCode']");
    private static final By CONTINUE_BTN = By.xpath("//*[@data-test='continue']");
    private static final By ERROR_TEXT_CHECKOUT = By.xpath("//h3");

    public void fillingCheckoutForm(String name, String surname, String zip) {
        driver.findElement(CHECKOUT_FIRST_NAME).sendKeys(name);
        driver.findElement(CHECKOUT_LAST_NAME).sendKeys(surname);
        driver.findElement(CHECKOUT_ZIP).sendKeys(zip);
        driver.findElement(CONTINUE_BTN).click();
    }

    public String getErrorText() {
       return driver.findElement(ERROR_TEXT_CHECKOUT).getText();
    }
}
