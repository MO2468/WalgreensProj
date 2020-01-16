package com.ap.testcases;

import java.io.IOException;


import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.HomePage;
import com.ap.pages.SignInPage;

public class Login extends TestBase{
	@BeforeTest
	public void initializer() throws IOException{
		driver=initialization();

	}
	
	@Test
	public void login (){
		driver.get(propt.getProperty("url"));
		HomePage hp = new HomePage(driver);

		hp.clickYourAccount().click();
		hp.clickSignIn().click();
		SignInPage sip = new SignInPage(driver);
		String SItitle=driver.getTitle();
		Assert.assertEquals(SItitle, "Sign In or Register to Get Started Using Walgreens.com");

	
	}

	@AfterTest
	public void tearDown(){
		driver.quit();
		driver=null;
	}

}
