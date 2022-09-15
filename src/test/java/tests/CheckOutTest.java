package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckOutTest extends BaseTest {

    @Test
    public void checkOutShouldBeCorrect() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        checkOutPage.fillInCheckout("Rada", "Radan", "12345");
        assertTrue(checkOutOverviewPage.isOpened(), "The page failed to open");
        checkOutOverviewPage.clickFinish();
        assertTrue(checkOutFinalPage.isOpenRight(), "Checkout failed");

    }

    @Test
    public void getTotalShouldBeCorrect() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        checkOutPage.fillInCheckout("Rada", "Radan", "12345");
        assertTrue(checkOutOverviewPage.isOpened(), "The page failed to open");
        assertEquals(checkOutOverviewPage.getItemCost(), "Item total: $29.99", "Item total error");
        assertEquals(checkOutOverviewPage.getTax(), "Tax: $2.40", "Tax error");
        assertEquals(checkOutOverviewPage.getTotal(), "Total: $32.39", "Total error");
        checkOutOverviewPage.clickFinish();
        assertTrue(checkOutFinalPage.isOpenRight(), "Checkout failed");

    }

    @Test
    public void checkOutEmptyFields() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        checkOutPage.fillInCheckout("", "", "");
        assertEquals(checkOutPage.getError(), "Error: First Name is required", "Error while checking out");

    }
    @Test
    public void checkOutEmptyLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        checkOutPage.fillInCheckout("Rada", "", "");
        assertEquals(checkOutPage.getError(), "Error: Last Name is required", "Error while checking out");

    }
    @Test
    public void checkOutEmptyZipCode() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        checkOutPage.fillInCheckout("Rada", "Radan", "");
        assertEquals(checkOutPage.getError(), "Error: Postal Code is required", "Error while checking out");

    }
    @Test
    public void checkOutSpaceInFields() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        checkOutPage.fillInCheckout(" ", " ", " ");
        assertEquals(checkOutPage.getError(), "Error: First Name is required", "Error while checking out");

    }
}