package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {


    @Test
    public void sucessfulLoginTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isOpened(), "Titile of the page is not displayed");

    }

    @Test(dataProvider = "loginData")
    public void negativeLogin(String userName, String password, String error) {
        loginPage.open();
        loginPage.login(userName, password);
        assertEquals(loginPage.getError(),
                error,
                "Wrong error message show");

    }

    @Test
    public void emptyUserName() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getError(),
                "Epic sadface: username is required",
                "Wrong error message shown");
    }

    @Test
    public void emptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getError(),
                "Epic sadface: Password is required",
                "Wrong error message shown");
    }
    @Test
    public void InsertLoginUsingCapsLock() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("STANDARD_USER", "secret_sauce");
        assertEquals(loginPage.getError(),
                "Epic sadface: Username and password do not match any user in this service",
                "Wrong error message shown");
    }
    @Test
    public void InsertPasswordUsingCapsLock() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "SECRET_SAUCE");
        assertEquals(loginPage.getError(),
                "Epic sadface: Username and password do not match any user in this service",
                "Wrong error message shown");

    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secred_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }
}
