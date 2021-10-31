package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private static final By CART_ICON_QUANTITY = By.xpath("//*[@class='shopping_cart_badge']");
    private static final String PRODUCTS_PAGE_IMG = "//*[text()='%s']/ancestor::*[@class='inventory_item']//img";
    private static final String PRODUCT_NAME = "//*[text()='%s']/ancestor::*[@class='inventory_item']";

    public void addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
    }

    public String getNumberOfItemsInCart() {
        return driver.findElement(CART_ICON_QUANTITY).getText();
    }

    public void openDetailsPage(String productName) {
        driver.findElement(By.xpath(String.format(PRODUCTS_PAGE_IMG, productName))).click();
    }

    public String getProductName(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).getText();
    }
}
