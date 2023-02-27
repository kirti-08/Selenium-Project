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

public class VerifyForgotPassword {

	private WebDriver driver;
	String browser, url, validUser, invalidUser, emailid, emailpass, checkemail, forgotPassword, username, submit,
			message, signin, user, logPass, next, mailBox;

	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("forgotpass", "browsername");
		url = FileHandler.getPropertyValue("forgotpass", "url");

		validUser = FileHandler.getPropertyValue("forgotpass", "validuser");
		invalidUser = FileHandler.getPropertyValue("forgotpass", "invaliduser");
		emailid = FileHandler.getPropertyValue("forgotpass", "emailid");
		emailpass = FileHandler.getPropertyValue("forgotpass", "emailpass");
		checkemail = FileHandler.getPropertyValue("forgotpass", "checkemail");
		forgotPassword = FileHandler.getPropertyValue("forgotpass", "forgotPassword");
		username = FileHandler.getPropertyValue("forgotpass", "username");
		submit = FileHandler.getPropertyValue("forgotpass", "submit");
		message = FileHandler.getPropertyValue("forgotpass", "message");
		signin = FileHandler.getPropertyValue("forgotpass", "signin");
		user = FileHandler.getPropertyValue("forgotpass", "user");
		logPass = FileHandler.getPropertyValue("forgotpass", "logPass");
		next = FileHandler.getPropertyValue("forgotpass", "next");
		mailBox = FileHandler.getPropertyValue("forgotpass", "mailBox");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);
	}

	@Test(priority = 1)
	public void resetPasswordValidUsername() {

		driver.findElement(By.xpath(forgotPassword)).click();
		driver.findElement(By.xpath(username)).sendKeys(validUser);
		driver.findElement(By.xpath(submit)).click();

		WebElement popUp = driver.findElement(By.xpath(message));
		if (popUp.isDisplayed() == true) {
			WaitTime.waitTimeInSec(3);
		}
	}

	@Test(priority = 2)
	public void resetPasswordLinkNotReceivedOnUserEmail() {

		driver.findElement(By.xpath(forgotPassword)).click();
		driver.findElement(By.xpath(username)).sendKeys(validUser);
		driver.findElement(By.xpath(submit)).click();
		WaitTime.waitTimeInSec(2);

		BrowserFactory.OpenUrl(checkemail);
		driver.findElement(By.name(user)).sendKeys(emailid);
		driver.findElement(By.id(signin)).click();
		WaitTime.waitTimeInSec(2);

		WebElement loginpass = driver.findElement(By.id(logPass));
		loginpass.click();
		loginpass.clear();
		loginpass.sendKeys(emailpass);
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(next)).click();
		WaitTime.waitTimeInSec(3);
		driver.findElement(By.xpath(mailBox)).click();
		WaitTime.waitTimeInSec(2);
		driver.navigate().refresh();
		WaitTime.waitTimeInSec(2);
	}

	@Test(priority = 3)
	public void noResetPasswordErrorForInvalidUsername() {

		driver.findElement(By.xpath(forgotPassword)).click();
		driver.findElement(By.xpath(username)).sendKeys(invalidUser);
		driver.findElement(By.xpath(submit)).click();

		WaitTime.waitTimeInSec(3);
	}

	@AfterMethod()
	public void conclusion() {

		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeAllBrowsers();
	}
}
