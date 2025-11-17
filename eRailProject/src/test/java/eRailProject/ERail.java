package eRailProject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ERail {

	public  static void main(String[] args)
	{
		
		WebDriver driver = new ChromeDriver();
		//ChromeDriver driver1 = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		
		driver.get("https://erail.in/");
		
		Alert alert = driver.switchTo().alert();
		
		alert.dismiss();
		
		
		driver.findElement(By.id("txtStationFrom")).sendKeys("New Delhi");
		
		
		driver.findElement(By.id("txtStationTo")).sendKeys("Mumbai Central");
		
		driver.findElement(By.xpath("//input[contains(@title,'Select Departure date')]")).click();
		
		WebElement Quota = driver.findElement(By.id("cmbQuota"));
		
		Select dropdown = new Select(Quota);
		
		dropdown.selectByValue("TQ");
		
	}
}
