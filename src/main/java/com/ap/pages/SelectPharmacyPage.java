package com.ap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPharmacyPage {
WebDriver driver;


public SelectPharmacyPage(WebDriver driver){
	this.driver= driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//*[@id='search-address']")
WebElement enterAddress;



@FindBy(xpath="//*[@id='search-result']/section[1]/section[1]/span[2]/button")
WebElement searchButton;

@FindBy(xpath="//*[@id='radio_0']")
WebElement C;

public WebElement enterAddress(){
	
	return enterAddress;
}

public WebElement clickSearchButton(){
	
	return searchButton;
}




}