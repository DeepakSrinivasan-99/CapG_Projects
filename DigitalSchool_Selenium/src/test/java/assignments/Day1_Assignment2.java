//Bing Link Extractor

package assignments;

  
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.openqa.selenium.StaleElementReferenceException;

	import java.time.Duration;
	import java.util.List;

	public class Day1_Assignment2 {
	    public static void main(String[] args) {
	      //  System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        WebDriver driver = new ChromeDriver();

	        try {
	            // Step 1: Load the URL
	            driver.get("https://www.bing.com/");

	            // Step 2: Maximize the window
	            driver.manage().window().maximize();

	            // Step 3: Wait for links to be present
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("a")));

	            // Step 4: Get all links
	            List<WebElement> links = driver.findElements(By.tagName("a"));
	            System.out.println("Total links found: " + links.size());

	            // Step 5: Traverse and print link texts with retry for stale elements
	            for (int i = 0; i < links.size(); i++) {
	                try {
	                    // Re-fetch the list to avoid stale references
	                    links = driver.findElements(By.tagName("a"));
	                    String text = links.get(i).getText().trim();
	                    if (!text.isEmpty()) {
	                        System.out.println(text);
	                    }
	                } catch (StaleElementReferenceException e) {
	                    System.out.println("Stale element at index " + i + ", skipping...");
	                }
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            driver.quit();
	        }
	    }
	}