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
import com.excelr.ProjectWebMath.PageObjects.TrigCalculus;

public class PlotsGeometryTest {

	private WebDriver driver;
	String browser, url;

	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("trignometry", "browsername");
		url = FileHandler.getPropertyValue("trignometry", "url");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);

		HomePage home = new HomePage(driver);
		home.clickTrigCalculus();
	}

	@Test(priority = 1)
	public void calculateRightTriangleHypotenuse() {

		WaitTime.waitTimeInSec(1);
		TrigCalculus trigCalculus = new TrigCalculus(driver);
		trigCalculus.FindHypotenuse();

		WaitTime.waitTimeInSec(5);
		BrowserFactory.closeCurrentWindow();
	}

	@Test(priority = 2)
	public void findOnlyOneUnknownValue() {

		WaitTime.waitTimeInSec(1);
		TrigCalculus trigCalculus = new TrigCalculus(driver);
		trigCalculus.FindUnknownValue();
		WaitTime.waitTimeInSec(2);
	}

	@AfterTest()
	public void conclusion() {

		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeAllBrowsers();
	}
}
