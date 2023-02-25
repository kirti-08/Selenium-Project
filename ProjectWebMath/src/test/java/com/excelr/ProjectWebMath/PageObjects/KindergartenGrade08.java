package com.excelr.ProjectWebMath.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class KindergartenGrade08 {
	
private WebDriver driver;
	
	public KindergartenGrade08(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
