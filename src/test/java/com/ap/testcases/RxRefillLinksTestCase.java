package com.ap.testcases;

import java.io.IOException;
import java.util.ArrayList;

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
		for (int i=0;i<9;i++){//had to hardcode condition, .size() brings multiple, no unique locator
			a.moveToElement(hp.rxRefillLinkslvl2().get(i)).build().perform();
			wait.until(ExpectedConditions.visibilityOf(hp.rxRefillLinkslvl2().get(i)));
			String lvl2links = hp.rxRefillLinkslvl2().get(i).getText();
			Assert.assertEquals(rxrefilllvl2text[i], lvl2links, "lvl 2 links incorrect");
			Thread.sleep(1000);
			if(lvl2links.contains("More Pharmacy Services ›")){
				for (int j=0;j<hp.rxRefillLinkslvl3().size();j++){
					/*a.moveToElement(hp.clickRxRefillButton()).build().perform();
					wait.until(ExpectedConditions.visibilityOf(hp.clickRxRefillButton()));
					Thread.sleep(1000);
					a.moveToElement(hp.rxRefillMorePharmacydd()).build().perform();
					wait.until(ExpectedConditions.visibilityOf(hp.rxRefillMorePharmacydd()));
					Thread.sleep(1000);*/
					a.moveToElement(hp.rxRefillLinkslvl3().get(j)).build().perform();
					wait.until(ExpectedConditions.visibilityOf(hp.rxRefillLinkslvl3().get(j)));
					String lvl3links = hp.rxRefillLinkslvl2().get(i).getText();
					//Assert.assertEquals(rxrefilllvl3text[j], lvl3links, "lvl 3 links incorrect");
					Thread.sleep(1000);
			}
			}
		}
		
	
	}
	@AfterTest
	public void tearDown(){
		driver.quit();
		driver=null;
	}

}

