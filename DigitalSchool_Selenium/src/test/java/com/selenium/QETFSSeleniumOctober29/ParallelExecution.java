
package com.selenium.QETFSSeleniumOctober29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
 
public class ParallelExecution {
	@Test
	public void testTextBox() {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
	WebElement nameField = driver.findElement(By.id("fullname"));
	nameField.sendKeys("Deepti");
	Assert.assertEquals(nameField.getAttribute("value"), "Deepti");
	}
	
	@Test
	public void testCheckBox() {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.tutorialspoint.com/selenium/practice/check-box.php");
	WebElement checkbox = driver.findElement(By.id("c_bs_1"));
	checkbox.click();
	Assert.assertTrue(checkbox.isSelected());
	driver.quit();
	}
 
 
}