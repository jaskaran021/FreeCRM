package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;


public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	public HomePageTest() {
		super();
	}
   
@BeforeMethod
   public void setUp() {
	testutil=new TestUtil();
	contactspage=new ContactsPage();
	   initialization();
	   loginpage=new LoginPage();
	homepage=   loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
   }
   @Test(priority = 1)
   public void verifyHomePagetitleTest() {
	String homepagetitle1=  homepage.verifyHomePageTitle(); 
	Assert.assertEquals(homepagetitle1, "CRMPRO","Homepage title is failed");
   }
   @Test(priority = 2)
   public void verifyCorrectUsernameTest() {
	   testutil.switchToFrame();
	boolean pagetitle=  homepage.verifyCorrectUsername(); 
	Assert.assertTrue(pagetitle, "pagetite is not matched");
   }
   @Test(priority = 3)
   public void verifyContactsLinkTest() {
	   testutil.switchToFrame();
	   contactspage=   homepage.clickContactsLink();
   }
   
   
   
   
   
   
  
@AfterMethod
   
   public void tearDown() {
	   driver.quit();
   }



}
