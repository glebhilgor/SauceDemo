package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class ProductsPage extends BasePage {

    private final By PAGE_TITLE = By.cssSelector(".title");
    private By FILTER_BUTTON = By.cssSelector(".product_sort_container");
    private By NEW_WINDOW = By.xpath("//span[contains(text(),'@saucelabs')]");
    private By NEW_WINDOWLINKEDIN = By.xpath("//h1[contains(text(),'Присоединитесь к LinkedIn')]");
    WebElement element;
    Select select;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    public boolean isOpened() {
        return waitForVisibility(PAGE_TITLE);
        //driver.findElement(PAGE_TITLE).isDisplayed();
    }

    public void addToCart(String product) {
        String locator = String.format("//*[text()='%s']//ancestor::div[@class='inventory_item']//button",
                product);

        driver.findElement(By.xpath(locator)).click();
    }

    public void selectButton() {
        element = driver.findElement(FILTER_BUTTON);
        select = new Select(element);
    }

    public void findAllElementsInDropdown() {
        List<WebElement> option = select.getOptions();
        int size = option.size();
        for (int i = 0; i < size; i++) {
            String options = option.get(i).getText();
            System.out.println(options);
        }
    }

    public void showText(String optionName) {
        select.selectByVisibleText(optionName);
    }

    public boolean isSelected() {
        return select.getFirstSelectedOption().isSelected();
    }

    public void mediaCheck() {
        Set<String> allWindowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<String>(allWindowHandles);
        System.out.println("No. of tabs: " + tabs.size());
        int size = tabs.size();
        for (int i = 0; i < size; i++) {
            String secondPageOpened = tabs.get(1);

            driver.switchTo().window(secondPageOpened);
        }
    }

    public boolean isOpen() {

        return driver.findElement(NEW_WINDOW).isDisplayed();
    }
    public boolean linkedinOpen() {
        return driver.findElement(NEW_WINDOWLINKEDIN).isDisplayed();
    }

}