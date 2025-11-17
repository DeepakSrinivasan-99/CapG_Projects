package assignments;

  
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class Day2_Assignment3 {
	public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://demo.automationtesting.in/Register.html");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Basic Info
            driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Deepak");
            driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("S");
            driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("Chennai, India");
            driver.findElement(By.xpath("//input[@type='email']")).sendKeys("deepak@example.com");
            driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9876543210");

            // Gender
            driver.findElement(By.xpath("//input[@value='Male']")).click();

            // Hobbies
            driver.findElement(By.id("checkbox1")).click(); // Cricket
            driver.findElement(By.id("checkbox2")).click(); // Movies

            // Languages
            WebElement languageDropdown = driver.findElement(By.id("msdd"));
            languageDropdown.click();

            // Wait for language options to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'ui-corner-all')]")));

            // Select languages
            List<WebElement> languageOptions = driver.findElements(By.xpath("//ul[contains(@class,'ui-corner-all')]/li/a"));
            for (WebElement lang : languageOptions) {
                String text = lang.getText();
                if (text.equals("English") || text.equals("Tamil")) {
                    lang.click();
                }
            }

            // Click outside to close dropdown
            driver.findElement(By.xpath("//label[text()='Languages']")).click();

            // Skills
            Select skills = new Select(driver.findElement(By.id("Skills")));
            skills.selectByVisibleText("Java");

            // Country
           // Select country = new Select(driver.findElement(By.id("countries")));
            //country.selectByVisibleText("India");

            // Select Country (searchable dropdown)
            driver.findElement(By.xpath("//span[@role='combobox']")).click();
            WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
            searchBox.sendKeys("India");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'India')]"))).click();

            // DOB
            Select year = new Select(driver.findElement(By.id("yearbox")));
            year.selectByVisibleText("1990");

            Select month = new Select(driver.findElement(By.xpath("//select[@placeholder='Month']")));
            month.selectByVisibleText("May");

            Select day = new Select(driver.findElement(By.id("daybox")));
            day.selectByVisibleText("10");

            // Password
            driver.findElement(By.id("firstpassword")).sendKeys("Test@123");
            driver.findElement(By.id("secondpassword")).sendKeys("Test@123");

            // Submit
            driver.findElement(By.id("submitbtn")).click();

            //System.out.println("Form submitted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //driver.quit();
        }
    }
}