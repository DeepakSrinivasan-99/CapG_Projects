package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day2_Assignment2 {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Accept cookies if prompted
            try {
                WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[text()='I agree' or text()='Accept all']")
                ));
                acceptBtn.click();
            } catch (Exception ignored) {}

            // Enter "Apple" in search box
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
            searchBox.sendKeys("Apple");

            // Wait for auto-suggestions and click the first one
            WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[@role='option']//span)[1]")
            ));
            firstSuggestion.click();

            // Wait for first search result link to be clickable
            WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//h3)[1]/ancestor::a")
            ));

            // Print result
            System.out.println("First result text: " + firstResult.getText());
            System.out.println("URL: " + firstResult.getAttribute("href"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           // driver.quit();
        }
    }
}