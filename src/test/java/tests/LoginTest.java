package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @DataProvider(name = "Входящие данные для негативных тестов на логин")
    public Object[][] loginData() {
        return new Object[][]{
                {"test", "", "Epic sadface: Password is required"},
                {"", "test", "Epic sadface: Username is required"},
                {"locked_out_user", PASSWORD, "Epic sadface: Sorry, this user has been locked out."},
        };
    }


    @Test(dataProvider = "Входящие данные для негативных тестов на логин")
    public void passwordShouldBeRequired(String user, String password, String error) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getError(), error,"Сообщение об ошибке при логине не корректное");
    }

    @Test
    public void userNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("", "test");
        assertEquals(loginPage.getError(), "Epic sadface: Username is required");
    }

    @Test
    public void standardUserShouldBeLoggedIn() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        assertEquals(productsPage.getTitle(), "PRODUCTS");
    }

    @Test
    public void lockedOutUserShouldBeLockedOut() {
        loginPage.open();
        loginPage.login("locked_out_user", PASSWORD);
        assertEquals(loginPage.getError(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void unregisteredUserShouldNotLogin() {
        loginPage.open();
        loginPage.login("Unregistered", PASSWORD);
        assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void unregisteredPasswordShouldNotLogin() {
        loginPage.open();
        loginPage.login(USER, "unregistered");
        assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void problemUserShouldBeLoggedIn() {
        loginPage.open();
        loginPage.login("problem_user", PASSWORD);
        assertEquals(productsPage.getTitle(), "PRODUCTS");
    }

    @Test
    public void performanceGlitchUserShouldNotLogin() {
        loginPage.open();
        loginPage.login("performance_glitch_user", PASSWORD);
        assertEquals(productsPage.getTitle(), "PRODUCTS");
    }
}