package com.ap.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.CalenderPage;
import com.ap.pages.EnterLocationPage;
import com.ap.pages.HomePage;
import com.ap.pages.ReasonForVisitPage;
import com.ap.pages.ScheduleAppointmentPage;
import com.ap.pages.SelectPharmacyPage;


public class AppointmentTest extends TestBase{

	HomePage hp;
	ScheduleAppointmentPage sap;
	EnterLocationPage elp;
	SelectPharmacyPage spp;
	ReasonForVisitPage rfv;
	CalenderPage cp;
	
	@BeforeTest
	public void initializedriver() throws IOException{
		driver=initialization();
	}
	
	@Test
	public void PharmacyAppointment() throws InterruptedException{
		driver.get(propt.getProperty("url"));
		Thread.sleep(3000);
		WebDriverWait wait =new WebDriverWait(driver,8);
		hp=new HomePage(driver);
		hp.scheduler().click();;
		
		sap= new ScheduleAppointmentPage(driver);
		
		sap.clickOnScheduleNow().click();
		
		elp= new EnterLocationPage(driver);
		Select sel= new Select(elp.selectAge());
		sel.selectByVisibleText("26");
		
		Thread.sleep(3000);
		WebElement e=elp.enterZipcode();
		e.sendKeys(Keys.CONTROL+("a"));
		e.sendKeys(Keys.DELETE);
		
		Thread.sleep(3000);
		e.sendKeys("11106");
		/*elp.enterZipcode().click();
		elp.enterZipcode().clear();
		Thread.sleep(3000);
		elp.enterZipcode().sendKeys("11106");
		elp.enterZipcode().clear();
		Thread.sleep(4000);*/
		elp.clickContinue().click();
		
		spp=new SelectPharmacyPage(driver);
		spp.enterAddress().click();
		Thread.sleep(3000);
		spp.enterAddress().clear();
		spp.enterAddress().sendKeys("11106, Queens");
		spp.clickSearchButton().click();
		Thread.sleep(4000);
		spp.clickRadio().click();
		rfv=new ReasonForVisitPage(driver);
		Thread.sleep(3000);
		rfv.MedicationReviewButton().click();
		Thread.sleep(3000);
		rfv.ContinueButton().click();
		cp=new CalenderPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(cp.clickdate()));
		cp.clickdate().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) cp.clicktime()));
		
		cp.clicktime().click();
		
		cp.clickcontinue();
		Thread.sleep(3000);
		
	}
	
	
	
}
