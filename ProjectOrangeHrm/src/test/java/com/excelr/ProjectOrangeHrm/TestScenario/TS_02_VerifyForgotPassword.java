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

public class TS_02_VerifyForgotPassword {

	private WebDriver driver;
	String browser, url, validUser, invalidUser, emailid, emailpass, checkemail;

	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("forgotpass", "browsername");
		url = FileHandler.getPropertyValue("forgotpass", "url");

		validUser = FileHandler.getPropertyValue("forgotpass", "validuser");
		invalidUser = FileHandler.getPropertyValue("forgotpass", "invaliduser");
		emailid = FileHandler.getPropertyValue("forgotpass", "emailid");
		emailpass = FileHandler.getPropertyValue("forgotpass", "emailpass");
		checkemail = FileHandler.getPropertyValue("forgotpass", "checkemail");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);
	}

	@Test()
	public void case01() {

		driver.findElement(By.xpath("//p[normalize-space()='Forgot your password?']")).click();
		WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
		username.sendKeys(validUser);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		System.out.println("Valid username - " + validUser);

		WebElement message = driver
				.findElement(By.xpath("//h6[normalize-space()='Reset Password link sent successfully']"));
		System.out.println("Message popped - " + message.isDisplayed());

		System.out.println("TC01 - User is able to reset password with valid username");
	}

	@Test
	public void case02() {

		driver.findElement(By.xpath("//p[normalize-space()='Forgot your password?']")).click();
		WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
		username.sendKeys(validUser);
		System.out.println("Valid username - " + validUser);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		WebElement message = driver
				.findElement(By.xpath("//h6[normalize-space()='Reset Password link sent successfully']"));
		System.out.println("Reset Password link sent successfully message popped: " + message.isDisplayed());

		BrowserFactory.OpenUrl(checkemail);
		driver.findElement(By.name("username")).sendKeys(emailid);
		driver.findElement(By.id("login-signin")).click();
		System.out.println("Email id provided in system: " + emailid);

		WaitTime.waitTimeInSec(2);

		WebElement loginpass = driver.findElement(By.id("login-passwd"));
		loginpass.click();
		loginpass.clear();
		loginpass.sendKeys(emailpass);

		WebElement next = driver.findElement(By.xpath("//button[@id=\"login-signin\"]"));
		next.click();

		WebElement mailbox = driver.findElement(By.xpath("//a[@aria-label=\"Check your mail\"]"));
		mailbox.click();

		System.out.println("TC02 - User is not able to receive reset password link on email");
		System.out.println("Defect 02 - Further steps are unexecuted");
	}

	@Test
	public void case03() {

		driver.findElement(By.xpath("//p[normalize-space()='Forgot your password?']")).click();
		WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
		username.sendKeys(invalidUser);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		WebElement message = driver
				.findElement(By.xpath("//h6[normalize-space()='Reset Password link sent successfully']"));
		System.out.println("Reset Password link sent successfully message popped: " + message.isDisplayed());
		System.out.println("Username '" + invalidUser + "' is invalid");
		System.out.println("TC-03 User should not be able to reset password for invalid username");
		System.out.println("Defect 03 - Error message for invalid username is not given");
	}

	@Test
	public void case04() {

		case02();

		System.out
				.println("TC04 - User should not be able to access reset password link sent on email after 24 hours ");
		System.out.println("Defect 04 - User is not able to receive reset password link on email");
		System.out.println("Further steps are unexecuted");
	}

	@AfterMethod()
	public void conclusion() {

		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeAllBrowsers();
	}
}
