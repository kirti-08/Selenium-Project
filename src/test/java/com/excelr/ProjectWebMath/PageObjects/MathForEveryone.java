package com.excelr.ProjectWebMath.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.excelr.ProjectWebMath.Common.FileHandler;
import com.excelr.ProjectWebMath.Common.WaitTime;

public class MathForEveryone {

	private WebDriver driver;

	public MathForEveryone(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void SimpleInterest() {

		String simple = FileHandler.getPropertyValue("everyone", "simple");
		String loanAmt = FileHandler.getPropertyValue("everyone", "loanAmt");
		String intPercent = FileHandler.getPropertyValue("everyone", "intPercent");
		String intPerDuration = FileHandler.getPropertyValue("everyone", "intPerDuration");
		String loanYears = FileHandler.getPropertyValue("everyone", "loanYears");
		String loanTimeIn = FileHandler.getPropertyValue("everyone", "loanTimeIn");
		String loan = FileHandler.getPropertyValue("everyone", "loan");
		String intRate = FileHandler.getPropertyValue("everyone", "intRate");
		String intUnit = FileHandler.getPropertyValue("everyone", "intUnit");
		String loanPeriod = FileHandler.getPropertyValue("everyone", "loanPeriod");
		String loanPeriodUnit = FileHandler.getPropertyValue("everyone", "loanPeriodUnit");
		String find = FileHandler.getPropertyValue("everyone", "find");

		driver.findElement(By.xpath(simple)).click();
		Actions a = new Actions(driver);
		a.scrollByAmount(0, 100).build().perform();
		driver.findElement(By.name(loan)).sendKeys(loanAmt);
		driver.findElement(By.name(intRate)).sendKeys(intPercent);
		driver.findElement(By.name(loanPeriod)).sendKeys(loanYears);
		WaitTime.waitTimeInSec(1);

		WebElement interest = driver.findElement(By.name(intUnit));
		interest.click();
		WaitTime.waitTimeInSec(1);
		Select interestUnit = new Select(interest);
		interestUnit.selectByVisibleText(intPerDuration);

		WebElement years = driver.findElement(By.name(loanPeriodUnit));
		years.click();
		WaitTime.waitTimeInSec(1);
		Select yearsUnit = new Select(years);
		yearsUnit.selectByVisibleText(loanTimeIn);

		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(find)).click();
		a.scrollByAmount(0, 100).build().perform();
	}

	public void OtherPlanetWeight() {

		String otherPlanet = FileHandler.getPropertyValue("everyone", "otherPlanet");
		String weight = FileHandler.getPropertyValue("everyone", "weight");
		String planetDrop = FileHandler.getPropertyValue("everyone", "planetDrop");
		String submit = FileHandler.getPropertyValue("everyone", "submit");
		String weightInput = FileHandler.getPropertyValue("everyone", "weightInput");
		String planetInput = FileHandler.getPropertyValue("everyone", "planetInput");

		driver.findElement(By.xpath(otherPlanet)).click();
		driver.findElement(By.name(weight)).sendKeys(weightInput);
		WebElement planet = driver.findElement(By.name(planetDrop));
		planet.click();
		Select planetSelect = new Select(planet);
		planetSelect.selectByVisibleText(planetInput);
		WaitTime.waitTimeInSec(2);
		driver.findElement(By.xpath(submit)).click();
		Actions a = new Actions(driver);
		a.scrollByAmount(0, 100).build().perform();
	}
}
