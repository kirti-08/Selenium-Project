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
import com.excelr.ProjectWebMath.PageObjects.OtherStuff;

public class OtherStuffTest {

	private WebDriver driver;
	String browser, url;

	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("other", "browsername");
		url = FileHandler.getPropertyValue("other", "url");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);

		HomePage home = new HomePage(driver);
		home.clickOtherStuff();
	}

	@Test(priority = 1)
	public void calculateAverageValueofRawData() {

		WaitTime.waitTimeInSec(1);
		OtherStuff otherStuff = new OtherStuff(driver);
		otherStuff.AverageValue();

		WaitTime.waitTimeInSec(5);
		BrowserFactory.closeCurrentWindow();
	}

	@Test(priority = 2)
	public void findOnlyOneUnknownValue() {

		WaitTime.waitTimeInSec(1);
		OtherStuff otherStuff = new OtherStuff(driver);
		otherStuff.BasicMathWorksheet();
		WaitTime.waitTimeInSec(2);
	}

	@AfterTest()
	public void conclusion() {

		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeAllBrowsers();
	}
}
