import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkout() {
        String productLocator =
                "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";

        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("user-name")).submit();
        driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Backpack"))).click();
        driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Bolt T-Shirt"))).click();
        driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Fleece Jacket"))).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Alesia");
        driver.findElement(By.id("last-name")).sendKeys("Saifullina");
        driver.findElement(By.id("postal-code")).sendKeys("220085");
        driver.findElement(By.id("continue")).click();
        String totalPrice = driver.findElement(By.cssSelector(".summary_total_label")).getText();
        assertEquals(totalPrice.split(" ")[1], "$103.65");
        String item1 = driver.findElement(By.id("item_4_title_link")).getText();
        assertEquals(item1, "Sauce Labs Backpack","Product name doesn't match");
        String item2 = driver.findElement(By.id("item_5_title_link")).getText();
        assertEquals(item2, "Sauce Labs Fleece Jacket","Product name doesn't match");
        String item3 = driver.findElement(By.id("item_1_title_link")).getText();
        assertEquals(item3, "Sauce Labs Bolt T-Shirt","Product name doesn't match");
        driver.findElement(By.id("finish")).click();
        String successfulOrder = driver.findElement(By.className("complete-header")).getText();
        assertEquals(successfulOrder, "THANK YOU FOR YOUR ORDER","Order is not successful");
    }
}