package com.ap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterLocationPage {
	WebDriver driver;
	public EnterLocationPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='selectage']")
	WebElement selectAgeDropdown;
	
	@FindBy( xpath="//*[@id='appt-init-address']")
	WebElement enterzip;
	
	@FindBy(xpath="//*[@id='con']")
	WebElement ContinueButton;
	
	@FindBy()
	WebElement d;
	
	
	public WebElement selectAge(){
		return selectAgeDropdown;
	}
	public WebElement enterZipcode(){
		return enterzip;
		
	}
	public WebElement clickContinue(){
		return ContinueButton;
		
	}
}
