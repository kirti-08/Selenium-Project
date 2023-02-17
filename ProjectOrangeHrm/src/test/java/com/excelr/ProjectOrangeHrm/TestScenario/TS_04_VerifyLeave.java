package com.excelr.ProjectOrangeHrm.TestScenario;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excelr.ProjectOrangeHrm.Common.BrowserFactory;
import com.excelr.ProjectOrangeHrm.Common.FileHandler;
import com.excelr.ProjectOrangeHrm.Common.WaitTime;

import net.bytebuddy.asm.Advice.Enter;

public class TS_04_VerifyLeave {

	private WebDriver driver;
	String browser, url, user, pass, adminUser, adminPass, empName, entitle;

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
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);
	}

	@Test()
	public void case01() {

		WebElement loginName = driver.findElement(By.xpath("//input[@name = \"username\"]"));
		WebElement loginPass = driver.findElement(By.xpath("//input[@name = \"password\"]"));

		loginName.sendKeys(adminUser);
		loginPass.sendKeys(adminPass);
		driver.findElement(By.xpath("//button[@type = \"submit\"]")).click();
		
		driver.findElement(By.xpath("//span[normalize-space()=\"Leave\"]")).click();
		driver.findElement(By.xpath("//span[normalize-space()=\"Entitlements\"]")).click();
		driver.findElement(By.xpath("//a[normalize-space()=\"Add Entitlements\"]")).click();
		WebElement name = driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]"));
		name.sendKeys(empName);
		new Actions(driver);
		try {
			Robot r1 = new Robot();
			r1.keyPress(KeyEvent.VK_DOWN);
			r1.keyRelease(KeyEvent.VK_DOWN);
			r1.keyPress(KeyEvent.VK_ENTER);
			r1.keyRelease(KeyEvent.VK_ENTER);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
//		driver.findElement(By.xpath("//label[normalize-space()=\"Multiple Employees\"]")).click();
//		driver.findElement(By.xpath("//label[normalize-space()=\"Individual Employee\"]")).click();
		WebElement leaveType = driver.findElement(By.xpath("//form[@class=\"oxd-form\"]/div[3]/div/div/div/div[2]/div/div/div[normalize-space()=\"-- Select --\"]"));
		leaveType.click();
		
		new Actions(driver);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input[@class=\"oxd-input oxd-input--active\"]")).sendKeys(entitle);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		System.out.println("TS-04 Verify Leave function");
		System.out.println("TC01 - Admin shall be able to entitle  leaves to employees");
	}

	
	@AfterMethod()
	public void conclusion() {

//		WaitTime.waitTimeInSec(5);
//		BrowserFactory.closeAllBrowsers();
	}
}
