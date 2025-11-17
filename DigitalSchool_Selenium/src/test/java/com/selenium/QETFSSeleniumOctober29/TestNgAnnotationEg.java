package com.selenium.QETFSSeleniumOctober29;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class TestNgAnnotationEg {
 
	WebDriver driver;
 
	@BeforeSuite
	public void beforeSuite() {
	System.out.println("Before Suite");
	}
 
	@BeforeTest
	public void beforeTest() {
	System.out.println("Before Test");
	}
 
	@BeforeClass
	public void beforeClass() {
	System.out.println("Before Class");
	driver = new ChromeDriver();
	}
 
	@BeforeMethod
	public void beforeMethod() {
	System.out.println("Before Method");
	driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
	}
 
	@Test
	
	public void testTextBox1() {
	System.out.println("Test Method");
	WebElement nameField = driver.findElement(By.id("fullname"));
	nameField.sendKeys("Deepti");
	Assert.assertEquals(nameField.getAttribute("value"), "Deepti");
	}
 
	@Test
	public void testTextBox2() {
	System.out.println("Test Method");
	WebElement nameField = driver.findElement(By.id("fullname"));
	nameField.sendKeys("Deepti");
	Assert.assertEquals(nameField.getAttribute("value"), "Deepti");
	}
 
 
 
	@AfterMethod
	public void afterMethod() {
	System.out.println("After Method");
	}
 
	@AfterClass
	public void afterClass() {
	System.out.println("After Class");
	driver.quit();
	}
 
	@AfterTest
	public void afterTest() {
	System.out.println("After Test");
	}
 
	@AfterSuite
	public void afterSuite() {
	System.out.println("After Suite");
	}
	
 
}