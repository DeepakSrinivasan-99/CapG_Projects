package com.basics.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumDemoQA {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sdeepak1\\Desktop\\Deepak\\Digital_School_Training\\Selenium\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // Implicit wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the demo site
        driver.get("https://demoqa.com/text-box");

        // Step 3: Locators Practice
        driver.findElement(By.id("userName")).sendKeys("Deepak");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("deepak@example.com");
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Chennai");
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Tamil Nadu");

        
        
       //Thread.sleep(2000);

        
        // Step 4: WebElement Actions
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        submitButton.click();

        // Extract and validate text
        WebElement outputName = driver.findElement(By.id("name"));
        String nameText = outputName.getText();
        System.out.println("Output Name: " + nameText);

        boolean isDisplayed = outputName.isDisplayed();
        System.out.println("Is Name Displayed: " + isDisplayed);

        // Step 5: Explicit Wait
        WebElement outputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        System.out.println("Output Email: " + outputEmail.getText());
        // Close the browser
        //driver.quit();
    }
}