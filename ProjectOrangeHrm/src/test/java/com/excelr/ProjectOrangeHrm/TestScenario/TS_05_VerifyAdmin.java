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

public class TS_05_VerifyAdmin {

	private WebDriver driver;
	String browser, url, adminUser, adminPass;
	String username, password, loginButton, adminTab, userManageTab, users, userRole, search, employee, edit, editRole,
			save, jobTab, employmentStatus, editEmployment, employmentName, employmentStatus1, employmentStatus2, addEmployment, existingEmployment, newEmployment, errorMessage, cancel, userStatus, edit2;

	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("admin", "browsername");
		url = FileHandler.getPropertyValue("admin", "url");

		adminUser = FileHandler.getPropertyValue("admin", "adminUser");
		adminPass = FileHandler.getPropertyValue("admin", "adminPass");
		username = FileHandler.getPropertyValue("admin", "username");
		password = FileHandler.getPropertyValue("admin", "password");
		adminTab = FileHandler.getPropertyValue("admin", "adminTab");
		loginButton = FileHandler.getPropertyValue("admin", "loginButton");
		userManageTab = FileHandler.getPropertyValue("admin", "userManageTab");
		users = FileHandler.getPropertyValue("admin", "users");
		userRole = FileHandler.getPropertyValue("admin", "userRole");
		search = FileHandler.getPropertyValue("admin", "search");
		employee = FileHandler.getPropertyValue("admin", "employee");
		edit = FileHandler.getPropertyValue("admin", "edit");
		editRole = FileHandler.getPropertyValue("admin", "editRole");
		save = FileHandler.getPropertyValue("admin", "save");
		jobTab = FileHandler.getPropertyValue("admin", "jobTab");
		employmentStatus = FileHandler.getPropertyValue("admin", "employmentStatus");
		editEmployment = FileHandler.getPropertyValue("admin", "editEmployment");
		employmentName = FileHandler.getPropertyValue("admin", "employmentName");
		employmentStatus1 = FileHandler.getPropertyValue("admin", "employmentStatus1");
		employmentStatus2 = FileHandler.getPropertyValue("admin", "employmentStatus2");
		addEmployment = FileHandler.getPropertyValue("admin", "addEmployment");
		existingEmployment = FileHandler.getPropertyValue("admin", "existingEmployment");
		newEmployment = FileHandler.getPropertyValue("admin", "newEmployment");
		errorMessage = FileHandler.getPropertyValue("admin", "error");
		cancel = FileHandler.getPropertyValue("admin", "cancel");
		userStatus = FileHandler.getPropertyValue("admin", "userStatus");
		edit2 = FileHandler.getPropertyValue("admin", "edit2");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);
	}

	@Test()
	public void case01_MakeUserAnAdmin() {

		WebElement loginName = driver.findElement(By.xpath(username));
		WebElement loginPass = driver.findElement(By.xpath(password));
		loginName.sendKeys(adminUser);
		loginPass.sendKeys(adminPass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(adminTab)).click();
		driver.findElement(By.xpath(userManageTab)).click();
		driver.findElement(By.xpath(users)).click();

		driver.findElement(By.xpath(userRole)).click();
		Actions a = new Actions(driver);
		try {
			Robot r = new Robot();
			for (int i = 1; i < 3; i++) {
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
		driver.findElement(By.xpath(search)).click();
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath(edit)).click();
		driver.findElement(By.xpath(editRole)).click();
		try {
			Robot r1 = new Robot();
			r1.keyPress(KeyEvent.VK_DOWN);
			r1.keyRelease(KeyEvent.VK_DOWN);
			WaitTime.waitTimeInSec(1);
			r1.keyPress(KeyEvent.VK_ENTER);
			r1.keyRelease(KeyEvent.VK_ENTER);
			WaitTime.waitTimeInSec(1);
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(save)).click();
	}

	@Test()
	public void case02_DisabledUserIsAdmin() {

		WebElement loginName = driver.findElement(By.xpath(username));
		WebElement loginPass = driver.findElement(By.xpath(password));
		loginName.sendKeys(adminUser);
		loginPass.sendKeys(adminPass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(adminTab)).click();
		driver.findElement(By.xpath(userManageTab)).click();
		driver.findElement(By.xpath(users)).click();

		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath(edit2)).click();
		
		driver.findElement(By.xpath(editRole)).click();
		try {
			Robot r1 = new Robot();
			r1.keyPress(KeyEvent.VK_DOWN);
			r1.keyRelease(KeyEvent.VK_DOWN);
			WaitTime.waitTimeInSec(1);
			r1.keyPress(KeyEvent.VK_TAB);
			r1.keyRelease(KeyEvent.VK_TAB);
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		
		driver.findElement(By.xpath(userStatus)).click();
		try {
			Robot r = new Robot();
			for (int i = 1; i < 3; i++) {
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
		driver.findElement(By.xpath(save)).click();
	}
	
	@Test()
	public void case03_EditEmploymentStatus() {

		WebElement loginName = driver.findElement(By.xpath(username));
		WebElement loginPass = driver.findElement(By.xpath(password));
		loginName.sendKeys(adminUser);
		loginPass.sendKeys(adminPass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(adminTab)).click();
		driver.findElement(By.xpath(jobTab)).click();
		driver.findElement(By.xpath(employmentStatus)).click();
		driver.findElement(By.xpath(editEmployment)).click();

		WebElement employment = driver.findElement(By.xpath(employmentName));
		employment.click();
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

			if (employment.getText().equalsIgnoreCase("Confirmed")) {
				employment.sendKeys(employmentStatus1);
			}	employment.sendKeys(employmentStatus2);
			WaitTime.waitTimeInSec(1);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(save)).click();
	}

	@Test()
	public void case04_NoDuplicateEmploymentStatus() {

		WebElement loginName = driver.findElement(By.xpath(username));
		WebElement loginPass = driver.findElement(By.xpath(password));
		loginName.sendKeys(adminUser);
		loginPass.sendKeys(adminPass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(adminTab)).click();
		driver.findElement(By.xpath(jobTab)).click();
		driver.findElement(By.xpath(employmentStatus)).click();
		
		WebElement presentEmployment = driver.findElement(By.xpath(existingEmployment));
		String presentStatus = presentEmployment.getText();
		driver.findElement(By.xpath(addEmployment)).click();
		
		WebElement newEmp = driver.findElement(By.xpath(newEmployment));
		newEmp.click();
		newEmp.sendKeys(presentStatus);
		
		WebElement error = driver.findElement(By.xpath(errorMessage));
		if((error.isDisplayed())==true){
			driver.findElement(By.xpath(cancel)).click();
		}
	}
	
	@AfterMethod()
	public void conclusion() {

		WaitTime.waitTimeInSec(5);
		BrowserFactory.closeAllBrowsers();
	}
}
