

package com.selenium.QETFSSeleniumOctober29;

import java.util.HashSet;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
 
public class Assertions {
	
	@Test
	public void verifyTextBox() {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
 
	WebElement nameField = driver.findElement(By.id("fullname"));
	nameField.sendKeys("Deepti");
 
	String enteredText = nameField.getAttribute("value");
	Assert.assertEquals(enteredText, "Deepti");
	
	Assert.assertTrue(enteredText.equals("Deepti"));
	System.out.println("Test passed for valid data");
	
	Assert.assertFalse(enteredText.equals("Harish"));
	
	System.out.println("Test Passed for wrong data");
	
	
	HashSet<Integer> h1 = new HashSet<>();
	h1.add(10);
	
	HashSet<Integer> h2 = new HashSet<Integer>();
	h2.add(20);
	
	Assert.assertEquals(h1, h1, "Objects are not equal");
	
	driver.quit();
	
	
	}
 
 
}
 