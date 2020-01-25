package com.ap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReasonForVisitPage {
 WebDriver driver;
 public ReasonForVisitPage(WebDriver driver){
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 
 
 @FindBy (xpath="//label[@for='radio_19']")
 WebElement radio;
 @FindBy(css="button#con")
 WebElement Continuebutton;
 
  public WebElement MedicationReviewButton(){
	  return radio;
  }
  public WebElement ContinueButton(){
	  return Continuebutton;
  }
}
