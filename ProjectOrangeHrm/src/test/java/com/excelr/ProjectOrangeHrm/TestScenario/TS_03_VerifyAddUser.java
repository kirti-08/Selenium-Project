package com.excelr.ProjectOrangeHrm.TestScenario;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	String browser, url, adminUser, adminPass, firstName, midName, lastName, empId, newFName, newLName, userLogin,
			userPass, username, password, loginButton, tabPIM, addEmployee, first, last, middle, employeeId,
			createLogin, newLogin, newPass, confirmPass, submit, employeeList, nameHint, search, errorEmpId, errorName,
			existingId;

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
		username = FileHandler.getPropertyValue("addUser", "username");
		password = FileHandler.getPropertyValue("addUser", "password");
		loginButton = FileHandler.getPropertyValue("addUser", "loginButton");
		tabPIM = FileHandler.getPropertyValue("addUser", "tabPIM");
		addEmployee = FileHandler.getPropertyValue("addUser", "addEmployee");
		first = FileHandler.getPropertyValue("addUser", "first");
		last = FileHandler.getPropertyValue("addUser", "last");
		middle = FileHandler.getPropertyValue("addUser", "middle");
		employeeId = FileHandler.getPropertyValue("addUser", "employeeId");
		createLogin = FileHandler.getPropertyValue("addUser", "createLogin");
		newLogin = FileHandler.getPropertyValue("addUser", "newLogin");
		newPass = FileHandler.getPropertyValue("addUser", "newPass");
		confirmPass = FileHandler.getPropertyValue("addUser", "confirmPass");
		submit = FileHandler.getPropertyValue("addUser", "submit");
		employeeList = FileHandler.getPropertyValue("addUser", "employeeList");
		nameHint = FileHandler.getPropertyValue("addUser", "nameHint");
		search = FileHandler.getPropertyValue("addUser", "search");
		errorEmpId = FileHandler.getPropertyValue("addUser", "errorEmpId");
		errorName = FileHandler.getPropertyValue("addUser", "errorName");
		existingId = FileHandler.getPropertyValue("addUser", "existingId");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);

		WebElement loginName = driver.findElement(By.xpath(username));
		WebElement loginPass = driver.findElement(By.xpath(password));

		loginName.sendKeys(adminUser);
		loginPass.sendKeys(adminPass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(tabPIM)).click();
	}

	@Test()
	public void case01_AddNewEmployee() {

		driver.findElement(By.xpath(addEmployee)).click();
		WebElement fName = driver.findElement(By.xpath(first));
		fName.sendKeys(firstName);
		WebElement lName = driver.findElement(By.xpath(last));
		lName.sendKeys(lastName);
		WebElement mName = driver.findElement(By.xpath(middle));
		mName.sendKeys(midName);

		WebElement eId = driver.findElement(By.xpath(employeeId));
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
			WaitTime.waitTimeInSec(1);
			eId.sendKeys(empId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		WebElement login = driver.findElement(By.xpath(createLogin));
		login.click();
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(newLogin)).sendKeys(userLogin);
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(newPass)).sendKeys(userPass);
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(confirmPass)).sendKeys(userPass);
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(submit)).click();
		WaitTime.waitTimeInSec(1);
	}

	@Test()
	public void case02_NewEmployeeAvailableInEmployeeList() {

		driver.findElement(By.xpath(employeeList)).click();
		WebElement empName = driver.findElement(By.xpath(nameHint));
		empName.sendKeys(firstName);

		Actions action = new Actions(driver);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(search)).click();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		WaitTime.waitTimeInSec(2);
	}

	@Test()
	public void case03_NoRepeatEmployeeId() {

		driver.findElement(By.xpath(employeeList)).click();
		WebElement presentId = driver.findElement(By.xpath(existingId));
		String allotedId = presentId.getText();

		driver.findElement(By.xpath(addEmployee)).click();
		WebElement newFirst = driver.findElement(By.xpath(first));
		newFirst.sendKeys(newFName);
		WebElement newLast = driver.findElement(By.xpath(last));
		newLast.sendKeys(newLName);

		WebElement newId = driver.findElement(By.xpath(employeeId));
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
			newId.sendKeys(allotedId);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		WebElement error = driver.findElement(By.xpath(errorEmpId));
		if (error.isDisplayed() == true) {
			WaitTime.waitTimeInSec(3);
		}
	}

	@Test()
	public void case04_AddNewUserFirstLastNameMandatory() {

		driver.findElement(By.xpath(addEmployee)).click();
		WebElement fName = driver.findElement(By.xpath(first));
		fName.sendKeys(firstName);
		driver.findElement(By.xpath(submit)).click();

		WebElement error = driver.findElement(By.xpath(errorName));
		if (error.isDisplayed() == true) {
			WaitTime.waitTimeInSec(3);
		}
	}

	@AfterMethod()
	public void conclusion() {

		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeAllBrowsers();
	}
}
