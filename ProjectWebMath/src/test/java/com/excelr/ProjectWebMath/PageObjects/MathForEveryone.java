package com.excelr.ProjectWebMath.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MathForEveryone {

private WebDriver driver;
	
	public MathForEveryone(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
