package com.excelr.ProjectWebMath.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.excelr.ProjectWebMath.Common.FileHandler;
import com.excelr.ProjectWebMath.Common.WaitTime;

public class PlotsGeometry {
	private WebDriver driver;
	
	public PlotsGeometry(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void CircleStudy() {
		
		String circle = FileHandler.getPropertyValue("geometry", "circle");
		String known = FileHandler.getPropertyValue("geometry", "known");
		String want = FileHandler.getPropertyValue("geometry", "want");
		String input = FileHandler.getPropertyValue("geometry", "input");
		String find = FileHandler.getPropertyValue("geometry", "find");
		String radius = FileHandler.getPropertyValue("geometry", "radius");
		String valueKnown = FileHandler.getPropertyValue("geometry", "valueKnown");
		String valueWant = FileHandler.getPropertyValue("geometry", "valueWant");
		
		driver.findElement(By.xpath(circle)).click();
		
		WebElement know = driver.findElement(By.name(known));
		know.click();
		Select optionRadius = new Select(know);
		List<WebElement> allOptions = optionRadius.getOptions();
		for(WebElement eachOption : allOptions) {
			if(eachOption.getText().equalsIgnoreCase(valueKnown)) {
				eachOption.click();
				break;
			}
		}
		
		driver.findElement(By.name(input)).sendKeys(radius);
		
		WebElement give = driver.findElement(By.name(want));
		give.click();
		Select optionDiameter = new Select(give);
		List<WebElement> allChoices = optionDiameter.getOptions();
		for(WebElement eachChoice : allChoices) {
			if(eachChoice.getText().equalsIgnoreCase(valueWant)) {
				eachChoice.click();
				break;
			}
		}
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(find)).click();
	}

   public void RightTriangle() {
		
	   String triangle = FileHandler.getPropertyValue("geometry", "triangle");
	   String base = FileHandler.getPropertyValue("geometry", "base");
	   String height = FileHandler.getPropertyValue("geometry", "height");
	   String calculate = FileHandler.getPropertyValue("geometry", "calculate");
	   String doIt = FileHandler.getPropertyValue("geometry", "doIt");
	   String baseValue = FileHandler.getPropertyValue("geometry", "baseValue");
	   String heightValue = FileHandler.getPropertyValue("geometry", "heightValue");
	   String tell = FileHandler.getPropertyValue("geometry", "tell");
	   
	   driver.findElement(By.xpath(triangle)).click();
	   driver.findElement(By.name(base)).sendKeys(baseValue);
	   driver.findElement(By.name(height)).sendKeys(heightValue);
	   WebElement want = driver.findElement(By.name(calculate));
	   Select find = new Select(want);
	   List<WebElement> allOptions = find.getOptions();
	   for(WebElement eachOption : allOptions) {
		   if(eachOption.getText().equalsIgnoreCase(tell)) {
			   eachOption.click();
			   break;
		   }
	   }
	   WaitTime.waitTimeInSec(1);
	   driver.findElement(By.xpath(doIt)).click();
	}
   
   public void LineGraph() {
		
	   String line = FileHandler.getPropertyValue("geometry", "line");
	   String input0 = FileHandler.getPropertyValue("geometry", "input0");
	   String input1 = FileHandler.getPropertyValue("geometry", "input1");
	   String input2 = FileHandler.getPropertyValue("geometry", "input2");
	   String plotIt = FileHandler.getPropertyValue("geometry", "plotIt");
	   String value0 = FileHandler.getPropertyValue("geometry", "value0");
	   String value1 = FileHandler.getPropertyValue("geometry", "value1");
	   String value2 = FileHandler.getPropertyValue("geometry", "value2");
	   
	   driver.findElement(By.xpath(line)).click();
	   driver.findElement(By.name(input0)).sendKeys(value0);
	   driver.findElement(By.name(input1)).sendKeys(value1);
	   driver.findElement(By.name(input2)).sendKeys(value2);
	   WaitTime.waitTimeInSec(2);
	   driver.findElement(By.xpath(plotIt)).click();
	}
}
