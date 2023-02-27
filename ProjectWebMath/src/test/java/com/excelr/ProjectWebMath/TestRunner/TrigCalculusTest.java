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
import com.excelr.ProjectWebMath.PageObjects.PlotsGeometry;

public class TrigCalculusTest {

	private WebDriver driver;
	String browser, url;

	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("geometry", "browsername");
		url = FileHandler.getPropertyValue("geometry", "url");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);

		HomePage home = new HomePage(driver);
		home.clickPlotsGeometry();
	}

	@Test(priority = 1)
	public void onlyNumericInputToReduceFraction() {

		PlotsGeometry plotGeo = new PlotsGeometry(driver);
		plotGeo.CircleStudy();
		WaitTime.waitTimeInSec(5);
		BrowserFactory.closeCurrentWindow();
	}

	@Test(priority = 2)
	public void onlyIntegerForFactoring() {

		PlotsGeometry plotGeo = new PlotsGeometry(driver);
		plotGeo.RightTriangle();
		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeCurrentWindow();
	}

	@Test(priority = 3)
	public void validateClearFormButtoninAddFractions() {

		PlotsGeometry plotGeo = new PlotsGeometry(driver);
		plotGeo.LineGraph();
	}

	@AfterTest()
	public void conclusion() {

		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeAllBrowsers();
	}
}
