package com.ap.testcases;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.base.TestBase;

public class Links extends TestBase {
	@BeforeTest
	public void initializer() throws IOException{
		driver=initialization();
	}
	
	@Test
	public void linkHomepage(){

		driver.get(propt.getProperty("url"));

		List<WebElement> links =  driver.findElements(By.tagName("a"));
		
		for (WebElement l : links)
		{
			System.out.println(l.getAttribute("href"));
		}
}
	

}
