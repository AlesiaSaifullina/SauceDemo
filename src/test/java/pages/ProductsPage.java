package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage{

    String productAddToCart = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    String productRemoveFromCart = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Remove']";
    String productName = "//div[text()='%s']";

    public static final By SORT_BUTTON = By.cssSelector(".product_sort_container");
    public static final By PRODUCT_PRICE = By.cssSelector(".inventory_details_price");
    public static final By PRODUCTS_PRICE = By.cssSelector(".inventory_item_price");
    public static final By PRODUCTS_NAME = By.cssSelector(".inventory_item_name");
    public static final By PAGE_TITLE = By.xpath("//span[text()='Products']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening product page")
    public void open() {
        driver.get(baseUrl + "/inventory.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE));
    }

    public void waitForLoading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE));
    }

    @Step("Add product to cart")
    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(productAddToCart, product))).click();
    }

    @Step("Remove product from cart")
    public void removeFromCart(String product) {
        driver.findElement(By.xpath(String.format(productRemoveFromCart, product))).click();
    }

    @Step("Opening product")
    public void openProduct(String product) {
        driver.findElement(By.xpath(String.format(productName, product))).click();
    }

    @Step("Sorting products")
    public void sort(String sorting) {
        new Select(driver.findElement(SORT_BUTTON)).selectByVisibleText(sorting);
    }

    @Step("Getting product price")
    public String getProductPrice() {
        return driver.findElement(PRODUCT_PRICE).getText();
    }

    @Step("Getting product name")
    public String getProductName(int index) {
        return driver.findElements(PRODUCTS_NAME).get(index).getText();
    }

    @Step("Getting product price")
    public String getProductPrice(int index) {
        return driver.findElements(PRODUCTS_PRICE).get(index).getText();
    }

    @Step("Getting page title")
    public String getTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }
}
