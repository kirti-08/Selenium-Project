package com.excelr.ProjectWebMath.TestRunner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excelr.ProjectWebMath.Common.BrowserFactory;
import com.excelr.ProjectWebMath.Common.FileHandler;
import com.excelr.ProjectWebMath.Common.WaitTime;
import com.excelr.ProjectWebMath.PageObjects.HomePage;
import com.excelr.ProjectWebMath.PageObjects.MathForEveryone;

public class MathForEveryoneTest {

	private WebDriver driver;
	String browser, url;

	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("everyone", "browsername");
		url = FileHandler.getPropertyValue("everyone", "url");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);

		HomePage home = new HomePage(driver);
		home.clickMathEveryone();
	}

	@Test(priority = 1)
	public void calculateSimpleInterest() {

		WaitTime.waitTimeInSec(1);
		MathForEveryone mathEveryone = new MathForEveryone(driver);
		mathEveryone.SimpleInterest();

		WaitTime.waitTimeInSec(5);
		BrowserFactory.closeCurrentWindow();
	}

	@Test(priority = 2)
	public void findOnlyOneUnknownValue() {

		WaitTime.waitTimeInSec(1);
		MathForEveryone mathEveryone = new MathForEveryone(driver);
		mathEveryone.OtherPlanetWeight();
	}

	@AfterTest()
	public void conclusion() {

		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeAllBrowsers();
	}
}
