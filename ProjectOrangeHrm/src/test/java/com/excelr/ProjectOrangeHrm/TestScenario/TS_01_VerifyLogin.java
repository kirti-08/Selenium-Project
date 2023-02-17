package com.excelr.ProjectOrangeHrm.TestScenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excelr.ProjectOrangeHrm.Common.BrowserFactory;
import com.excelr.ProjectOrangeHrm.Common.FileHandler;
import com.excelr.ProjectOrangeHrm.Common.WaitTime;

public class TS_01_VerifyLogin {

	private WebDriver driver;
	String browser, url, validUser, validPass, invalidUser, invalidPass;
	
	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("login", "browsername");
		url = FileHandler.getPropertyValue("login", "url");
		
		validUser = FileHandler.getPropertyValue("login", "validuser");
		validPass = FileHandler.getPropertyValue("login", "validpass");
		invalidUser = FileHandler.getPropertyValue("login", "invaliduser");
		invalidPass = FileHandler.getPropertyValue("login", "invalidpass");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);

		System.out.println("Browsername - " + browser);
		System.out.println("Url - " + url);
	}

	@Test()
	public void case01() {
						
		WebElement username = driver.findElement(By.xpath("//input[@name = \"username\"]"));
		WebElement pass = driver.findElement(By.xpath("//input[@name = \"password\"]"));
		
		username.sendKeys(validUser);
		pass.sendKeys(validPass);
		driver.findElement(By.xpath("//button[@type = \"submit\"]")).click();
		
		System.out.println("Valid username - " + validUser);
		System.out.println("Valid password - " + validPass);
		System.out.println("TC01 - User is able to login with valid username & password");
	}

	@Test
	public void case02() {
		
		WebElement username = driver.findElement(By.xpath("//input[@name = \"username\"]"));
		WebElement pass = driver.findElement(By.xpath("//input[@name = \"password\"]"));
		username.sendKeys(invalidUser);
		pass.sendKeys(validPass);
		driver.findElement(By.xpath("//button[@type = \"submit\"]")).click();
		
		System.out.println("Invalid username - " + invalidUser);
		System.out.println("Valid username - " + validUser);
		System.out.println("Valid password - " + validPass);
						
		System.out.println("Defect 01 - username is not case sensitive");
		System.out.println("TC02 - User is able to login with invalid username");
	}

	@Test
	public void case03() {
		
		WebElement username = driver.findElement(By.xpath("//input[@name = \"username\"]"));
		WebElement pass = driver.findElement(By.xpath("//input[@name = \"password\"]"));
		username.sendKeys(invalidUser);
		pass.sendKeys(invalidPass);
		driver.findElement(By.xpath("//button[@type = \"submit\"]")).click();
		
		System.out.println("Invalid username - " + invalidUser);
		System.out.println("Invalid password - " + invalidPass);
		System.out.println("TC03 - User is not able to login with invalid username and invalid password");
	}

	@Test
	public void case04() {
		
		WebElement username = driver.findElement(By.xpath("//input[@name = \"username\"]"));
		WebElement pass = driver.findElement(By.xpath("//input[@name = \"password\"]"));
		username.sendKeys(validUser);
		pass.sendKeys(invalidPass);
		driver.findElement(By.xpath("//button[@type = \"submit\"]")).click();
		
		System.out.println("Valid username - " + validUser);
		System.out.println("Invalid password - " + invalidPass);
		System.out.println("TC04 - User is not able to login with valid username and invalid password");
	}
	
	@AfterMethod()
	public void conclusion() {

		WaitTime.waitTimeInSec(5);
		BrowserFactory.closeAllBrowsers();
	}
}
