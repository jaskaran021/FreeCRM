package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetname="contacts";
	public ContactsPageTest() {
		super();
	}
	@BeforeMethod
	   public void setUp() {
		testutil=new TestUtil();
		contactspage=new ContactsPage();
		   initialization();
		   loginpage=new LoginPage();
		homepage=   loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactspage=	homepage.clickContactsLink();
	   }
	
	@Test(priority = 1)
	public void verifyContactsPageLabel() {
	boolean contactspage1=	contactspage.verifyContactsLabel();
	Assert.assertTrue(contactspage1, "if contacts page does not match");
	}
	
	@Test(priority = 2)
	public void selectContactsTest() {
		contactspage.selectContacts("test2,test2");
	}
		@DataProvider// Data driven approcah and hybrid means combination of pom and data driven
		public object[][] getCrmTestData() {
		object data[][]=	TestUtil.getTestDate(sheetname);
		return data;
		}
		
		
	
	@Test(priority = 3,dataProvider ="getCrmTestData")
	public void validateCreateNewContactTest(String title,String firstname,String lastname,String company) {
		homepage.clickOnNewPageContactLink();
		contactspage.newContactLink(title, firstname, lastname, company);
	}
	// under hybrid frame work all the test cases independent and classes should be independent
	
	@AfterMethod
	   
	   public void tearDown() {
		   driver.quit();
	   }
	
	
	
	
	

}
