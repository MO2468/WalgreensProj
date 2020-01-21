package com.ap.testcases;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.HomePage;
import com.ap.pages.SignInPage;

public class RxRefillLinksTestCase extends TestBase {
	HomePage hp;
	SignInPage sip;
	@BeforeTest
	public void initializer() throws IOException{
		driver=initialization();

	}
	@Test(enabled=true)
	public void validateRxRefillLinks() throws InterruptedException{
		driver.get(propt.getProperty("url"));
		hp = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 15);//without explicit, its saying stale element
		Actions a = new Actions(driver);
		a.moveToElement(hp.clickRxRefillButton()).build().perform();
		wait.until(ExpectedConditions.visibilityOf(hp.clickRxRefillButton()));
		Thread.sleep(2000);//To visually check if hovering is occuring
		for (int i=0;i<hp.rxRefillLinks().size();i++){
			String lvl2links = hp.rxRefillLinks().get(i).getText();
			System.out.println(lvl2links);
			a.moveToElement(hp.rxRefillLinks().get(i)).build().perform();
			wait.until(ExpectedConditions.visibilityOf(hp.rxRefillLinks().get(i)));
			
			Thread.sleep(2000);
			
			
		}
		
	
	}
	@AfterTest
	public void tearDown(){
		driver.quit();
		driver=null;
	}

}

