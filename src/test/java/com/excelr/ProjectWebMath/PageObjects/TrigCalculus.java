package com.excelr.ProjectWebMath.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.excelr.ProjectWebMath.Common.FileHandler;
import com.excelr.ProjectWebMath.Common.WaitTime;

public class TrigCalculus {
	private WebDriver driver;

	public TrigCalculus(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String triangle = FileHandler.getPropertyValue("trignometry", "triangle");
	String a = FileHandler.getPropertyValue("trignometry", "a");
	String b = FileHandler.getPropertyValue("trignometry", "b");
	String aValue = FileHandler.getPropertyValue("trignometry", "aValue");
	String bValue = FileHandler.getPropertyValue("trignometry", "bValue");
	String find = FileHandler.getPropertyValue("trignometry", "find");
	String leg_a = FileHandler.getPropertyValue("trignometry", "leg_a");
	String leg_b = FileHandler.getPropertyValue("trignometry", "leg_b");
	
	public void FindHypotenuse() {

		String cValue = FileHandler.getPropertyValue("trignometry", "cValue");
		String leg_c = FileHandler.getPropertyValue("trignometry", "leg_c");
		
		driver.findElement(By.xpath(triangle)).click();
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 100).build().perform();

		driver.findElement(By.name(leg_a)).sendKeys(aValue);
		driver.findElement(By.name(leg_b)).sendKeys(bValue);
		driver.findElement(By.name(leg_c)).sendKeys(cValue);
		WaitTime.waitTimeInSec(2);
		driver.findElement(By.xpath(find)).click();
	}

	public void FindUnknownValue() {

		String dValue = FileHandler.getPropertyValue("trignometry", "dValue");
		String eValue = FileHandler.getPropertyValue("trignometry", "eValue");
		String leg_d = FileHandler.getPropertyValue("trignometry", "leg_d");
		String leg_e = FileHandler.getPropertyValue("trignometry", "leg_e");
		
		driver.findElement(By.xpath(triangle)).click();
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 100).build().perform();

		driver.findElement(By.name(leg_a)).sendKeys(aValue);
		driver.findElement(By.name(leg_b)).sendKeys(bValue);
		driver.findElement(By.name(leg_d)).sendKeys(dValue);
		driver.findElement(By.name(leg_e)).sendKeys(eValue);
		WaitTime.waitTimeInSec(2);
		driver.findElement(By.xpath(find)).click();
	}
}
