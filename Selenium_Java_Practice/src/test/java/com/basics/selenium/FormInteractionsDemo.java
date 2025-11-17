package com.basics.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
//HI
public class FormInteractionsDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sdeepak1\\Desktop\\Deepak\\Digital_School_Training\\Selenium\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

        // Fill text fields
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys("Deepak");
        driver.findElement(By.id("lastName")).sendKeys("S");
        driver.findElement(By.id("userEmail")).sendKeys("deepak@example.com");

        // Scroll and click gender radio button using JS
        WebElement genderRadio = driver.findElement(By.xpath("//label[text()='Male']"));
        js.executeScript("arguments[0].scrollIntoView(true);", genderRadio);
        js.executeScript("arguments[0].click();", genderRadio);

        // Select hobbies checkboxes
        WebElement sportsCheckbox = driver.findElement(By.xpath("//label[text()='Sports']"));
        js.executeScript("arguments[0].click();", sportsCheckbox);

        WebElement readingCheckbox = driver.findElement(By.xpath("//label[text()='Reading']"));
        js.executeScript("arguments[0].click();", readingCheckbox);

        // Interact with State dropdown (React-based)
        WebElement stateInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-3-input")));
        stateInput.sendKeys("NCR");
        stateInput.sendKeys(Keys.ENTER);

        // Interact with City dropdown
        WebElement cityInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-4-input")));
        cityInput.sendKeys("Delhi");
        cityInput.sendKeys(Keys.ENTER);

        // Scroll and click Submit button
        WebElement submitBtn = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        js.executeScript("arguments[0].click();", submitBtn);

        //driver.quit();
    }
}
