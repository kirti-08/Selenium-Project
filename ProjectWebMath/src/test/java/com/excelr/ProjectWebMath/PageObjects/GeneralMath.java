package com.excelr.ProjectWebMath.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GeneralMath {
	
private WebDriver driver;
	
	public GeneralMath(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
