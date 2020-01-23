package com.ap.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.BalanceRewardPage;
import com.ap.pages.HomePage;

import com.ap.pages.SignInPage;

public class CheckRewardsBalanceTest extends TestBase {

	HomePage hp;

	@BeforeTest
	public void initializer() throws IOException {
		driver = initialization();

	}

	@Test
	public void login() throws InterruptedException {
		driver.get(propt.getProperty("url"));
		hp = new HomePage(driver);

		hp.getBalanceReward().click();
		Thread.sleep(5000);
		SignInPage sn = new SignInPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		// wait.until(ExpectedConditions.visibilityOf(sn.getRwardSignIn()));
		sn.getRwardSignIn().click();
		wait.until(ExpectedConditions.visibilityOf(sn.getRewardUserName()));
		sn.getRewardUserName().sendKeys(propt.getProperty("username"));
		// sn.getRewardUserName().sendKeys("username");
		sn.getSubmit().click();
		wait.until(ExpectedConditions.visibilityOf(sn.getRewardUserPassword()));
		sn.getRewardUserPassword().sendKeys(propt.getProperty("password"));
		// sn.getRewardUserPassword().sendKeys("password");
		// Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(sn.getSubmit()));
		sn.getSubmit().click();

		BalanceRewardPage brp = new BalanceRewardPage(driver);
		Thread.sleep(5000);
		String rewards = brp.getMyRewardPoint().getText();
		Assert.assertEquals(rewards, "Total points");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}

}
