package com.excelr.ProjectWebMath.TestRunner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excelr.ProjectWebMath.Common.BrowserFactory;
import com.excelr.ProjectWebMath.Common.FileHandler;
import com.excelr.ProjectWebMath.Common.WaitTime;
import com.excelr.ProjectWebMath.PageObjects.GeneralMath;
import com.excelr.ProjectWebMath.PageObjects.HomePage;

public class GeneralMathTest {

	private WebDriver driver;
	String browser, url;
	
	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("general", "browsername");
		url = FileHandler.getPropertyValue("general", "url");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);

		HomePage home = new HomePage(driver);
		home.clickGeneralMath();
	}

	@Test(priority = 1)
	public void onlyNumericInputToReduceFraction() {

		GeneralMath general = new GeneralMath(driver);
		general.FractionReduce();
		WaitTime.waitTimeInSec(5);
		BrowserFactory.closeCurrentWindow();
	}

	@Test(priority = 2)
	public void onlyIntegerForFactoring() {
		
		GeneralMath general = new GeneralMath(driver);
		general.FactoringInteger();		
		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeCurrentWindow();
	}
	
	@Test(priority = 3)
	public void validateClearFormButtoninAddFractions() {
		
		GeneralMath general = new GeneralMath(driver);
		general.ClearForm();
	}

	@AfterTest()
	public void conclusion() {

		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeAllBrowsers();
	}
}
