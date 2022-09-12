package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    public void addSeveralItemsToCart() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        // assertTrue(productsPage.isOpened());
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.clickCart();
        assertEquals(cartPage.getItemsQuantity(), "3", "Something went wrong");
    }

    @Test
    public void removeItemFromCart() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        // assertTrue(productsPage.isOpened());
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.clickCart();
        assertEquals(cartPage.getItemsQuantity(), "3", "Something went wrong");
        cartPage.removeFromCart();
        assertEquals(cartPage.getItemsQuantity(), "2", "Something went wrong");
    }
}