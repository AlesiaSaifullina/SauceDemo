package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage{

    String productLocator =
            "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    String productRemoveFromCart =
            "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Remove']";
    By sort = By.cssSelector(".product_sort_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + "/inventory.html");
    }

    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(productLocator, product))).click();
    }

    public void removeFromCart(String product) {
        driver.findElement(By.xpath(String.format(productRemoveFromCart, product))).click();
    }

    public void sort(String sorting) {
        new Select(driver.findElement(sort)).selectByVisibleText(sorting);
    }
}
