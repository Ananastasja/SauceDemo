package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends CheckoutPage {
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    private static final By FINISH_BTN = By.xpath("//*[@data-test='finish']");

    public boolean isFinishBtnDisplayed() {
        waitForElementLocated(FINISH_BTN, 5);
        return driver.findElement(FINISH_BTN).isDisplayed();
    }
}
