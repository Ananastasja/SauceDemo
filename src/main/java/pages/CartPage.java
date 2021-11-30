package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.get(CART_URL);
        return this;
    }

    public String getProductPrice(String productName) {
       return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public CartPage deleteProductFromCart(String productName) {
        driver.findElement(By.xpath(String.format(DELETE_PRODUCT_BTN, productName))).click();
        return this;
    }

    public String getQuantityOfProduct() {
        return driver.findElement(CART_QUANTITY).getText();
    }

    public CheckoutPage clickCheckoutBtn() {
        driver.findElement(CHECKOUT_BTN).click();
        return new CheckoutPage(driver);
    }
}
