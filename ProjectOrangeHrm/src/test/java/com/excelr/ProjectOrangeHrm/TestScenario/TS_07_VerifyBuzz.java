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
	String browser, url, adminUser, adminPass, user, pass, buzz, username, password, loginButton, buzzTab, buzzBox,
			post, empName, editDelete, adminNamePath, empNamePath, buzzOption, deleteBuzz, confirmDelete;

	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("buzz", "browsername");
		url = FileHandler.getPropertyValue("buzz", "url");

		adminUser = FileHandler.getPropertyValue("buzz", "adminUser");
		adminPass = FileHandler.getPropertyValue("buzz", "adminPass");
		user = FileHandler.getPropertyValue("buzz", "user");
		pass = FileHandler.getPropertyValue("buzz", "pass");
		buzz = FileHandler.getPropertyValue("buzz", "buzz");
		username = FileHandler.getPropertyValue("buzz", "username");
		password = FileHandler.getPropertyValue("buzz", "password");
		loginButton = FileHandler.getPropertyValue("buzz", "loginButton");
		buzzTab = FileHandler.getPropertyValue("buzz", "buzzTab");
		buzzBox = FileHandler.getPropertyValue("buzz", "buzzBox");
		post = FileHandler.getPropertyValue("buzz", "post");
		empName = FileHandler.getPropertyValue("buzz", "empName");
		editDelete = FileHandler.getPropertyValue("buzz", "editDelete");
		adminNamePath = FileHandler.getPropertyValue("buzz", "adminNamePath");
		empNamePath = FileHandler.getPropertyValue("buzz", "empNamePath");
		buzzOption = FileHandler.getPropertyValue("buzz", "buzzOption");
		deleteBuzz = FileHandler.getPropertyValue("buzz", "deleteBuzz");
		confirmDelete = FileHandler.getPropertyValue("buzz", "confirmDelete");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);
	}

	@Test()
	public void case01_PostBuzz() {

		WebElement admin = driver.findElement(By.xpath(username));
		WebElement passwd = driver.findElement(By.xpath(password));
		admin.sendKeys(user);
		passwd.sendKeys(pass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(buzzTab)).click();
		driver.findElement(By.xpath(buzzBox)).sendKeys(buzz);
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(post)).click();
		WaitTime.waitTimeInSec(1);
		driver.navigate().refresh();
		WaitTime.waitTimeInSec(3);
	}

	@Test()
	public void case02_EditDeleteOnlySelfBuzz() {

		WebElement admin = driver.findElement(By.xpath(username));
		WebElement passwd = driver.findElement(By.xpath(password));
		admin.sendKeys(user);
		passwd.sendKeys(pass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(buzzTab)).click();

		WebElement employee = driver.findElement(By.xpath(empName));
		if (employee.isDisplayed() == true) {
			driver.findElement(By.xpath(editDelete)).click();
			WaitTime.waitTimeInSec(5);
		}
	}

	@Test()
	public void case03_AdminCannotEditOtherBuzz() {

		WebElement admin = driver.findElement(By.xpath(username));
		WebElement passwd = driver.findElement(By.xpath(password));
		admin.sendKeys(adminUser);
		passwd.sendKeys(adminPass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(buzzTab)).click();

		WebElement adminName = driver.findElement(By.xpath(adminNamePath));
		WebElement empName = driver.findElement(By.xpath(empNamePath));

		if (adminName != empName) {
			WebElement option = driver.findElement(By.xpath(buzzOption));
			option.click();
			WaitTime.waitTimeInSec(3);
		}
	}

	@Test()
	public void case04_AdminCanDeleteOtherBuzz() {

		WebElement admin = driver.findElement(By.xpath(username));
		WebElement passwd = driver.findElement(By.xpath(password));
		admin.sendKeys(adminUser);
		passwd.sendKeys(adminPass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(buzzTab)).click();

		WebElement adminName = driver.findElement(By.xpath(adminNamePath));
		WebElement empName = driver.findElement(By.xpath(empNamePath));

		if (adminName != empName) {
			WebElement option = driver.findElement(By.xpath(buzzOption));
			option.click();
			WebElement delete = driver.findElement(By.xpath(deleteBuzz));
			delete.click();
			driver.findElement(By.xpath(confirmDelete)).click();
		}

		driver.navigate().refresh();
		WaitTime.waitTimeInSec(3);

	}

	@AfterMethod()
	public void conclusion() {

		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeAllBrowsers();
	}
}
