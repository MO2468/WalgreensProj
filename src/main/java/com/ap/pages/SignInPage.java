package com.ap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn__blue btn-block-mob']//strong[contains(text(),'Sign in')]")
	WebElement getrewardsignIn;

	public WebElement getRwardSignIn() {
		return getrewardsignIn;
	}

	@FindBy(xpath = "//input[@id='user-name']")
	WebElement getrewardusername;
	@FindBy(xpath = "//button[@id='submit_btn']")
	WebElement getSubmit;
	@FindBy(xpath = "//input[@id='user_password']")
	WebElement getrewarduserpassword;
	@FindBy()
	WebElement e;
	@FindBy()
	WebElement f;

	// Reward User Name
	public WebElement getRewardUserName() {
		return getrewardusername;
	}

	// Reward signin button on reward page
	public WebElement getSubmit() {
		return getSubmit;

	}

	// Reward Password
	public WebElement getRewardUserPassword() {
		return getrewarduserpassword;
	}
}
