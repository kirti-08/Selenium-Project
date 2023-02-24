package com.excelr.ProjectOrangeHrm.TestScenario;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excelr.ProjectOrangeHrm.Common.BrowserFactory;
import com.excelr.ProjectOrangeHrm.Common.FileHandler;
import com.excelr.ProjectOrangeHrm.Common.WaitTime;

public class TS_06_VerifyRecruitment {

	private WebDriver driver;
	String browser, url, adminUser, adminPass, username, password, loginButton, recruitmentTab, vacancies, addVacancy,
			vacancyName, newVacancy, jobTitle, hiringMan, hiringManInput, saveVacancy, positions, noOfPositions,
			addCandidate, candidates, firstName, midName, lastName, emailId, fName, lName, mName, email, selectVacancy,
			saveCandidate, openVacancy, editVacancy, vacancyStatus, closeVacancy, cancelVacancy, appStatus, viewStatus,
			reject, saveReject;

	@BeforeTest()
	public void dataReader() {

		browser = FileHandler.getPropertyValue("recruitment", "browsername");
		url = FileHandler.getPropertyValue("recruitment", "url");

		adminUser = FileHandler.getPropertyValue("recruitment", "adminUser");
		adminPass = FileHandler.getPropertyValue("recruitment", "adminPass");
		username = FileHandler.getPropertyValue("recruitment", "username");
		password = FileHandler.getPropertyValue("recruitment", "password");
		recruitmentTab = FileHandler.getPropertyValue("recruitment", "recruitmentTab");
		loginButton = FileHandler.getPropertyValue("recruitment", "loginButton");
		vacancies = FileHandler.getPropertyValue("recruitment", "vacancies");
		addVacancy = FileHandler.getPropertyValue("recruitment", "addVacancy");
		vacancyName = FileHandler.getPropertyValue("recruitment", "vacancyName");
		newVacancy = FileHandler.getPropertyValue("recruitment", "newVacancy");
		jobTitle = FileHandler.getPropertyValue("recruitment", "jobTitle");
		hiringMan = FileHandler.getPropertyValue("recruitment", "hiringMan");
		hiringManInput = FileHandler.getPropertyValue("recruitment", "hiringManInput");
		saveVacancy = FileHandler.getPropertyValue("recruitment", "saveVacancy");
		positions = FileHandler.getPropertyValue("recruitment", "positions");
		noOfPositions = FileHandler.getPropertyValue("recruitment", "noOfPositions");
		addCandidate = FileHandler.getPropertyValue("recruitment", "addCandidate");
		candidates = FileHandler.getPropertyValue("recruitment", "candidates");
		firstName = FileHandler.getPropertyValue("recruitment", "firstName");
		midName = FileHandler.getPropertyValue("recruitment", "lastName");
		lastName = FileHandler.getPropertyValue("recruitment", "midName");
		emailId = FileHandler.getPropertyValue("recruitment", "emailId");
		fName = FileHandler.getPropertyValue("recruitment", "fName");
		mName = FileHandler.getPropertyValue("recruitment", "lName");
		lName = FileHandler.getPropertyValue("recruitment", "mName");
		email = FileHandler.getPropertyValue("recruitment", "email");
		selectVacancy = FileHandler.getPropertyValue("recruitment", "selectVacancy");
		saveCandidate = FileHandler.getPropertyValue("recruitment", "saveCandidate");
		openVacancy = FileHandler.getPropertyValue("recruitment", "openVacancy");
		editVacancy = FileHandler.getPropertyValue("recruitment", "editVacancy");
		vacancyStatus = FileHandler.getPropertyValue("recruitment", "vacancyStatus");
		closeVacancy = FileHandler.getPropertyValue("recruitment", "closeVacancy");
		cancelVacancy = FileHandler.getPropertyValue("recruitment", "cancelVacancy");
		appStatus = FileHandler.getPropertyValue("recruitment", "appStatus");
		viewStatus = FileHandler.getPropertyValue("recruitment", "viewStatus");
		reject = FileHandler.getPropertyValue("recruitment", "reject");
		saveReject = FileHandler.getPropertyValue("recruitment", "saveReject");
	}

	@BeforeMethod()
	public void preCondition() {

		this.driver = BrowserFactory.getBrowser(browser);
		BrowserFactory.OpenUrl(url);
	}

	@Test()
	public void case01_AddNewVacancy() {

		WebElement loginName = driver.findElement(By.xpath(username));
		WebElement loginPass = driver.findElement(By.xpath(password));
		loginName.sendKeys(adminUser);
		loginPass.sendKeys(adminPass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(recruitmentTab)).click();
		driver.findElement(By.xpath(vacancies)).click();
		WebElement manager = driver.findElement(By.xpath(hiringMan));
		String hireMan = manager.getText();

		driver.findElement(By.xpath(addVacancy)).click();
		driver.findElement(By.xpath(vacancyName)).sendKeys(newVacancy);
		driver.findElement(By.xpath(jobTitle)).click();
		new Actions(driver);
		try {
			Robot r = new Robot();
			for (int i = 1; i < 5; i++) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				WaitTime.waitTimeInSec(1);
			}
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			WaitTime.waitTimeInSec(1);

			for (int i = 1; i < 5; i++) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(hiringManInput)).sendKeys(hireMan);
		driver.findElement(By.xpath(positions)).sendKeys(noOfPositions);
		driver.findElement(By.xpath(saveVacancy)).click();
	}

	@Test()
	public void case02_AddCandidateForOpenVacancy() {

		WebElement loginName = driver.findElement(By.xpath(username));
		WebElement loginPass = driver.findElement(By.xpath(password));
		loginName.sendKeys(adminUser);
		loginPass.sendKeys(adminPass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(recruitmentTab)).click();
		driver.findElement(By.xpath(candidates)).click();

		Actions a = new Actions(driver);
		for (int i = 1; i < 5; i++) {
			a.sendKeys(Keys.ARROW_DOWN).build().perform();
		}
		driver.findElement(By.xpath(addCandidate)).click();

		driver.findElement(By.xpath(firstName)).sendKeys(fName);
		driver.findElement(By.xpath(midName)).sendKeys(mName);
		driver.findElement(By.xpath(lastName)).sendKeys(lName);
		driver.findElement(By.xpath(emailId)).sendKeys(email);

		try {
			Robot r = new Robot();
			for (int i = 1; i < 5; i++) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
			}
			driver.findElement(By.xpath(selectVacancy)).click();
			for (int i = 1; i < 3; i++) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				WaitTime.waitTimeInSec(1);
			}
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			WaitTime.waitTimeInSec(2);

			for (int i = 1; i < 6; i++) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(saveCandidate)).click();
		driver.findElement(By.xpath(candidates)).click();
		for (int i = 1; i < 3; i++) {
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
		}
	}

	@Test()
	public void case03_UnableToAddCandidateForClosedVacancy() {

		WebElement loginName = driver.findElement(By.xpath(username));
		WebElement loginPass = driver.findElement(By.xpath(password));
		loginName.sendKeys(adminUser);
		loginPass.sendKeys(adminPass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(recruitmentTab)).click();
		driver.findElement(By.xpath(vacancies)).click();
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();

		WebElement vacancyName = driver.findElement(By.xpath(openVacancy));
		String vacancy = vacancyName.getText();
		a.scrollByAmount(0, 50).build().perform();
		WaitTime.waitTimeInSec(1);

		WebElement vacStatus = driver.findElement(By.xpath(vacancyStatus));
		String activeClose = vacStatus.getText();
		if (activeClose.equalsIgnoreCase("Active") == true) {
			driver.findElement(By.xpath(editVacancy)).click();
			WaitTime.waitTimeInSec(1);
			driver.findElement(By.xpath(closeVacancy)).click();
			WaitTime.waitTimeInSec(1);
			driver.findElement(By.xpath(saveVacancy)).click();
		}
		System.out.println("closed vacancy is: " + vacancy);
		driver.findElement(By.xpath(candidates)).click();
		WaitTime.waitTimeInSec(2);
		a.scrollByAmount(0, 200).build().perform();
		driver.findElement(By.xpath(addCandidate)).click();

		driver.findElement(By.xpath(selectVacancy)).click();
		WaitTime.waitTimeInSec(5);
		driver.findElement(By.xpath(cancelVacancy)).click();
	}

	@Test()
	public void case04_UnableToModifyRejectedCandidateStatus() {

		WebElement loginName = driver.findElement(By.xpath(username));
		WebElement loginPass = driver.findElement(By.xpath(password));
		loginName.sendKeys(adminUser);
		loginPass.sendKeys(adminPass);
		driver.findElement(By.xpath(loginButton)).click();

		driver.findElement(By.xpath(recruitmentTab)).click();
		driver.findElement(By.xpath(candidates)).click();
		WaitTime.waitTimeInSec(2);
		Actions a = new Actions(driver);
		a.scrollByAmount(0, 300).build().perform();
		WebElement applicationStatus = driver.findElement(By.xpath(appStatus));
		String candidateStatus = applicationStatus.getText();
		WaitTime.waitTimeInSec(1);
		driver.findElement(By.xpath(viewStatus)).click();

		if (candidateStatus.equalsIgnoreCase("Rejected") == false) {
			WaitTime.waitTimeInSec(1);
			driver.findElement(By.xpath(reject)).click();
			WaitTime.waitTimeInSec(1);
			driver.findElement(By.xpath(saveReject)).click();
		}
		WaitTime.waitTimeInSec(2);
		for (int i = 1; i < 4; i++) {
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			WaitTime.waitTimeInSec(1);
		}
		for (int i = 1; i < 4; i++) {
			a.sendKeys(Keys.PAGE_UP).build().perform();
			WaitTime.waitTimeInSec(1);
		}
	}

	@AfterMethod()
	public void conclusion() {

		WaitTime.waitTimeInSec(5);
		BrowserFactory.closeAllBrowsers();
	}
}
