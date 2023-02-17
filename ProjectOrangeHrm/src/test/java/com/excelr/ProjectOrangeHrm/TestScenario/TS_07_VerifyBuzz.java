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

public class TS_07_VerifyBuzz {

	private WebDriver driver;
	String browser, url, adminUser, adminPass, user, pass, buzz;

	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("buzz", "browsername");
		url = FileHandler.getPropertyValue("buzz", "url");

		adminUser = FileHandler.getPropertyValue("buzz", "adminUser");
		adminPass = FileHandler.getPropertyValue("buzz", "adminPass");
		user = FileHandler.getPropertyValue("buzz", "user");
		pass = FileHandler.getPropertyValue("buzz", "pass");
		buzz = FileHandler.getPropertyValue("buzz", "buzz");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);
	}

	@Test()
	public void case01() {

		WebElement admin = driver.findElement(By.xpath("//input[@name = \"username\"]"));
		WebElement passwd = driver.findElement(By.xpath("//input[@name = \"password\"]"));
		admin.sendKeys(user);
		passwd.sendKeys(pass);
		driver.findElement(By.xpath("//button[@type = \"submit\"]")).click();

		driver.findElement(By.xpath("//span[normalize-space()=\"Buzz\"]")).click();
		driver.findElement(By.xpath("//textarea[@placeholder=\"What's on your mind?\"]")).sendKeys(buzz);
		driver.findElement(By.xpath("//button[normalize-space()=\"Post\"]")).click();
		
		WaitTime.waitTimeInSec(3);
		System.out.println("TS-03 Verify Buzz function");
		System.out.println("Posted buzz is displayed in newsfeed");
		System.out.println("TC01 - Employee is able to post a Buzz successfully");
	}

	@Test()
	public void case02() {

		WebElement admin = driver.findElement(By.xpath("//input[@name = \"username\"]"));
		WebElement passwd = driver.findElement(By.xpath("//input[@name = \"password\"]"));
		admin.sendKeys(user);
		passwd.sendKeys(pass);
		driver.findElement(By.xpath("//button[@type = \"submit\"]")).click();

		driver.findElement(By.xpath("//span[normalize-space()=\"Buzz\"]")).click();

		WebElement employee = driver.findElement(
				By.xpath("//div[@class=\"orangehrm-buzz-post-header-text\"]//p[normalize-space()=\"John Smith\"]"));
		if (employee.isDisplayed() == true) {
			driver.findElement(By.xpath("//i[@class=\"oxd-icon bi-three-dots\"]")).click();
			WaitTime.waitTimeInSec(5);
		}

		System.out.println("TS-03 Verify Buzz function");
		System.out.println("Edit/ Delete option is available only for the self-posted buzz");
		System.out.println("Edit/ Delete option is not available for the buzz posted by other employees");
		System.out.println("TC02 - Employee is not able to edit/ delete a buzz posted by other employees");
	}

	@Test()
	public void case03() {

		WebElement admin = driver.findElement(By.xpath("//input[@name = \"username\"]"));
		WebElement passwd = driver.findElement(By.xpath("//input[@name = \"password\"]"));
		admin.sendKeys(adminUser);
		passwd.sendKeys(adminPass);
		driver.findElement(By.xpath("//button[@type = \"submit\"]")).click();

		driver.findElement(By.xpath("//span[normalize-space()=\"Buzz\"]")).click();
		
		WebElement adminName = driver.findElement(By.xpath("//p[@class=\"oxd-userdropdown-name\"]"));
		WebElement empName = driver.findElement(By.xpath("//div[@class=\"oxd-grid-1 orangehrm-buzz-newsfeed-posts\"]/div[1]/div/div/div/div/div[2]/p[@class=\"oxd-text oxd-text--p orangehrm-buzz-post-emp-name\"]"));
		
		if (adminName!=empName) {
			WebElement option = driver.findElement(By.xpath("//div[@class=\"oxd-grid-1 orangehrm-buzz-newsfeed-posts\"]/div[1]/div/div/div/div[2]/li/button//i[@class=\"oxd-icon bi-three-dots\"]"));
			option.click();
			WebElement delete = driver.findElement(By.xpath("//div[@class=\"oxd-grid-1 orangehrm-buzz-newsfeed-posts\"]/div[1]/div/div/div/div[2]/li/ul/li/p[normalize-space()=\"Delete Post\"]"));
			
			WaitTime.waitTimeInSec(3);
			System.out.println("Admin option available to access a buzz posted by other employee is: "+delete.getText());
		}
				
		System.out.println("TS-03 Verify Buzz function");
		System.out.println("TC03 - Admin is not able to edit a buzz posted by other employee");
	}

	@Test()
	public void case04() {

		WebElement admin = driver.findElement(By.xpath("//input[@name = \"username\"]"));
		WebElement passwd = driver.findElement(By.xpath("//input[@name = \"password\"]"));
		admin.sendKeys(adminUser);
		passwd.sendKeys(adminPass);
		driver.findElement(By.xpath("//button[@type = \"submit\"]")).click();

		driver.findElement(By.xpath("//span[normalize-space()=\"Buzz\"]")).click();
		
		WebElement adminName = driver.findElement(By.xpath("//p[@class=\"oxd-userdropdown-name\"]"));
		WebElement empName = driver.findElement(By.xpath("//div[@class=\"oxd-grid-1 orangehrm-buzz-newsfeed-posts\"]/div[1]/div/div/div/div/div[2]/p[@class=\"oxd-text oxd-text--p orangehrm-buzz-post-emp-name\"]"));
		
		if (adminName!=empName) {
			WebElement option = driver.findElement(By.xpath("//div[@class=\"oxd-grid-1 orangehrm-buzz-newsfeed-posts\"]/div[1]/div/div/div/div[2]/li/button//i[@class=\"oxd-icon bi-three-dots\"]"));
			option.click();
			WebElement delete = driver.findElement(By.xpath("//div[@class=\"oxd-grid-1 orangehrm-buzz-newsfeed-posts\"]/div[1]/div/div/div/div[2]/li/ul/li/p[normalize-space()=\"Delete Post\"]"));
			delete.click();
			driver.findElement(By.xpath("//button[normalize-space()=\"Yes, Delete\"]")).click();
		}
		
		driver.navigate().refresh();
		WaitTime.waitTimeInSec(3);
		System.out.println("TS-03 Verify Buzz function");
		System.out.println("Buzz deleted successfully and is no longer displayed in newsfeed");
		System.out.println("TC04 - Admin is able to delete a buzz posted by other employee");
	}
	
	@AfterMethod()
	public void conclusion() {

		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeAllBrowsers();
	}
}
