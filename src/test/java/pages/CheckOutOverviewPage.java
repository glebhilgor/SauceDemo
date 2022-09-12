package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutOverviewPage extends BasePage {

    private final By PAGE_TITLE = By.xpath("//span[text()='Checkout: Overview']");
    private By FINISH_BUTTON = By.id("finish");
    private By ITEM_TOTAL = By.cssSelector(".summary_subtotal_label");
    private By TOTAL_COST = By.cssSelector(".summary_total_label");
    private By TAX = By.cssSelector(".summary_tax_label");


    public CheckOutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return driver.findElement(PAGE_TITLE).isDisplayed();
    }

    public void clickFinish() {
        driver.findElement(FINISH_BUTTON).click();
    }
    public String getItemCost() {
        return driver.findElement(ITEM_TOTAL).getText();
    }
    public String getTax() {
        return driver.findElement(TAX).getText();
    }
    public String getTotal() {
        return driver.findElement(TOTAL_COST).getText();
    }
}