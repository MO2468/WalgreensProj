package com.ap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BalanceRewardPage {
	WebDriver driver;

	public BalanceRewardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Total points')]")
	WebElement getmyrewardpoint;

	public WebElement getMyRewardPoint() {
		return getmyrewardpoint;
	}

}
