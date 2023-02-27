package com.excelr.ProjectWebMath.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="topicItem")
	private WebElement quick;
	
	@FindBy(id="navBox-0")
	private WebElement tabHome;
	
	@FindBy(id="navBox-1")
	private WebElement tabMathEveryone;
	
	@FindBy(id="navBox-2")
	private WebElement tabGeneral;
	
	@FindBy(id="navBox-3")
	private WebElement tabK8;
	
	@FindBy(id="navBox-5")
	private WebElement tabGeometry;
	
	@FindBy(id="navBox-6")
	private WebElement tabTrig;
	
	@FindBy(id="navBox-7")
	private WebElement tabOther;
	
	public QuickHelp clickQuickHelp() {
		quick.click();
		return new QuickHelp(driver);
	}
	
	public GeneralMath clickGeneralMath() {
		tabGeneral.click();
		return new GeneralMath(driver);
	}
	
	public KindergartenGrade08 clickK8() {
		tabK8.click();
		return new KindergartenGrade08(driver);
	}
	
	public MathForEveryone clickMathEveryone() {
		tabMathEveryone.click();
		return new MathForEveryone(driver);
	}
	
	public OtherStuff clickOtherStuff() {
		tabOther.click();
		return new OtherStuff(driver);
	}
	
	public PlotsGeometry clickPlotsGeometry() {
		tabGeometry.click();
		return new PlotsGeometry(driver);
	}
	
	public TrigCalculus clickTrigCalculus() {
		tabTrig.click();
		return new TrigCalculus(driver);
	}

}
