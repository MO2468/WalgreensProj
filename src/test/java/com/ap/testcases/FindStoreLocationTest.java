package com.ap.testcases;



import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.HomePage;
import com.ap.pages.LocatorPage;

public class FindStoreLocationTest extends TestBase{
	
	HomePage hp;
	LocatorPage lp;
	WebDriverWait wait;
	
	@BeforeTest
	public void intializeDriver() 
	{
		driver = initialization();
	}
	
	@Test
	public void findaStore() throws InterruptedException
	{
		//opjects of pages
		wait = new WebDriverWait(driver, 30);
		hp = new HomePage(driver);
		lp = new LocatorPage(driver);
		
		hp.getfindaStore().click();
		lp.getUpdateLocation().click();
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.textToBePresentInElement(lp.getLocationBox(), "11230"));
		lp.getLocationBox().sendKeys("11230");
		lp.getSearchButton().click();
	}
	
	@Test
	public void nearestStore()
	{
		
	}

}
