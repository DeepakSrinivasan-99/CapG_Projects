
//Bing Total no of links

package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import java.time.Duration;

	public class Day1_Assignment1 {
	    public static void main(String[] args) {
	        // Set path to your ChromeDriver
	      //  System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Step 1: Load the URL
	            driver.get("https://www.bing.com/");
	         

	            // Step 2: Maximize the window
	            driver.manage().window().maximize();
	            
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


	            // Step 3: Click on the "Images" link
	            WebElement imagesLink =wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Images")));
	            imagesLink.click();

	            // Step 4: Use Explicit Wait to wait for images to be visible
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("img")));

	            // Step 5: Find all image elements
	            List<WebElement> images = driver.findElements(By.tagName("img"));

	            // Step 6: Print the number of images
	            System.out.println("Number of images on the page: " + images.size());
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Step 7: Close the browser
	            driver.quit();
	        }
	    }
	}
