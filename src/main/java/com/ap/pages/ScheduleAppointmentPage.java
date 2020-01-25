package com.ap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScheduleAppointmentPage {
WebDriver driver;
public ScheduleAppointmentPage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
}


@FindBy(css="button#schedule_pharmacy")
WebElement schedulePharmacyButton;

@FindBy()
WebElement b;

@FindBy()
WebElement c;

public WebElement clickOnScheduleNow(){
	return schedulePharmacyButton;
}



}
