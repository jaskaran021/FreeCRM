package com.crm.qa.pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	// Page factory
	@FindBy(xpath="//td[contains(text(),'User:Naveen K')]")
	
	@CacheLookup// it will create small memory and save the element in particular memory is called cache memory
	WebElement userNamelebel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	
     WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),' New Contacts')]")
	
    WebElement  newcontactslink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	
    WebElement dealslink;
	
	
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	
    WebElement tasklink;
	
	//actions
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCorrectUsername() {
	return	userNamelebel.isDisplayed();
	}
	
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickContactsLink() {
		contactslink.click();
		return new ContactsPage();
		
	}
	
	
	public DealsPage clickDealsLink() {
		dealslink.click();
		return new DealsPage();
	}
	
	public TaskPage clickTaskLink() {
		tasklink.click();
		return new TaskPage();
	}

	public void clickOnNewPageContactLink() {
		Actions action =new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		newcontactslink.click();
	}
	
	
	
	
	
	
}
