package com.ap.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
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

	
	
	@Test
	public void clickSearchBoxtoType() throws InterruptedException{
		driver.get(propt.getProperty("url"));
		WHP = new HomePage(driver);
		WHP.clickSearchBoxtoType().sendKeys("Aveeno oat");
		WHP.clicktoSearch().click();
		Thread.sleep(1000);
		WHP.clicktoAdd().click();
		Assert.assertEquals(WHP.VerifyCartMsg().getText(), "1 item added to your cart");
		WHP.viewCart().click();
		Thread.sleep(500);
		WHP.GotoCheckout().click();
		WHP.checkOut().click();
	}
	

	@AfterTest
	public void tearDown(){
		driver.quit();
		driver=null;
		}

}



