package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.qa.util.TestUtil;

public class TestBase {
	//Initialize all the properties
	public static WebDriver driver;
	public static Properties prop;
	
	//create TesBase class Constructor
	
	public TestBase() {
		//Read the properties
		
		try {
			prop = new Properties();
			FileInputStream ip= new FileInputStream("/Users/Admin/git/TestMaven/FreeCRMTest/src/main/java"
					+ "/com/crm/qa/config/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();	
		}	
	}
	
	// Initialization method - Read the property of browser
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/Admin/Downloads/chromedriver.exe");
			driver = new ChromeDriver();
		} else 
			if(browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "/Users/Admin/Downloads/geckodriver.exe");
				driver = new FirefoxDriver();
	}
		//Open Browser
		//Maximize the Browser
		//Clear all cookies
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		//System.out.println(driver.getTitle());
}
}