package pages;

import org.openqa.selenium.*;

public class LoginPage {
    WebDriver driver;

    By user = By.name("uid");
    By pass = By.name("password");
    By loginBtn = By.name("btnLogin");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String u, String p){
        driver.findElement(user).sendKeys(u);
        driver.findElement(pass).sendKeys(p);
        driver.findElement(loginBtn).click();
    }
}
