package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test(description = "Проверка корректного отображения кол-ва добавленых продуктов в корзине")
    public void productShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.removeFromCart("Sauce Labs Backpack");
        cartPage.clickCart();
        assertEquals(cartPage.getProductCount(), 2);
    }

    @Test(description = "Проверка кнопки RETURN -возвращение на список продуктов")
    public void continueShoppingShouldReturnTheProductsPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        navigationPage.clickCart();
        cartPage.continueShopping();
        assertEquals(productsPage.getTitle(), "PRODUCTS");
    }
}