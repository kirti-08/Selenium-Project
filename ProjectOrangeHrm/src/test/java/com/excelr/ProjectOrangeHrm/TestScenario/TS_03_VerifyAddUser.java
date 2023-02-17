package com.excelr.ProjectOrangeHrm.TestScenario;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excelr.ProjectOrangeHrm.Common.BrowserFactory;
import com.excelr.ProjectOrangeHrm.Common.FileHandler;
import com.excelr.ProjectOrangeHrm.Common.WaitTime;

public class TS_03_VerifyAddUser {

	private WebDriver driver;
	String browser, url, adminUser, adminPass, firstName, midName, lastName, empId, newFName, newLName, userLogin, userPass;

	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("addUser", "browsername");
		url = FileHandler.getPropertyValue("addUser", "url");

		adminUser = FileHandler.getPropertyValue("addUser", "adminUser");
		adminPass = FileHandler.getPropertyValue("addUser", "adminPass");
		firstName = FileHandler.getPropertyValue("addUser", "firstName");
		lastName = FileHandler.getPropertyValue("addUser", "lastName");
		midName = FileHandler.getPropertyValue("addUser", "midName");
		empId = FileHandler.getPropertyValue("addUser", "empId");
		userLogin = FileHandler.getPropertyValue("addUser", "userLogin");
		userPass = FileHandler.getPropertyValue("addUser", "userPass");
		newFName = FileHandler.getPropertyValue("addUser", "newFName");
		newLName = FileHandler.getPropertyValue("addUser", "newLName");

	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);

		WebElement loginName = driver.findElement(By.xpath("//input[@name = \"username\"]"));
		WebElement loginPass = driver.findElement(By.xpath("//input[@name = \"password\"]"));

		loginName.sendKeys(adminUser);
		loginPass.sendKeys(adminPass);
		driver.findElement(By.xpath("//button[@type = \"submit\"]")).click();

		driver.findElement(By.xpath("//span[normalize-space()=\"PIM\"]")).click();
	}

	@Test()
	public void case01() {

		driver.findElement(By.xpath("//a[normalize-space()=\"Add Employee\"]")).click();
		WebElement fName = driver.findElement(By.xpath("//input[@name=\"firstName\"]"));
		fName.sendKeys(firstName);
		WebElement lName = driver.findElement(By.xpath("//input[@name=\"lastName\"]"));
		lName.sendKeys(lastName);
		WebElement mName = driver.findElement(By.xpath("//input[@name=\"middleName\"]"));
		mName.sendKeys(midName);

		WebElement eId = driver.findElement(By.xpath(
				"//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input[@class=\"oxd-input oxd-input--active\"]"));
		eId.click();
		new Actions(driver);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			WaitTime.waitTimeInSec(2);
			eId.sendKeys(empId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("First Name: " + firstName);
		System.out.println("Middle Name: " + midName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Employee Id: " + empId);

		WebElement login = driver.findElement(By.xpath("//span[@class=\"oxd-switch-input oxd-switch-input--active --label-right\"]"));
		login.click();
		driver.findElement(By.xpath("//div[@class=\"orangehrm-employee-container\"]/div[2]/div[3]/div/div/div/div[2]/input[@class=\"oxd-input oxd-input--active\"]")).sendKeys(userLogin);
		driver.findElement(By.xpath("//div[@class=\"orangehrm-employee-container\"]/div[2]/div[4]/div/div[1]/div[1]/div[2]/input[@type=\"password\"]")).sendKeys(userPass);
		driver.findElement(By.xpath("//div[@class=\"orangehrm-employee-container\"]/div[2]/div[4]/div/div[2]/div/div[2]/input[@type=\"password\"]")).sendKeys(userPass);
		
		System.out.println("New user login details are - ");
		System.out.println("Username: " + userLogin +"      "+ " Password: " + userPass);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		

		System.out.println("TS-03 Add New User");
		System.out.println("TC01 - Admin is able to add new user or new employee details successfully");
	}

	@Test()
	public void case02() {

		driver.findElement(By.xpath("//a[normalize-space()=\"Employee List\"]")).click();
		WebElement empName = driver.findElement(By.xpath(
				"//div[@class=\"oxd-layout-container\"]/div/div/div/div[2]/form/div/div/div[1]/div/div[2]/div/div/input[@placeholder=\"Type for hints...\"]"));
		empName.sendKeys(firstName);

		new Actions(driver);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		System.out.println("Find New Employee: " + firstName + " " + lastName);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		System.out.println("TS-03 Add New User");
		System.out.println("TC02 - New added employee details are displayed in the employee list");
	}

	@Test()
	public void case03() {

		driver.findElement(By.xpath("//a[normalize-space()=\"Add Employee\"]")).click();
		WebElement newFirst = driver.findElement(By.xpath("//input[@name=\"firstName\"]"));
		newFirst.sendKeys(newFName);
		WebElement newLast = driver.findElement(By.xpath("//input[@name=\"lastName\"]"));
		newLast.sendKeys(newLName);

		WebElement newId = driver.findElement(By.xpath(
				"//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input[@class=\"oxd-input oxd-input--active\"]"));
		newId.click();
		new Actions(driver);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			newId.sendKeys(empId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("New First Name: " + newFName);
		System.out.println("New Last Name: " + newLName);
		System.out.println("Already alloted Employee Id: " + empId);

		WebElement error = driver.findElement(By.xpath("//span[normalize-space()=\"Employee Id already exists\"]"));
		System.out.println("Error Message is displayed: Employee Id already exists " + error.isDisplayed());

		System.out.println("TS-03 Add New User");
		System.out.println("TC03 - New employee cannot be added on already existing employee id");
	}

	@Test()
	public void case04() {

		driver.findElement(By.xpath("//a[normalize-space()=\"Add Employee\"]")).click();
		WebElement fName = driver.findElement(By.xpath("//input[@name=\"firstName\"]"));
		fName.sendKeys(firstName);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		WebElement error = driver.findElement(By.xpath("//span[normalize-space()=\"Required\"]"));
		System.out.println("Error Message is displayed: Required " + error.isDisplayed());

		System.out.println("TS-03 Add New User");
		System.out.println("TC04 - New employee will be added only if both first and last name are provided");
	}

	@AfterMethod()
	public void conclusion() {

		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeAllBrowsers();
	}
}
