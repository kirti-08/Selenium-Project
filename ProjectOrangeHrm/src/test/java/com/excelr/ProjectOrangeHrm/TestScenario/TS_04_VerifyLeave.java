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

public class TS_04_VerifyLeave {

	private WebDriver driver;
	String browser, url, user, pass, adminUser, adminPass, empName, entitle, fromDate, toDate;
	String username, password, loginButton, leaveTab, entitlements, addEntitlement, leaveType, employeeName,
			entitlementInput, submit, leaveFrom, leaveTo, leaveStatus, apply, applyTypeDrop, applyFrom, applyTo,
			applyFromBox, applyToBox, applyType, submitLeave, myLeave, reports, reportType, reportForLeave,
			reportForLocation, generate;

	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("leave", "browsername");
		url = FileHandler.getPropertyValue("leave", "url");

		user = FileHandler.getPropertyValue("leave", "user");
		pass = FileHandler.getPropertyValue("leave", "pass");
		adminUser = FileHandler.getPropertyValue("leave", "adminUser");
		adminPass = FileHandler.getPropertyValue("leave", "adminPass");
		empName = FileHandler.getPropertyValue("leave", "empName");
		entitle = FileHandler.getPropertyValue("leave", "entitlement");
		fromDate = FileHandler.getPropertyValue("leave", "from");
		toDate = FileHandler.getPropertyValue("leave", "to");
		username = FileHandler.getPropertyValue("leave", "username");
		password = FileHandler.getPropertyValue("leave", "password");
		entitlements = FileHandler.getPropertyValue("leave", "entitlements");
		addEntitlement = FileHandler.getPropertyValue("leave", "addEntitlement");
		leaveTab = FileHandler.getPropertyValue("leave", "leaveTab");
		loginButton = FileHandler.getPropertyValue("leave", "loginButton");
		leaveType = FileHandler.getPropertyValue("leave", "leaveType");
		employeeName = FileHandler.getPropertyValue("leave", "employeeName");
		entitlementInput = FileHandler.getPropertyValue("leave", "entitlementInput");
		submit = FileHandler.getPropertyValue("leave", "submit");
		leaveFrom = FileHandler.getPropertyValue("leave", "leaveFrom");
		leaveTo = FileHandler.getPropertyValue("leave", "leaveTo");
		leaveStatus = FileHandler.getPropertyValue("leave", "leaveStatus");
		apply = FileHandler.getPropertyValue("leave", "apply");
		applyTypeDrop = FileHandler.getPropertyValue("leave", "applyTypeDrop");
		applyFrom = FileHandler.getPropertyValue("leave", "applyFrom");
		applyTo = FileHandler.getPropertyValue("leave", "applyTo");
		applyFromBox = FileHandler.getPropertyValue("leave", "applyFromBox");
		applyToBox = FileHandler.getPropertyValue("leave", "applyToBox");
		applyType = FileHandler.getPropertyValue("leave", "applyType");
		submitLeave = FileHandler.getPropertyValue("leave", "submitLeave");
		myLeave = FileHandler.getPropertyValue("leave", "myLeave");
		reports = FileHandler.getPropertyValue("leave", "reports");
		reportType = FileHandler.getPropertyValue("leave", "reportType");
		reportForLeave = FileHandler.getPropertyValue("leave", "reportForLeave");
		reportForLocation = FileHandler.getPropertyValue("leave", "reportForLocation");
		generate = FileHandler.getPropertyValue("leave", "generate");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);
	}

	@Test()
	public void case01_LeaveEntitlementUsageReport() {

		WebElement loginName = driver.findElement(By.xpath(username));
		WebElement loginPass = driver.findElement(By.xpath(password));

		loginName.sendKeys(adminUser);
		loginPass.sendKeys(adminPass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(leaveTab)).click();
		driver.findElement(By.xpath(reports)).click();
		driver.findElement(By.xpath(reportType)).click();

		WebElement type = driver.findElement(By.xpath(reportForLeave));
		type.click();
		new Actions(driver);
		try {
			Robot r = new Robot();
			for (int i = 1; i < 5; i++) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				WaitTime.waitTimeInSec(1);
			}
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			WaitTime.waitTimeInSec(1);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		WebElement location = driver.findElement(By.xpath(reportForLocation));
		location.click();
		try {
			Robot r = new Robot();
			for (int i = 1; i < 6; i++) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				WaitTime.waitTimeInSec(1);
			}
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			WaitTime.waitTimeInSec(1);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(generate)).click();
	}

	@Test()
	public void case02_CheckLeaveStatus() {

		driver.findElement(By.xpath(username)).sendKeys(adminUser);
		driver.findElement(By.xpath(password)).sendKeys(adminPass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(leaveTab)).click();
		WebElement from = driver.findElement(By.xpath(leaveFrom));
		WebElement to = driver.findElement(By.xpath(leaveTo));

		from.click();
		new Actions(driver);
		try {
			Robot r = new Robot();
			WaitTime.waitTimeInSec(1);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			WaitTime.waitTimeInSec(1);
			from.sendKeys(fromDate);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		to.click();
		new Actions(driver);
		try {
			Robot r = new Robot();
			WaitTime.waitTimeInSec(1);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			WaitTime.waitTimeInSec(1);
			to.sendKeys(toDate);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		WebElement status = driver.findElement(By.xpath(leaveStatus));
		status.click();

		new Actions(driver);
		try {
			Robot r1 = new Robot();
			for (int i = 1; i < 4; i++) {
				r1.keyPress(KeyEvent.VK_DOWN);
				r1.keyRelease(KeyEvent.VK_DOWN);
				WaitTime.waitTimeInSec(1);
			}
			r1.keyPress(KeyEvent.VK_ENTER);
			r1.keyRelease(KeyEvent.VK_ENTER);

			for (int j = 1; j < 5; j++) {
				r1.keyPress(KeyEvent.VK_DOWN);
				r1.keyRelease(KeyEvent.VK_DOWN);
				WaitTime.waitTimeInSec(1);
			}
			r1.keyPress(KeyEvent.VK_ENTER);
			r1.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e1) {
			e1.printStackTrace();
		}

		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	@Test()
	public void case03_ApplyLeaveForCurrentYearOnly() {

		driver.findElement(By.xpath(username)).sendKeys(user);
		driver.findElement(By.xpath(password)).sendKeys(pass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(leaveTab)).click();
		driver.findElement(By.xpath(apply)).click();

		WebElement applyDrop = driver.findElement(By.xpath(applyTypeDrop));
		applyDrop.click();
		new Actions(driver);
		try {
			Robot r1 = new Robot();
			r1.keyPress(KeyEvent.VK_DOWN);
			r1.keyRelease(KeyEvent.VK_DOWN);
			WaitTime.waitTimeInSec(1);
			driver.findElement(By.xpath(applyType)).click();

		} catch (AWTException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(applyFromBox)).sendKeys(applyFrom);
		WebElement applyTill = driver.findElement(By.xpath(applyToBox));
		applyTill.click();
		new Actions(driver);
		try {
			Robot r = new Robot();
			WaitTime.waitTimeInSec(1);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			WaitTime.waitTimeInSec(1);
			applyTill.sendKeys(applyTo);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(submitLeave)).click();
	}

	@Test()
	public void case04_NoCancelForApprovedRejectedLeave() {

		driver.findElement(By.xpath(username)).sendKeys(user);
		driver.findElement(By.xpath(password)).sendKeys(pass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(leaveTab)).click();
		driver.findElement(By.xpath(myLeave)).click();

		new Actions(driver);
		try {
			Robot r = new Robot();
			WaitTime.waitTimeInSec(1);
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod()
	public void conclusion() {

		WaitTime.waitTimeInSec(5);
		BrowserFactory.closeAllBrowsers();
	}
}
