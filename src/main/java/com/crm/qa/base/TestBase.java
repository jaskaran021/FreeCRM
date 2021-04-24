package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.utils.TestUtil;

public class TestBase {
public	static WebDriver driver;
public	static Properties prop;
public static EventFiringWebDriver e_driver;
public static WebDriverEventListener e_listner;
	
	public TestBase() {
		
		
		try {
			 prop= new Properties();
			 FileInputStream ip= new FileInputStream("C:\\Users\\JASKA\\eclipse-workspace\\FREECRM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	public static void initialization() {
	String browserName=	prop.getProperty("browser");
	if (browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium files\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
	} else {
		System.out.println("Another browser will open");
	}
	e_driver=new EventFiringWebDriver(driver);
	e_listner=new WebDriverEventListener();
	e_driver.register(e_listner);
	driver=e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
	}
}
