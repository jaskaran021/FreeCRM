package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//page factory=or
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signupbtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement Crmlogo;
	//initializing page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	// actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateCrmLogo() {
	return	Crmlogo.isDisplayed();
	}
	public HomePage login(String un,String pd) {
		username.sendKeys(un);
		password.sendKeys(pd);
		loginbtn.click();
		return new HomePage();
	}
}
