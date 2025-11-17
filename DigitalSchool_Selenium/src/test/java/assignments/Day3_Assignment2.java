//ButtonClickDemoQA
package assignments;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Day3_Assignment2 {

	    public static void main(String[] args) {
	        // Set path to chromedriver if needed
	        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        WebDriver driver = new ChromeDriver();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	        Actions actions = new Actions(driver);

	        try {
	            // Step 1: Open the URL and maximize
	            driver.get("https://demoqa.com/buttons");
	            driver.manage().window().maximize();
	            

	            // Step 2: Double Click
	            WebElement doubleClickBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("doubleClickBtn")));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", doubleClickBtn);

	            actions.doubleClick(doubleClickBtn).perform();

	            WebElement doubleClickMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));
	            System.out.println("Double Click Message: " + doubleClickMsg.getText());

	            // Step 3: Right Click
	            WebElement rightClickBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("rightClickBtn")));
	            actions.contextClick(rightClickBtn).perform();

	            WebElement rightClickMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rightClickMessage")));
	            System.out.println("Right Click Message: " + rightClickMsg.getText());

	            // Step 4: Single Click (Dynamic Button)
	            WebElement clickBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click Me']")));

	            // Scroll into view to avoid click interception
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickBtn);

	           clickBtn.click();

	            WebElement clickMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicClickMessage")));
	            System.out.println("Single Click Message: " + clickMsg.getText());

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            //driver.quit();
	        }
	    }
	}