package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void productShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.removeFromCart("Sauce Labs Backpack");
        //navigationPage.clickCart();
       // assertEquals(cartPage.getProductCount(), 2);
    }
        //cartPage.open();
        //assertEquals(cartPage.getProductPrice("Sauce Labs Backpack"), "$9.99");
        //cartPage.getProductPrice();
    }