

package assignments;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Day4_Assignment1 {

    public static void main(String[] args) {
        // Set path to chromedriver if needed
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Step 1: Open the URL and maximize
            driver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");
            driver.manage().window().maximize();

            // Step 2: Locate Red checkbox
            WebElement redCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='red']")));

            // Step 2: Check if Red checkbox is enabled
            System.out.println("Red checkbox is enabled: " + redCheckbox.isEnabled());

            // Step 3: Check if Red checkbox is selected
            System.out.println("Red checkbox is selected: " + redCheckbox.isSelected());

            // Step 4: Locate Opera radio button
            WebElement operaRadio = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Opera']")));

            // Check if Opera radio button is selected
            System.out.println("Opera radio button is selected: " + operaRadio.isSelected());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}