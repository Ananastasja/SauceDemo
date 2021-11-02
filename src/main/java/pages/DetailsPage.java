package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailsPage extends BasePage{
    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    private static final By DETAILS_PRODUCT_NAME = By.xpath("//*[@class='inventory_details_name large_size']");
    private static final By DETAILS_PRICE = By.xpath("//*[@class='inventory_details_price']");

    public String getDetailsProductName() {
        return driver.findElement(DETAILS_PRODUCT_NAME).getText();
    }

    public String getDetailsProductPrice() {
        return driver.findElement(DETAILS_PRICE).getText();
    }
}
