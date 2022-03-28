package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.clickCart();
        cartPage.checkout();
        cartPage.fillInCheckoutInfo("Alesia", "Saifullina", "220085");
        assertEquals(cartPage.getTotalPrice(), "$32.39");
        cartPage.finish();
        assertEquals(cartPage.getCompleteTitle(),"CHECKOUT: COMPLETE!");
    }
}