package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	//pagefactory 
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	@FindBy(id="First_Name")
	WebElement firstname;
	
	@FindBy(id="Last Name")
	WebElement lastname;
	@FindBy(name="contact_lookup")
	WebElement company;
	@FindBy(xpath="//input[@type='submit and @value='Save']")
	WebElement savebtn;
	
	// Initialize the page factory
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
    public boolean verifyContactsLabel() {
	return contactslabel.isDisplayed();
}

    public void selectContacts(String name) {
    	driver.findElement(By.xpath("name")).click();
    }
public void newContactLink(String title,String firstname,String lastname,String company) {
	Select select =new Select(driver.findElement(By.name(title)));
	select.selectByVisibleText(title);
	select.selectByVisibleText(firstname);
	select.selectByVisibleText(lastname);
	select.selectByVisibleText(company);
	savebtn.click();
}
}
