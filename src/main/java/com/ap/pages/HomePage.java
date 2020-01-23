package com.ap.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[contains(text(),'Your account')]")
	WebElement youraccountbutton;
	@FindBy(xpath="//*[contains(text(),'Sign in')]")
	WebElement signinbutton;
	@FindBy(xpath="//*[contains(text(),'Balance Rewards')]")
	WebElement rewardsbalancebutton;
	@FindBy(xpath="//*[contains(text(),'Rx Refills')]")
	WebElement rxrefillbutton;
	@FindBy(xpath="//*[contains(@data-kidx, 'm-1-')]")
	List <WebElement> rxrefilllinks;
	@FindBy(xpath="//input[@id='ntt-placeholder']")
	WebElement searchBox;
	@FindBy(xpath="//*[@type='submit']")
	WebElement clickSearch;
	@FindBy(id="add-to-cart-btncompare_sku388792")
	WebElement addToCart;
	@FindBy(xpath="//*[contains(@data-kidx, 'm-1-')]")
	List <WebElement> rxrefillLinkslvl2;
	@FindBy(xpath="//*[@class='submenucatvalue'][contains(@data-kidx, 'm-1-9-')]")
	List <WebElement> rxrefillLinkslvl3;
	@FindBy(xpath="//*[@data-kidx='m-7']")
	WebElement BalanceReward;
	@FindBy(xpath="//*[@id='Homepage_Rx_CT']/div[3]/div/ul/li[4]/a")
	WebElement schedule;
	
	public WebElement clickYourAccount(){
		return youraccountbutton;
	}
	public WebElement clickSignIn(){
		return signinbutton;
	}
	public WebElement clickRewardsBalance(){
		return rewardsbalancebutton;
	}
	public WebElement clickRxRefillButton(){
		return rxrefillbutton;
	}
	public List<WebElement> rxRefillLinks(){
		return rxrefilllinks;
	}
	public WebElement clickSearchBoxtoType(){
		return searchBox;
	}
	public WebElement clicktoSearch(){
		return clickSearch;
	}
	public List<WebElement> rxRefillLinkslvl2(){
		return rxrefillLinkslvl2;
	}
	public List<WebElement> rxRefillLinkslvl3(){
		return rxrefillLinkslvl3;
	}

	public WebElement clicktoAdd(){
		return addToCart;
	}
	public WebElement getBalanceReward(){
		return BalanceReward;
	}
	public WebElement scheduler(){
		return schedule;
	}
	
	
}	
