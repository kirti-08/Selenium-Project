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

public class VerifyTime {

	private WebDriver driver;
	String browser, url, user, pass, username, password, loginButton, timeTab, attendance, punch, punchTime, date,
			punchDate, buttonIn, buttonOut, in, out, myRecords, recordDate, view, in1, out1,
			in2, out2, date2;

	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("time", "browsername");
		url = FileHandler.getPropertyValue("time", "url");

		user = FileHandler.getPropertyValue("time", "user");
		pass = FileHandler.getPropertyValue("time", "pass");
		username = FileHandler.getPropertyValue("time", "username");
		password = FileHandler.getPropertyValue("time", "password");
		loginButton = FileHandler.getPropertyValue("time", "loginButton");
		timeTab = FileHandler.getPropertyValue("time", "timeTab");
		attendance = FileHandler.getPropertyValue("time", "attendance");
		punch = FileHandler.getPropertyValue("time", "punch");
		in = FileHandler.getPropertyValue("time", "in");
		out = FileHandler.getPropertyValue("time", "out");
		date = FileHandler.getPropertyValue("time", "date");
		punchDate = FileHandler.getPropertyValue("time", "punchDate");
		punchTime = FileHandler.getPropertyValue("time", "punchTime");
		buttonIn = FileHandler.getPropertyValue("time", "buttonIn");
		buttonOut = FileHandler.getPropertyValue("time", "buttonOut");
		myRecords = FileHandler.getPropertyValue("time", "records");
		recordDate = FileHandler.getPropertyValue("time", "recordDate");
		view = FileHandler.getPropertyValue("time", "view");
		in1 = FileHandler.getPropertyValue("time", "in1");
		out1 = FileHandler.getPropertyValue("time", "out1");
		in2 = FileHandler.getPropertyValue("time", "in2");
		out2 = FileHandler.getPropertyValue("time", "out2");
		date2 = FileHandler.getPropertyValue("time", "date2");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);
	}

	@Test(priority = 1)
	public void enterInOutPunchTime() {
		
		WebElement loginName = driver.findElement(By.xpath(username));
		WebElement loginPass = driver.findElement(By.xpath(password));
		loginName.sendKeys(user);
		loginPass.sendKeys(pass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(timeTab)).click();
		driver.findElement(By.xpath(attendance)).click();
		driver.findElement(By.xpath(punch)).click();
		WaitTime.waitTimeInSec(3);

		WebElement dayIn = driver.findElement(By.xpath(punchDate));
		dayIn.click();
		WaitTime.waitTimeInSec(1);
		new Actions(driver);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			WaitTime.waitTimeInSec(1);
			dayIn.sendKeys(date);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		WebElement come = driver.findElement(By.xpath(punchTime));
		come.click();
		WaitTime.waitTimeInSec(1);
		Actions punch = new Actions(driver);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			WaitTime.waitTimeInSec(1);
			come.sendKeys(in);
			WaitTime.waitTimeInSec(1);
			come.click();
			WaitTime.waitTimeInSec(1);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		punch.sendKeys(Keys.TAB).build().perform();
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(buttonIn)).click();

		WaitTime.waitTimeInSec(10);
		WebElement dayOut = driver.findElement(By.xpath(punchDate));
		dayOut.click();
		WaitTime.waitTimeInSec(1);
		new Actions(driver);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			WaitTime.waitTimeInSec(1);
			dayOut.sendKeys(date);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		WebElement go = driver.findElement(By.xpath(punchTime));
		go.click();
		WaitTime.waitTimeInSec(1);
		new Actions(driver);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			WaitTime.waitTimeInSec(1);
			go.sendKeys(out);
			WaitTime.waitTimeInSec(1);
			go.click();
			WaitTime.waitTimeInSec(1);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		punch.sendKeys(Keys.TAB).build().perform();
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(buttonOut)).click();
		WaitTime.waitTimeInSec(3);
	}

	@Test(priority = 2)
	public void checkSelfAttendanceRecords() {

		WebElement loginName = driver.findElement(By.xpath(username));
		WebElement loginPass = driver.findElement(By.xpath(password));
		loginName.sendKeys(user);
		loginPass.sendKeys(pass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(timeTab)).click();
		driver.findElement(By.xpath(attendance)).click();
		WaitTime.waitTimeInSec(2);
		driver.findElement(By.xpath(myRecords)).click();

		WaitTime.waitTimeInSec(3);
		WebElement day = driver.findElement(By.xpath(recordDate));
		day.click();
		WaitTime.waitTimeInSec(1);
		Actions action = new Actions(driver);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			WaitTime.waitTimeInSec(1);
			day.sendKeys(date);
			WaitTime.waitTimeInSec(1);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(view)).click();
		WaitTime.waitTimeInSec(2);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		WaitTime.waitTimeInSec(2);
	}

	@Test(priority = 3)
	public void multiplePunchNotAllowedForSameDate() {

		WebElement loginName = driver.findElement(By.xpath(username));
		WebElement loginPass = driver.findElement(By.xpath(password));
		loginName.sendKeys(user);
		loginPass.sendKeys(pass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(timeTab)).click();
		driver.findElement(By.xpath(attendance)).click();
		driver.findElement(By.xpath(punch)).click();
		WaitTime.waitTimeInSec(3);

		WebElement dayIn = driver.findElement(By.xpath(punchDate));
		dayIn.click();
		WaitTime.waitTimeInSec(1);
		Actions action = new Actions(driver);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			WaitTime.waitTimeInSec(1);
			dayIn.sendKeys(date);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		WebElement come = driver.findElement(By.xpath(punchTime));
		come.click();
		WaitTime.waitTimeInSec(1);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			WaitTime.waitTimeInSec(1);
			come.sendKeys(in1);
			WaitTime.waitTimeInSec(1);
			come.click();
			WaitTime.waitTimeInSec(1);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		action.sendKeys(Keys.TAB).build().perform();
	}

	@Test(priority = 4)
	public void outTimeLaterThanInTime() {

		WebElement loginName = driver.findElement(By.xpath(username));
		WebElement loginPass = driver.findElement(By.xpath(password));
		loginName.sendKeys(user);
		loginPass.sendKeys(pass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(timeTab)).click();
		driver.findElement(By.xpath(attendance)).click();
		driver.findElement(By.xpath(punch)).click();
		WaitTime.waitTimeInSec(3);

		WebElement dayIn = driver.findElement(By.xpath(punchDate));
		dayIn.click();
		WaitTime.waitTimeInSec(1);
		new Actions(driver);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			WaitTime.waitTimeInSec(1);
			dayIn.sendKeys(date2);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		WebElement come = driver.findElement(By.xpath(punchTime));
		come.click();
		WaitTime.waitTimeInSec(1);
		Actions punchIn = new Actions(driver);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			WaitTime.waitTimeInSec(1);
			come.sendKeys(in2);
			WaitTime.waitTimeInSec(1);
			come.click();
			WaitTime.waitTimeInSec(1);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		punchIn.sendKeys(Keys.TAB).build().perform();
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(buttonIn)).click();

		WaitTime.waitTimeInSec(10);
		WebElement dayOut = driver.findElement(By.xpath(punchDate));
		dayOut.click();
		WaitTime.waitTimeInSec(1);
		new Actions(driver);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			WaitTime.waitTimeInSec(1);
			dayOut.sendKeys(date2);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		WebElement go = driver.findElement(By.xpath(punchTime));
		go.click();
		WaitTime.waitTimeInSec(1);
		new Actions(driver);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
			WaitTime.waitTimeInSec(1);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			WaitTime.waitTimeInSec(1);
			go.sendKeys(out2);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(buttonOut)).click();
		WaitTime.waitTimeInSec(3);
	}

	@AfterMethod()
	public void conclusion() {

		WaitTime.waitTimeInSec(5);
		BrowserFactory.closeAllBrowsers();
	}
}
