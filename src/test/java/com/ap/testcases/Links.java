package com.ap.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.base.TestBase;

public class Links extends TestBase {
	@BeforeTest//didnt add beforetest
	public void initializer() throws IOException{
		driver=initialization();
	}
	
	@Test
	public void linkHomepage(){
		driver.get(propt.getProperty("url"));//didnt add url, how r you retrieving links
		//gives stale element ref, use explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//used element instead of elements
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("a")));
		List<WebElement> links = (List<WebElement>) driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
		for(int i = 0; i< links.size(); i++){
			System.out.println(((WebElement) links.get(i)).getAttribute("href"));
		}
	}
	

}
