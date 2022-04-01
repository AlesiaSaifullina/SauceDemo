package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{


    public static final By USER_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Description("Перейти на страницу авторизации")
    @Step("Opening login page")
    public void open() {
        driver.get(baseUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }
    @Description("Совершить авторизацию")
    @Step("Log in by user {user} using password {password}")
    public void login(String user, String password) {
        driver.findElement(USER_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }
    @Description("Ошибка при авторизации")
    @Step("Getting error message")
    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}