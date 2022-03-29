package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class NavigationTest extends BaseTest {

    @Test(description = "Проверка корректного отображения продуктов в корзине")
    public void inCartShouldDisplayTheQuantityProductsAdded() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.removeFromCart("Sauce Labs Backpack");
        assertEquals(navigationPage.getProductsInCart(), "2");
    }
}