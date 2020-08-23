package com.FreeCRM.qa.Baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.FreeCRM.qa.Utility.TestUtil;
import com.FreeCRM.qa.Utility.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListner;

	public TestBase() {
		try {
			prop = new Properties();

			FileInputStream fins = new FileInputStream("D:\\Mavan\\FreeCRMAutomation\\Config\\config.properties");
			prop.load(fins);
		} catch (Exception e) {
			System.out.println("File not matching" + e.getMessage());

		}
	}

	public static void inialization() {
		String brName = prop.getProperty("browser");
		if (brName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (brName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", ".//Driver//geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("browser is unable to match");
		}
		e_driver=new EventFiringWebDriver(driver);
		//Now create the object of EventListerHandler to register it with EventFiringDriver
		eventListner=new WebEventListener(); 
		e_driver.register(eventListner);
		driver=e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
