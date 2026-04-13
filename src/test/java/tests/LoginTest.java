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
            driver.get("http://demo.guru99.com/V4/");

            LoginPage login = new LoginPage(driver);
            login.login("mngr559943", "AqajysY");


            Thread.sleep(3000);

            // ✅ Assertion
            String pageSource = driver.getPageSource();

            Assert.assertTrue(
                    pageSource.contains("Manger Id"),
                    "Login Failed - Text not found"
            );

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test Failed بسبب Exception");
        } finally {
            driver.quit();
        }
    }
}