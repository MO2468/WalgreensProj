package com.ap.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	public static Properties propt;
	public static WebDriver driver;
	
	public WebDriver initialization() throws IOException{
		propt = new Properties();
		
		try {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/ap/config/config.properties");
		propt.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String browserName = propt.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"/src/resources/drivers/chromedriver.exe"));
			 driver  = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"/src/resources/drivers/geckodriver.exe"));
			 driver  = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"/src/resources/drivers/iedriver.exe"));
			 driver  = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public void getScreenShot(String result) throws IOException{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	FileUtils.copyFile(src, new File(currentDir+"/screenshot/"+System.currentTimeMillis()+".png"));
	}
	}