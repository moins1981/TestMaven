package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(), 'User: Moin Ahmed')]")
	WebElement usernameLabel;
	
	
	@FindBy(xpath="//td[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	//Initializing the page objects
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
	
	public String verifyhomepageTitle() {
		return driver.getTitle();
	}
	
	
	public ContactsPage clickoncontactsLink() {
		contactsLink.click();
		return new ContactsPage();
		
	}
	
	
	
	
	
	
	
	
	
}
