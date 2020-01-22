package com.ap.testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.data.ArrayData;
import com.ap.pages.HomePage;
import com.ap.pages.SignInPage;

	public class RxRefillLinksTest extends TestBase {
		HomePage hp;
		SignInPage sip;
		ArrayData data;

@BeforeTest
	public void initializer() throws IOException{
		driver=initialization();

}
@Test(enabled=false)
	public void validateRxRefillLinks() throws InterruptedException{
		driver.get(propt.getProperty("url"));
		hp = new HomePage(driver);
		data = new ArrayData();

		WebDriverWait wait = new WebDriverWait(driver, 15);//without explicit, its saying stale element
		Actions a = new Actions(driver);
		a.moveToElement(hp.clickRxRefillButton()).build().perform();//moves to rxrefill button
		wait.until(ExpectedConditions.visibilityOf(hp.clickRxRefillButton()));
		Thread.sleep(2000);//To visually check if hovering is occuring

		for (int i=0;i<9;i++){//had to hardcode condition, .size() brings multiple, no unique locator
			a.moveToElement(hp.rxRefillLinkslvl2().get(i)).build().perform();
			wait.until(ExpectedConditions.visibilityOf(hp.rxRefillLinkslvl2().get(i)));
			String lvl2links = hp.rxRefillLinkslvl2().get(i).getText();
			Assert.assertEquals(data.rxrefilllvl2text[i], lvl2links, "rx-refill,lvl 2 links incorrect");//to validate lvl 2 links
			Thread.sleep(1000);

			if(lvl2links.contains("More Pharmacy Services ›")){

				for (int j=0;j<hp.rxRefillLinkslvl3().size();j++){
					//**cannot seem to hover over lvl 3 links
					a.moveToElement(hp.rxRefillLinkslvl3().get(j)).build().perform();
					wait.until(ExpectedConditions.visibilityOf(hp.rxRefillLinkslvl3().get(j)));

					String lvl3links = hp.rxRefillLinkslvl3().get(j).getText();
					Assert.assertEquals(data.rxrefilllvl3text[j], lvl3links, "rx refill,lvl 3 links incorrect");//to validate lvl 3 links
					Thread.sleep(1000);
}
}
}
} 
@Test(enabled=true)
	public void validateRXlinksClickable() throws InterruptedException{
		driver.get(propt.getProperty("url"));
		hp = new HomePage(driver);
		data=new ArrayData();
		WebDriverWait wait = new WebDriverWait(driver, 15);//without explicit, its saying stale element
		Actions a = new Actions(driver);
		

		a.moveToElement(hp.clickRxRefillButton()).build().perform();//moves to rxrefill button
		wait.until(ExpectedConditions.visibilityOf(hp.clickRxRefillButton()));
		Thread.sleep(2000);//To visually check if hovering is occuring
		for (int i=0;i<10;i++){//10 because its validating homepage aswell
			ArrayList<String> tab = new ArrayList <String> (driver.getWindowHandles());
			a.moveToElement(hp.rxRefillLinkslvl2().get(i)).keyDown(Keys.CONTROL).click().release().build().perform();
			wait.until(ExpectedConditions.visibilityOf(hp.rxRefillLinkslvl2().get(i)));
			String lvl2links = hp.rxRefillLinkslvl2().get(i).getText();
			
			driver.switchTo().window(tab.get(i));
			String titlelvl2=driver.getTitle();
			Assert.assertEquals(data.rxrefilllvl2title[i], titlelvl2, "rx-refill lvl 2 page titles wrong");
			driver.switchTo().window(tab.get(0));
			Thread.sleep(1000);
			/*if(lvl2links.contains("More Pharmacy Services ›")){

				for (int j=0;j<hp.rxRefillLinkslvl3().size();j++){
					ArrayList<String> tablvl3 = new ArrayList <String> (driver.getWindowHandles());
					a.moveToElement(hp.rxRefillLinkslvl3().get(j)).keyDown(Keys.CONTROL).click().release().build().perform();
					wait.until(ExpectedConditions.visibilityOf(hp.rxRefillLinkslvl3().get(j)));
					
					driver.switchTo().window(tablvl3.get(j));
					String titlelvl3=driver.getTitle();
					System.out.println(titlelvl3);
				//Assert.assertEquals(data.rxrefilllvl2title[i], title, "rx-refill lvl 2 page titles wrong");
					driver.switchTo().window(tablvl3.get(0));
					Thread.sleep(1000);


}
}*/
}
}
@AfterTest
	public void tearDown(){
		driver.quit();
		driver=null;
}

}

