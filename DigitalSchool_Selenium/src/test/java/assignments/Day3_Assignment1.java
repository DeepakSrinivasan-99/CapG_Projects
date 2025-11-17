//Alert Handling Demo

package assignments;


import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class Day3_Assignment1 {
    public static void main(String[] args) {
        // Set path to chromedriver if not in system PATH
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Step 1: Open the URL
            driver.get("http://demo.automationtesting.in/Alerts.html");
            driver.manage().window().maximize();

            // Step 2: Click "Alert with OK" tab
            driver.findElement(By.xpath("//a[contains(text(),'Alert with OK')]")).click();

            // Step 3: Click button to display alert
            WebElement alertButton = driver.findElement(By.xpath("//button[@onclick='alertbox()']"));
            alertButton.click();

            // Step 4: Wait for alert and handle it
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert Text: " + alert.getText());
            alert.accept(); // or alert.dismiss()

            // Step 5: Click "Alert with OK & Cancel" tab
            driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();

            // Step 6: Click button to display confirm box
            WebElement confirmButton = driver.findElement(By.xpath("//button[@onclick='confirmbox()']"));
            confirmButton.click();

            // Step 7: Handle confirm alert
            wait.until(ExpectedConditions.alertIsPresent());
            Alert confirmAlert = driver.switchTo().alert();
            System.out.println("Confirm Alert Text: " + confirmAlert.getText());

            // Accept the confirm alert
            confirmAlert.accept();

            // Optionally, trigger again and dismiss
            confirmButton.click();
            wait.until(ExpectedConditions.alertIsPresent());
            confirmAlert = driver.switchTo().alert();
            confirmAlert.dismiss();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}