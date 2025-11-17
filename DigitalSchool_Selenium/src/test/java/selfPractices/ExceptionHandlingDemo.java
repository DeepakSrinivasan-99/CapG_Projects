package selfPractices;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExceptionHandlingDemo {

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            // Setup WebDriver
           // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();

            // Maximize window and navigate
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/buttons");

            // Explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Try to find and click buttons
            try {
                WebElement doubleClickBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("doubleClickBtn")));
                Actions actions = new Actions(driver);
                actions.doubleClick(doubleClickBtn).perform();
                System.out.println("Double click performed.");
            } catch (NoSuchElementException e) {
                System.out.println("Double click button not found: " + e.getMessage());
            } catch (ElementNotInteractableException e) {
                System.out.println("Double click button not interactable.");
            }

            // Right click
            try {
                WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
                new Actions(driver).contextClick(rightClickBtn).perform();
                System.out.println("Right click performed.");
            } catch (Exception e) {
                System.out.println("Right click failed: " + e.getMessage());
            }

            // Single click
            safeClick(driver, By.xpath("//button[text()='Click Me']"));

        } catch (WebDriverException e) {
            System.out.println("WebDriver error: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Browser closed.");
            }
        }
    }

    // Utility method for safe clicking
    public static void safeClick(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            element.click();
            System.out.println("Safe click successful.");
        } catch (NoSuchElementException e) {
            System.out.println("Element not found for safe click.");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is stale.");
        } catch (Exception e) {
            System.out.println("Unexpected error during safe click: " + e.getMessage());
        }
    }
}
