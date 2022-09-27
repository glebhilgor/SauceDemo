//package pages;
//
//import io.qameta.allure.Step;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class LoginPageFactory extends BasePage {
//    @FindBy(id = "user-name")
//    WebElement userNameInput;
//    @FindBy(id = "password")
//    WebElement passwordInput;
//    @FindBy(id = "login-button")
//    WebElement loginButton;
//    @FindBy(id = "[data-test=error]")
//    WebElement errorMessage;
//
//
//    public LoginPageFactory(WebDriver driver) {
//        super(driver);
//        PageFactory.initElements(driver, this);
//    }
//
//    @Step("Opening Login page")
//    public void open() {
//        driver.get(BASE_URL);
//    }
//
//    @Step("Login by '{userName}' using password '{password}'")
//    public void login(String userName, String password) {
//        userNameInput.sendKeys(userName);
//        passwordInput.sendKeys(password);
//        loginButton.click();
//    }
//
//    @Step("Getting error message")
//    public String getError() {
//        return errorMessage.getText();
//    }
//}
