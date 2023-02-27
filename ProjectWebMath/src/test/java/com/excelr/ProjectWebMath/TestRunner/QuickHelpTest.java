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
import com.excelr.ProjectWebMath.PageObjects.QuickHelp;

public class QuickHelpTest {

	private WebDriver driver;
	String browser, url, quick;

	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("quick", "browsername");
		url = FileHandler.getPropertyValue("quick", "url");
		quick = FileHandler.getPropertyValue("quick", "quick");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);

		HomePage home = new HomePage(driver);
		home.clickQuickHelp();
	}

	@Test(priority = 1)
	public void convertTemperature() {

		QuickHelp quickHelp = new QuickHelp(driver);
		quickHelp.convertCelciusToFarenheit();

		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeCurrentWindow();
	}

	@Test(priority = 2)
	public void inputZeroUnacceptableForFractionToDecimal() {

		QuickHelp quickHelp = new QuickHelp(driver);
		quickHelp.fractionToDecimal();
	}

	@AfterTest()
	public void conclusion() {

		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeAllBrowsers();
	}
}
