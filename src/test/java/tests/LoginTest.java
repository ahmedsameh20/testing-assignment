package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest {

    @Test
    public void testLogin(){

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://demo.guru99.com/V4/");

            LoginPage login = new LoginPage(driver);
            login.login("mngr559943", "AqajysY");

            // ✅ wait احترافي
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // استنى ظهور كلمة Manager Id
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//td[contains(text(),'Manger Id')]")
            ));

            // ✅ Assertion
            String text = driver.getPageSource();
            Assert.assertTrue(text.contains("Manger Id"));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Login Failed بسبب Exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}