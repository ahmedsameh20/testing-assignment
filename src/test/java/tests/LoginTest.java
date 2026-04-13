package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

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


            Thread.sleep(4000);


            String currentUrl = driver.getCurrentUrl();

            Assert.assertTrue(
                    currentUrl.contains("manager"),
                    "Login Failed - URL did not change"
            );

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test Failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}