package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
            driver = new ChromeDriver();

            testContext.setAttribute("driver", driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            loginPage = new LoginPage(driver);
            productsPage = new ProductsPage(driver);
            cartPage = new CartPage(driver);
            basePage = new BasePage(driver);
        }

        @AfterMethod(alwaysRun = true)
        public void close() {
            driver.quit();
        }
    }