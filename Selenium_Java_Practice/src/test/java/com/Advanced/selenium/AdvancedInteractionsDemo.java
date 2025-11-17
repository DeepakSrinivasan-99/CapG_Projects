package com.Advanced.selenium;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class AdvancedInteractionsDemo {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sdeepak1\\Desktop\\Deepak\\Digital_School_Training\\Selenium\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        try {
            driver.manage().window().maximize();

            // ✅ Switch to frame and read text
            driver.get("https://demoqa.com/frames");
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame1"));
            WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));
            System.out.println("Frame Text: " + heading.getText());
            driver.switchTo().defaultContent();

            // ✅ Handle alert
            driver.get("https://demoqa.com/alerts");
            WebElement alertButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("alertButton")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alertButton);
            wait.until(ExpectedConditions.elementToBeClickable(alertButton)).click();
            
            
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert Text: " + alert.getText());
            alert.accept();

            // ✅ Drag and drop
            driver.get("https://demoqa.com/droppable");
            WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
            WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppable")));
            actions.dragAndDrop(source, target).perform();

            // Optional: Verify drop success
            WebElement dropText = target.findElement(By.tagName("p"));
            System.out.println("Drop Result: " + dropText.getText());

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            //driver.quit();
        }
    }
}