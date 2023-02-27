package com.excelr.ProjectWebMath.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.excelr.ProjectWebMath.Common.FileHandler;
import com.excelr.ProjectWebMath.Common.WaitTime;

public class QuickHelp {

	private WebDriver driver;

	public QuickHelp(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void convertCelciusToFarenheit() {

		String input = FileHandler.getPropertyValue("quick", "input");
		String from = FileHandler.getPropertyValue("quick", "from");
		String to = FileHandler.getPropertyValue("quick", "to");
		String convert = FileHandler.getPropertyValue("quick", "convert");
		String inputTemp = FileHandler.getPropertyValue("quick", "inputTemp");
		String temperature = FileHandler.getPropertyValue("quick", "temperature");
		String quick = FileHandler.getPropertyValue("quick", "quick");

		WebElement quickHelp = driver.findElement(By.id(quick));
		quickHelp.click();
		WaitTime.waitTimeInSec(1);

		Select help = new Select(quickHelp);
		List<WebElement> allOptions = help.getOptions();
		for (WebElement eachOption : allOptions) {
			if (eachOption.getText().equals(temperature)) {
				eachOption.click();
				break;
			}
		}
		driver.findElement(By.xpath(input)).sendKeys(inputTemp);
		driver.findElement(By.xpath(from)).click();
		driver.findElement(By.xpath(to)).click();
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(convert)).click();
	}

	public void fractionToDecimal() {

		String numerator = FileHandler.getPropertyValue("quick", "numerator");
		String denominator = FileHandler.getPropertyValue("quick", "denominator");
		String decimals = FileHandler.getPropertyValue("quick", "decimals");
		String convertIt = FileHandler.getPropertyValue("quick", "convertIt");
		String fractionBottom = FileHandler.getPropertyValue("quick", "fractionBottom");
		String fractionTop = FileHandler.getPropertyValue("quick", "fractionTop");
		String decimalPlaces = FileHandler.getPropertyValue("quick", "decimalPlaces");
		String fraction = FileHandler.getPropertyValue("quick", "fraction");
		String quick = FileHandler.getPropertyValue("quick", "quick");

		WebElement quickHelp = driver.findElement(By.id(quick));
		quickHelp.click();
		WaitTime.waitTimeInSec(1);

		Select help = new Select(quickHelp);
		List<WebElement> allOptions = help.getOptions();
		for (WebElement eachOption : allOptions) {
			if (eachOption.getText().equals(fraction)) {
				eachOption.click();
				break;
			}
		}
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
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(convertIt)).click();
	}
}