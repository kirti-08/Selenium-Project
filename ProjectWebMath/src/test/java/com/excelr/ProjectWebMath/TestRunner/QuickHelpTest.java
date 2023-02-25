package com.excelr.ProjectWebMath.TestRunner;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excelr.ProjectWebMath.Common.BrowserFactory;
import com.excelr.ProjectWebMath.Common.FileHandler;
import com.excelr.ProjectWebMath.Common.WaitTime;
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

		driver.findElement(By.id(quick)).click();
	}

	@Test()
	public void convertTemperature() {

		String input, from, to, convert, inputTemp;

		input = FileHandler.getPropertyValue("quick", "input");
		from = FileHandler.getPropertyValue("quick", "from");
		to = FileHandler.getPropertyValue("quick", "to");
		convert = FileHandler.getPropertyValue("quick", "convert");
		inputTemp = FileHandler.getPropertyValue("quick", "inputTemp");

		QuickHelp quickHelp = new QuickHelp(driver);
		quickHelp.convertCelciusToFarenheit();
		driver.findElement(By.xpath(input)).sendKeys(inputTemp);
		driver.findElement(By.xpath(from)).click();
		driver.findElement(By.xpath(to)).click();
		driver.findElement(By.xpath(convert)).click();
	}

	@Test()
	public void inputZeroUnacceptableForFractionToDecimal() {
		
		String numerator, denominator, decimals, convertIt, fractionTop, fractionBottom, decimalPlaces;

		numerator = FileHandler.getPropertyValue("quick", "numerator");
		denominator = FileHandler.getPropertyValue("quick", "denominator");
		decimals = FileHandler.getPropertyValue("quick", "decimals");
		convertIt = FileHandler.getPropertyValue("quick", "convertIt");
		fractionBottom = FileHandler.getPropertyValue("quick", "fractionBottom");
		fractionTop = FileHandler.getPropertyValue("quick", "fractionTop");
		decimalPlaces = FileHandler.getPropertyValue("quick", "decimalPlaces");
		
		QuickHelp quickHelp = new QuickHelp(driver);
		quickHelp.fractionToDecimal();
		WebElement num = driver.findElement(By.name(fractionTop));
		num.click();
		num.clear();
		num.sendKeys(numerator);
		WebElement denom = driver.findElement(By.name(fractionBottom));
		denom.click();
		denom.clear();
		denom.sendKeys(denominator);
		WebElement deci = driver.findElement(By.name(decimalPlaces));
		deci.click();
		deci.clear();
		deci.sendKeys(decimals);
		driver.findElement(By.xpath(convertIt)).click();
	}

	@AfterTest()
	public void conclusion() {

		WaitTime.waitTimeInSec(3);
		BrowserFactory.closeAllBrowsers();
	}
}
