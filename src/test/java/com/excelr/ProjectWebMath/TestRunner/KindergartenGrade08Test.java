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
import com.excelr.ProjectWebMath.PageObjects.KindergartenGrade08;

public class KindergartenGrade08Test {

	private WebDriver driver;
	String browser, url, kinder;

	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("kinder", "browsername");
		url = FileHandler.getPropertyValue("kinder", "url");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);

		HomePage home = new HomePage(driver);
		home.clickK8();
	}

	@Test(priority = 1)
	public void fractionNumeratorSmallerThanDenominator() {

		KindergartenGrade08 k08 = new KindergartenGrade08(driver);
		k08.FractionStudy();
		
		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeCurrentWindow();
	}

	@Test(priority = 2)
	public void studyRectangle() {
		
		KindergartenGrade08 k08 = new KindergartenGrade08(driver);
		k08.RectangleStudy();
	}

	@AfterTest()
	public void conclusion() {

		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeAllBrowsers();
	}
}
