package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {

    @Test
    public void testLogin(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        driver.get("http://demo.guru99.com/V4/");

        LoginPage login = new LoginPage(driver);
        login.login("mngr559943","AqajysY");

        Assert.assertTrue(driver.getPageSource().contains("Manger Id"));

        driver.quit();
    }
}
