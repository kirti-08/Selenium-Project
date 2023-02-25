package com.excelr.ProjectWebMath.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.excelr.ProjectWebMath.Common.FileHandler;

public class QuickHelp {

	private WebDriver driver;

	public QuickHelp(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void convertCelciusToFarenheit() {
		String temperature = FileHandler.getPropertyValue("quick", "temperature");
		String quick = FileHandler.getPropertyValue("quick", "quick");

		WebElement quickHelp = driver.findElement(By.id(quick));
		quickHelp.click();

		Select help = new Select(quickHelp);
		List<WebElement> allOptions = help.getOptions();
		for (WebElement eachOption : allOptions) {
			if (eachOption.getText().equals(temperature)) {
				eachOption.click();
				break;
			}
		}
	}

	public void fractionToDecimal() {
		String fraction = FileHandler.getPropertyValue("quick", "fraction");
		String quick = FileHandler.getPropertyValue("quick", "quick");

		WebElement quickHelp = driver.findElement(By.id(quick));
		quickHelp.click();

		Select help = new Select(quickHelp);
		List<WebElement> allOptions = help.getOptions();
		for (WebElement eachOption : allOptions) {
			if (eachOption.getText().equals(fraction)) {
				eachOption.click();
				break;
			}
		}
	}
}