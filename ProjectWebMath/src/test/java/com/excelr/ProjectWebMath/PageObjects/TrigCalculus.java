package com.excelr.ProjectWebMath.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TrigCalculus {

private WebDriver driver;
	
	public TrigCalculus(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
