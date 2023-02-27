package com.excelr.ProjectWebMath.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.excelr.ProjectWebMath.Common.FileHandler;
import com.excelr.ProjectWebMath.Common.WaitTime;

public class OtherStuff {

	private WebDriver driver;

	public OtherStuff(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void AverageValue() {

		String average = FileHandler.getPropertyValue("other", "average");
		String rawInput = FileHandler.getPropertyValue("other", "rawInput");
		String input1 = FileHandler.getPropertyValue("other", "input1");
		String input2 = FileHandler.getPropertyValue("other", "input2");
		String input3 = FileHandler.getPropertyValue("other", "input3");
		String input4 = FileHandler.getPropertyValue("other", "input4");
		String input5 = FileHandler.getPropertyValue("other", "input5");
		String input6 = FileHandler.getPropertyValue("other", "input6");
		String radio = FileHandler.getPropertyValue("other", "radio");
		String find = FileHandler.getPropertyValue("other", "find");

		driver.findElement(By.xpath(average)).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();

		WebElement input = driver.findElement(By.name(rawInput));
		input.click();
		input.sendKeys(input1);
		input.sendKeys(Keys.ENTER);
		input.sendKeys(input2);
		input.sendKeys(Keys.ENTER);
		input.sendKeys(input3);
		input.sendKeys(Keys.ENTER);
		input.sendKeys(input4);
		input.sendKeys(Keys.ENTER);
		input.sendKeys(input5);
		input.sendKeys(Keys.ENTER);
		input.sendKeys(input6);
		input.sendKeys(Keys.ENTER);
		WaitTime.waitTimeInSec(1);

		driver.findElement(By.xpath(radio)).click();
		WaitTime.waitTimeInSec(2);
		driver.findElement(By.xpath(find)).click();
		action.scrollByAmount(0, 150).build().perform();
	}

	public void BasicMathWorksheet() {

		String basicMath = FileHandler.getPropertyValue("other", "basicMath");
		String probType = FileHandler.getPropertyValue("other", "probType");
		String numType = FileHandler.getPropertyValue("other", "numType");
		String maximumNum = FileHandler.getPropertyValue("other", "maximumNum");
		String decimals = FileHandler.getPropertyValue("other", "decimals");
		String totalProblems = FileHandler.getPropertyValue("other", "totalProblems");
		String problemType = FileHandler.getPropertyValue("other", "problemType");
		String numberType = FileHandler.getPropertyValue("other", "numberType");
		String maxNum = FileHandler.getPropertyValue("other", "maxNum");
		String decimalDigits = FileHandler.getPropertyValue("other", "decimalDigits");
		String numProblems = FileHandler.getPropertyValue("other", "numProblems");
		String doButton = FileHandler.getPropertyValue("other", "doButton");

		driver.findElement(By.xpath(basicMath)).click();
		Actions a = new Actions(driver);
		a.scrollByAmount(0, 250).build().perform();
		
		WebElement prob = driver.findElement(By.name(problemType));
		prob.click();
		Select typeProb = new Select(prob);
		typeProb.selectByVisibleText(probType);
		
		WebElement num = driver.findElement(By.name(numberType));
		num.click();
		Select typeNum = new Select(num);
		typeNum.selectByVisibleText(numType);
		
		WebElement max = driver.findElement(By.name(maxNum));
		max.clear();
		max.sendKeys(maximumNum);
		
		WebElement deci = driver.findElement(By.name(decimalDigits));
		deci.clear();
		deci.sendKeys(decimals);
		
		WebElement probTotal = driver.findElement(By.name(numProblems));
		probTotal.clear();
		probTotal.sendKeys(totalProblems);
		
		WaitTime.waitTimeInSec(2);
		driver.findElement(By.xpath(doButton)).click();
		a.scrollByAmount(0,150).build().perform();
		WaitTime.waitTimeInSec(2);
	}
}
