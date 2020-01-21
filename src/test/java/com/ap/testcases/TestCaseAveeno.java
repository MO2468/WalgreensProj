package com.ap.testcases;

import java.io.IOException;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.HomePage;
import com.ap.pages.SignInPage;

public class TestCaseAveeno extends TestBase{
	HomePage WHP;
	SignInPage sip;
	@BeforeTest
	public void initializer() throws IOException{
		driver=initialization();

	}

	@Test(enabled=false)
	public void validateRxRefillLinks() throws InterruptedException{
		driver.get(propt.getProperty("url"));
		WHP = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 15);//without explicit, its saying stale element
		Actions a = new Actions(driver);
		a.moveToElement(WHP.clickRxRefillButton()).build().perform();
		wait.until(ExpectedConditions.visibilityOf(WHP.clickRxRefillButton()));
		//Thread.sleep(5000);//To visually check if hovering is occuring
		
	}
	
	@Test(enabled=false)
	public void login (){
		driver.get(propt.getProperty("url"));
		WHP = new HomePage(driver);

		WHP.clickYourAccount().click();
		WHP.clickSignIn().click();
		sip = new SignInPage(driver);
		String SItitle=driver.getTitle();
		Assert.assertEquals(SItitle, "Sign In or Register to Get Started Using Walgreens.com");

	
	}
	
	
	
	@Test
	public void clickSearchBoxtoType(){
		driver.get(propt.getProperty("url"));
		WHP = new HomePage(driver);
		WHP.clickSearchBoxtoType().sendKeys("Aveeno oat");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WHP.clicktoSearch().click();
		WHP.clicktoAdd().click();
		
	}
	
	
	
	


	/*@AfterTest
	public void tearDown(){
		driver.quit();
		driver=null;
	}*/

}
