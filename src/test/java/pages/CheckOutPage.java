package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class CheckOutPage extends BasePage {


    private final By FIRSTNAME_INPUT = By.id("first-name");
    private final By LASTNAME_INPUT = By.id("last-name");
    private final By ZIPCODE_INPUT = By.id("postal-code");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "checkout-step-one.html");

    }

    @Step("Fill the checkout line with the info")
    public void fillInCheckout(String firstName, String lastName, String zipCode) {

        driver.findElement(FIRSTNAME_INPUT).sendKeys(firstName);
        driver.findElement(LASTNAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIPCODE_INPUT).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();

    }

    @Step("Find error message")
    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}