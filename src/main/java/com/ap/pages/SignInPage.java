package com.ap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;
	public SignInPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy()
	WebElement a;
	@FindBy()
	WebElement b;
	@FindBy()
	WebElement c;
	@FindBy()
	WebElement d;
	@FindBy()
	WebElement e;
	@FindBy()
	WebElement f;
}	
