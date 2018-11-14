package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
		public HomePageTest() {
			super();
		}
	//Comments for GIT 
		@BeforeMethod
		public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
		
		@Test
		public void verifyHomePageTest(){
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			String homePageTitle = homePage.verifyhomepageTitle();
			Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page Title is not matching");
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
		
}
