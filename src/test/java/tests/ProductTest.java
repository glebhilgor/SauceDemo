package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;


public class ProductTest extends BaseTest {

    @Test(description = "Check if price of product is correct in the cart")
    // @Test(enabled = false)
    // (retryAnalyzer = Retry.class)
    public void productPriceShouldBeCorrect() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isOpened());
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        assertTrue(cartPage.isOpened());
        assertEquals(cartPage.getProductPrice("Sauce Labs Backpack"), "$29.99",
                "Price is not correct");
    }

    @Test
    public void elementsOfDropdownExist() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isOpened());
        productsPage.selectButton();
        productsPage.findAllElementsInDropdown();
    }

    @Test
    public void chooseOption1() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isOpened());
        productsPage.selectButton();
        productsPage.showText("Name (Z to A)");
        productsPage.selectButton();
        assertTrue(productsPage.isSelected(), "Option is not selected");
    }

    @Test
    public void chooseOption2() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isOpened());
        productsPage.selectButton();
        productsPage.showText("Name (A to Z)");
        productsPage.selectButton();
        assertTrue(productsPage.isSelected(), "Option is not selected");
    }

    @Test
    public void chooseOption3() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isOpened());
        productsPage.selectButton();
        productsPage.showText("Price (low to high)");
        productsPage.selectButton();
        assertTrue(productsPage.isSelected(), "Option is not selected");
    }

    @Test
    public void chooseOption4() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isOpened());
        productsPage.selectButton();
        productsPage.showText("Price (high to low)");
        productsPage.selectButton();
        assertTrue(productsPage.isSelected(), "Option is not selected");
    }

    @Test
    public void socialMediaButton() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isOpened());
        driver.findElement(By.linkText("Twitter")).click();
        productsPage.mediaCheck();
        productsPage.mediaCheck();
        assertTrue(productsPage.isOpen(), "Does not open the right window");
    }

    @Test
    public void socialMediaButton2() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isOpened());
        driver.findElement(By.linkText("Facebook")).click();
        productsPage.mediaCheck();
        assertTrue(productsPage.isOpen(), "Does not open the right window");
    }

    @Test
    public void socialMediaButton3() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isOpened());
        driver.findElement(By.linkText("LinkedIn")).click();
        productsPage.mediaCheck();
        assertTrue(productsPage.linkedinOpen(), "Does not open the right window");

    }
}