package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By CHECKOUT_BUTTON = By.id("checkout");
    private final By CART_ITEM = By.cssSelector(".inventory_item_name");
    public String totalQuantity;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return waitForVisibility(CHECKOUT_BUTTON);
    }

@Step("Looking for the product")
    public String getProductPrice(String product) {
        String locator = String.format("//div[text()='%s']//ancestor::div[@class='cart_item']/" +
                        "/div[@class='inventory_item_price']",
                product);

        return driver.findElement(By.xpath(locator)).getText();
    }

    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void removeFromCart() {
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
    }

    public String getItemsQuantity() {

        int arraySize = driver.findElements(CART_ITEM).size();
        return totalQuantity = Integer.toString(arraySize);
    }
}