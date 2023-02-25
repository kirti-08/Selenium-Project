package com.excelr.ProjectWebMath.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PlotsGeometry {
	
private WebDriver driver;
	
	public PlotsGeometry(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
