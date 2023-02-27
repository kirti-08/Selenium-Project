package com.excelr.ProjectWebMath.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.excelr.ProjectWebMath.Common.FileHandler;
import com.excelr.ProjectWebMath.Common.WaitTime;

public class KindergartenGrade08 {
	
private WebDriver driver;
	
	public KindergartenGrade08(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void FractionStudy() {
		String fraction = FileHandler.getPropertyValue("kinder", "fraction");
		String num = FileHandler.getPropertyValue("kinder", "num");
		String deno = FileHandler.getPropertyValue("kinder", "deno");
		String buttonFraction = FileHandler.getPropertyValue("kinder", "buttonFraction");
		String denominator = FileHandler.getPropertyValue("kinder", "denominator");
		String numerator = FileHandler.getPropertyValue("kinder", "numerator");
		
		driver.findElement(By.xpath(fraction)).click();
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.name(num)).sendKeys(numerator);
		driver.findElement(By.name(deno)).sendKeys(denominator);
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(buttonFraction)).click();
	}

	public void RectangleStudy() {
		String rectangle = FileHandler.getPropertyValue("kinder", "rectangle");
		String width = FileHandler.getPropertyValue("kinder", "width");
		String height = FileHandler.getPropertyValue("kinder", "height");
		String tellMore = FileHandler.getPropertyValue("kinder", "tellMore");
		String wid = FileHandler.getPropertyValue("kinder", "wid");
		String ht = FileHandler.getPropertyValue("kinder", "ht");
		String measure = FileHandler.getPropertyValue("kinder", "measure");
		String cm = FileHandler.getPropertyValue("kinder", "cm");
		
		driver.findElement(By.xpath(rectangle)).click();
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.name(width)).sendKeys(wid);
		driver.findElement(By.name(height)).sendKeys(ht);
		
		WebElement units = driver.findElement(By.name(measure));
		units.click();
		Select unit = new Select(units);
		List<WebElement> allUnits = unit.getOptions();
		for(WebElement eachUnit : allUnits) {
			if(eachUnit.getText().equalsIgnoreCase(cm)) {
				eachUnit.click();
				break;
			}
		}
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(tellMore)).click();
	}
}
