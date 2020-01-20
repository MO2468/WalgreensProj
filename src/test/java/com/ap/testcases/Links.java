package com.ap.testcases;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import org.testng.annotations.Test;

import com.ap.base.TestBase;

public class Links extends TestBase {
	
	public void initializer() throws IOException{
		driver=initialization();
	}
	
	@Test
	public void linkHomepage(){



		List<WebElement> links = (List<WebElement>) driver.findElement(By.tagName("a"));
		
		System.out.println(links.size());
		
		for(int i = 0; i< links.size(); i++){
			System.out.println(((WebElement) links.get(i)).getAttribute("href"));
		}
	}
	

}
