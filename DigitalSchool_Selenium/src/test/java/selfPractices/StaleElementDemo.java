package selfPractices;



import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StaleElementDemo {

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
          //  System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // Navigate to demo page
            driver.get("https://demoqa.com/dynamic-properties");

            // Wait for the button to be enabled (after 5 seconds)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement button = driver.findElement(By.id("enableAfter"));

            // Simulate delay to allow DOM update
            Thread.sleep(6000);

            try {
                // ❌ This may throw StaleElementReferenceException
                button.click();
                System.out.println("Clicked using old reference.");
            } catch (StaleElementReferenceException e) {
                System.out.println("Caught StaleElementReferenceException. Re-locating element...");

                // ✅ Re-locate the element and try again
                button = driver.findElement(By.id("enableAfter"));
                button.click();
                System.out.println("Clicked after re-locating.");
            }

            // ✅ Alternative: Using explicit wait to avoid stale reference
            try {
                WebElement safeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
                safeButton.click();
                System.out.println("Clicked using explicit wait.");
            } catch (Exception e) {
                System.out.println("Failed to click using explicit wait: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Browser closed.");
            }
        }
    }
}
