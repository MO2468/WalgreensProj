package com.ap.base;

import java.io.File;
import java.io.FileInputStream;
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
	public WebDriver driver;
	public Properties propt;

	
	

	public void propFile ()
	{
		propt =new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/ap/config/config.properties");
			propt.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	public void machineType ()
	{
		propFile();
		String machineName = propt.getProperty("machine");
		
		if (machineName.equalsIgnoreCase("mac"))
		{
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"/src/resources/drivers/chromedriver 2"));
		} 
		else
		{
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"/src/resources/drivers/chromedriver.exe"));
		}
		
	}
	
	public WebDriver initialization() {
		
		propFile();
		
		String browserName = propt.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")){
			machineType();
			driver  = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			machineType();
			driver  = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("IE")) {
			machineType();
			driver  = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public void getScreenShot(String result) throws IOException {

	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	FileUtils.copyFile(src, new File(currentDir+"/screenshot/"+System.currentTimeMillis()+".png"));
	
	
	}	
	}