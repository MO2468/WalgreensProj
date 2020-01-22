package com.ap.testcases;

import java.io.IOException;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.HomePage;
import com.ap.pages.SignInPage;

public class HomePageTests extends TestBase{
	HomePage hp;
	SignInPage sip;
	@BeforeTest
	public void initializer() throws IOException{
		driver=initialization();

	}
	
	
	
	@Test(enabled=true)
	public void login (){
		driver.get(propt.getProperty("url"));
		hp = new HomePage(driver);

		hp.clickYourAccount().click();
		hp.clickSignIn().click();
		sip = new SignInPage(driver);
		String SItitle=driver.getTitle();
		Assert.assertEquals(SItitle, "Sign In or Register to Get Started Using Walgreens.com");

	
	}

	@AfterTest
	public void tearDown(){
		driver.quit();
		driver=null;
	}

}
