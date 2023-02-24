package com.excelr.ProjectOrangeHrm.TestScenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excelr.ProjectOrangeHrm.Common.BrowserFactory;
import com.excelr.ProjectOrangeHrm.Common.FileHandler;
import com.excelr.ProjectOrangeHrm.Common.WaitTime;

public class TS_01_VerifyLogin {

	private WebDriver driver;
	String browser, url, validUser, validPass, invalidUser, invalidPass, username, password, loginButton;
	
	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("login", "browsername");
		url = FileHandler.getPropertyValue("login", "url");
		
		validUser = FileHandler.getPropertyValue("login", "validuser");
		validPass = FileHandler.getPropertyValue("login", "validpass");
		invalidUser = FileHandler.getPropertyValue("login", "invaliduser");
		invalidPass = FileHandler.getPropertyValue("login", "invalidpass");
		username = FileHandler.getPropertyValue("login", "username");
		password = FileHandler.getPropertyValue("login", "password");
		loginButton = FileHandler.getPropertyValue("login", "loginButton");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);
	}

	@Test()
	public void case01_LoginwithValidCredentials() {
						
		driver.findElement(By.xpath(username)).sendKeys(validUser);
		driver.findElement(By.xpath(password)).sendKeys(validPass);
		driver.findElement(By.xpath(loginButton)).click();
		WaitTime.waitTimeInSec(3);		
	}

	@Test
	public void case02_UsernameForLoginNotCaseSensitive() {
		
		driver.findElement(By.xpath(username)).sendKeys(invalidUser);
		driver.findElement(By.xpath(password)).sendKeys(validPass);
		driver.findElement(By.xpath(loginButton)).click();
		
		WaitTime.waitTimeInSec(3);
	}

	@Test
	public void case03_NoLoginWithInvalidCredentials() {
		
		driver.findElement(By.xpath(username)).sendKeys(invalidUser);
		driver.findElement(By.xpath(password)).sendKeys(invalidPass);
		driver.findElement(By.xpath(loginButton)).click();

		WaitTime.waitTimeInSec(3);
	}

	@Test
	public void case04_ValidUsernameInvalidPasswordNoLogin() {
		
		driver.findElement(By.xpath(username)).sendKeys(validUser);
		driver.findElement(By.xpath(password)).sendKeys(invalidPass);
		driver.findElement(By.xpath(loginButton)).click();
		
		WaitTime.waitTimeInSec(3);
	}
	
	@AfterMethod()
	public void conclusion() {

		WaitTime.waitTimeInSec(5);
		BrowserFactory.closeAllBrowsers();
	}
}
