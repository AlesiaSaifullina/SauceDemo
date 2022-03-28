package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By TOTAL_PRICE = By.cssSelector(".summary_total_label");
    public static final By PRODUCTS_IN_CART = By.cssSelector(".cart_item");
    public static final By CONTINUE_BUTTON = By.id("continue-shopping");
    public static final By SHOPPING_CART = By.id("shopping_cart_container");
    public static final By FINISH_BUTTON = By.id("finish");
    public static final By COMPLETE_INFO = By.cssSelector(".title");
    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By ZIP_CODE_INPUT = By.id("postal-code");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + "cart.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_BUTTON));
        //waitForPageLoaded();
    }

    public void clickCart() {
        driver.findElement(SHOPPING_CART).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Your Cart']")));
    }

    public void finish() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public void checkout() {
        driver.findElement(CHECKOUT_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cancel")));
    }

    public void fillInCheckoutInfo(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_CODE_INPUT).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getTotalPrice() {
        return driver.findElement(TOTAL_PRICE).getText().split(" ")[1];
    }

    public void continueShopping (){
        driver.findElement(CONTINUE_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));
    }

    public String getCompleteTitle() {
       return driver.findElement(COMPLETE_INFO).getText();
    }

    public int getProductCount() {
        return driver.findElements(PRODUCTS_IN_CART).size();
    }
}
