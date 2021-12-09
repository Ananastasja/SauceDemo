package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private static final By CART_ICON_QUANTITY = By.xpath("//*[@class='shopping_cart_badge']");
    private static final String PRODUCTS_PAGE_IMG = "//*[text()='%s']/ancestor::*[@class='inventory_item']//img";
    private static final String PRODUCT_NAME = "//*[text()='%s']/ancestor::*[@class='inventory_item']";

    public ProductsPage addProductToCart(String productName) {
        waitForElementLocated(driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))), 10);
        log.info("Add product to cart with name: " + productName);
        log.debug("Locator is: " + ADD_PRODUCT_TO_CART_BUTTON);
        WebElement addProductToCartButton = driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName)));
        addProductToCartButton.click();
        return this;
    }

    public String getNumberOfItemsInCart() {
        return driver.findElement(CART_ICON_QUANTITY).getText();
    }

    public DetailsPage openDetailsPage(String productName) {
        log.info("Open product details page for: " + productName);
        log.debug("Locator is: " + PRODUCTS_PAGE_IMG);
        driver.findElement(By.xpath(String.format(PRODUCTS_PAGE_IMG, productName))).click();
        return new DetailsPage(driver);
    }

    public String getProductName(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).getText();
    }

    public String getProductPageUrl() {
        return getCurrentUrl();
    }
}
