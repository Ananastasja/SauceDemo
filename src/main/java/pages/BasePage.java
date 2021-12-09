package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        log.debug("Initializing PageFactory");
        PageFactory.initElements(driver, this);
    }

    public static final String BASE_URL = "https://www.saucedemo.com";

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void openUrl(String certainUrl) {
        log.info("Open URL" + BASE_URL + certainUrl);
        driver.get(BASE_URL + certainUrl);
    }

    public void waitForElementLocated(By element, int timeout) {
        log.info("Wait for element: " + element + "with timeout: " + timeout);
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitForElementLocated(WebElement element, int timeout) {
        log.info("Wait for element: " + element + "with timeout: " + timeout);
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
    }
}
