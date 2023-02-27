package com.excelr.ProjectWebMath.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.excelr.ProjectWebMath.Common.FileHandler;
import com.excelr.ProjectWebMath.Common.WaitTime;

public class GeneralMath {
	private WebDriver driver;

	public GeneralMath(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void FractionReduce() {

		String reduce = FileHandler.getPropertyValue("general", "reduce");
		String top = FileHandler.getPropertyValue("general", "top");
		String bottom = FileHandler.getPropertyValue("general", "bottom");
		String reduceIt = FileHandler.getPropertyValue("general", "reduceIt");
		String reduceTop = FileHandler.getPropertyValue("general", "reduceTop");
		String reduceBottom = FileHandler.getPropertyValue("general", "reduceBottom");
		
		driver.findElement(By.xpath(reduce)).click();
		WebElement above = driver.findElement(By.name(top));
		above.clear();
		above.sendKeys(reduceTop);
		WebElement below = driver.findElement(By.name(bottom));
		below.clear();
		below.sendKeys(reduceBottom);
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(reduceIt)).click();
	}

	public void FactoringInteger() {

		String factor = FileHandler.getPropertyValue("general", "factor");
		String type = FileHandler.getPropertyValue("general", "type");
		String prime = FileHandler.getPropertyValue("general", "prime");
		String number = FileHandler.getPropertyValue("general", "number");
		String parameter = FileHandler.getPropertyValue("general", "parameter");
		String factorIt = FileHandler.getPropertyValue("general", "factorIt");
	
		driver.findElement(By.xpath(factor)).click();
		
		WebElement fact = driver.findElement(By.name(type));
		fact.click();
		Select factorType = new Select(fact);
		List<WebElement> allTypes = factorType.getOptions();
		for(WebElement eachType : allTypes) {
			if(eachType.getText().equalsIgnoreCase(prime)) {
				eachType.click();
				break;
			}
		}
		driver.findElement(By.name(parameter)).sendKeys(number);
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(factorIt)).click();
	}

	public void ClearForm() {

		String add = FileHandler.getPropertyValue("general", "add");
		String atop1 = FileHandler.getPropertyValue("general", "atop1");
		String abottom1 = FileHandler.getPropertyValue("general", "abottom1");
		String atop2 = FileHandler.getPropertyValue("general", "atop2");
		String abottom2 = FileHandler.getPropertyValue("general", "abottom2");
		String bwhole1 = FileHandler.getPropertyValue("general", "bwhole1");
		String btop1 = FileHandler.getPropertyValue("general", "btop1");
		String bbottom1 = FileHandler.getPropertyValue("general", "bbottom1");
		String btop2 = FileHandler.getPropertyValue("general", "btop2");
		String bbottom2 = FileHandler.getPropertyValue("general", "bbottom2");
		String cwhole1 = FileHandler.getPropertyValue("general", "cwhole1");
		String cwhole2 = FileHandler.getPropertyValue("general", "cwhole2");
		String ctop2 = FileHandler.getPropertyValue("general", "ctop2");
		String cbottom2 = FileHandler.getPropertyValue("general", "cbottom2");
		String ctop1 = FileHandler.getPropertyValue("general", "ctop1");
		String cbottom1 = FileHandler.getPropertyValue("general", "cbottom1");
		String clear = FileHandler.getPropertyValue("general", "clear");
		String a1 = FileHandler.getPropertyValue("general", "a1");
		String a2 = FileHandler.getPropertyValue("general", "a2");
		String a3 = FileHandler.getPropertyValue("general", "a3");
		String a4 = FileHandler.getPropertyValue("general", "a4");
		String b1 = FileHandler.getPropertyValue("general", "b1");
		String b2 = FileHandler.getPropertyValue("general", "b2");
		String b3 = FileHandler.getPropertyValue("general", "b3");
		String b4 = FileHandler.getPropertyValue("general", "b4");
		String b5 = FileHandler.getPropertyValue("general", "b5");
		String c1 = FileHandler.getPropertyValue("general", "c1");
		String c2 = FileHandler.getPropertyValue("general", "c2");
		String c3 = FileHandler.getPropertyValue("general", "c3");
		String c4 = FileHandler.getPropertyValue("general", "c4");
		String c5 = FileHandler.getPropertyValue("general", "c5");
		String c6 = FileHandler.getPropertyValue("general", "c6");
		
		driver.findElement(By.xpath(add)).click();
		driver.findElement(By.name(atop1)).sendKeys(a1);
		driver.findElement(By.name(abottom1)).sendKeys(a2);
		driver.findElement(By.name(atop2)).sendKeys(a3);
		driver.findElement(By.name(abottom2)).sendKeys(a4);
		driver.findElement(By.name(bwhole1)).sendKeys(b1);
		driver.findElement(By.name(btop1)).sendKeys(b2);
		driver.findElement(By.name(bbottom1)).sendKeys(b3);
		driver.findElement(By.name(btop2)).sendKeys(b4);
		driver.findElement(By.name(bbottom2)).sendKeys(b5);
		driver.findElement(By.name(cwhole1)).sendKeys(c1);
		driver.findElement(By.name(ctop1)).sendKeys(c2);
		driver.findElement(By.name(cbottom1)).sendKeys(c3);
		driver.findElement(By.name(cwhole2)).sendKeys(c4);
		driver.findElement(By.name(ctop2)).sendKeys(c5);
		driver.findElement(By.name(cbottom2)).sendKeys(c6);
		
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(clear)).click();
	}
}
