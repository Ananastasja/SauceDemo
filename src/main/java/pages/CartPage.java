package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_PRICE = "//*[text()='%s']/ancestor::*[@class='cart_item']//*[@class='inventory_item_price']";
    private static final String DELETE_PRODUCT_BTN = "//*[text()='%s']/ancestor::*[@class='cart_item']//button";
    private static final By CART_QUANTITY = By.xpath("//*[@class='cart_quantity']");
    private static final By CHECKOUT_BTN = By.xpath("//*[@class='btn btn_action btn_medium checkout_button']");
    private static final String CART_URL = BASE_URL + "/cart.html";

    @Step("Opening Cart Page")
    public CartPage openCartPage() {
        log.info("Open Cart page" + CART_URL);
        driver.get(CART_URL);
        return this;
    }

    public String getProductPrice(String productName) {
        log.info("Get price for product: " + productName);
        String productPrice = driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
        log.info("Price is " + productPrice);
        return productPrice;
    }

    public CartPage deleteProductFromCart(String productName) {
        log.info("Delete product with name: " + productName);
        log.debug("Locator is: " + DELETE_PRODUCT_BTN);
        driver.findElement(By.xpath(String.format(DELETE_PRODUCT_BTN, productName))).click();
        return this;
    }

    public String getQuantityOfProduct() {
        return driver.findElement(CART_QUANTITY).getText();
    }

    public CheckoutPage clickCheckoutBtn() {
        log.info("Click checkout button on Cart page");
        log.debug("Locator is: " + CHECKOUT_BTN);
        driver.findElement(CHECKOUT_BTN).click();
        return new CheckoutPage(driver);
    }
}
