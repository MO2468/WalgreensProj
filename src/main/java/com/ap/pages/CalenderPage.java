package com.ap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalenderPage {
   WebDriver driver;
	
	public CalenderPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		
		@FindBy(xpath="//a[@title='2020 Jan 31']")
		WebElement date;
		
		@FindBy(xpath="//label[@for='radiobutton_0_1']")
		WebElement time;
		
		@FindBy(css="button#con")
		WebElement continuebtn;
		
		
		public WebElement clickdate(){
			return date;
		}
		public WebElement clicktime(){
			return time;
		}
		public WebElement clickcontinue(){
			return continuebtn;
		}
	}

