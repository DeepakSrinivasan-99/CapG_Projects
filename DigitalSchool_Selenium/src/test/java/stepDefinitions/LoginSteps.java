
package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import io.cucumber.java.en.*;

public class LoginSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("user launches the browser and opens SauceDemo login page")
    public void launchBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user clicks on the login button")
    public void clickLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user should be navigated to the home page")
    public void verifyHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        String title = driver.findElement(By.className("title")).getText();
        System.out.println("Home Page Title: " + title);
        assert title.equals("Products");
    }

    @And("user logs out from the application")
    public void logout() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();
        driver.quit();
    }
}