package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

 @Listeners(TestListener.class)

    public class BaseTest {

        WebDriver driver;
        LoginPage loginPage;
        ProductsPage productsPage;
        CartPage cartPage;
        BasePage basePage;
        NavigationPage navigationPage;
        CheckoutPage checkoutPage;
        CheckOutCompletePage checkOutCompletePage;
        CheckoutOverviewPage checkoutOverviewPage;
        public static final String USER = "standard_user";
        public static final String PASSWORD = "secret_sauce";

        @BeforeMethod
        public void setup(ITestContext testContext) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options =new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            testContext.setAttribute("driver", driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            loginPage = new LoginPage(driver);
            productsPage = new ProductsPage(driver);
            cartPage = new CartPage(driver);
            basePage = new BasePage(driver);
            navigationPage = new NavigationPage(driver);
        }

        @AfterMethod(alwaysRun = true, description = "Closing Browser")
        public void close() {
            if(driver != null){
            driver.quit();
            }
        }
 }