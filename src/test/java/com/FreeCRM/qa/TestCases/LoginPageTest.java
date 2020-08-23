package com.FreeCRM.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCRM.qa.Baseclass.TestBase;
import com.FreeCRM.qa.Pages.HomePage;
import com.FreeCRM.qa.Pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		inialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitle() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void loginPageCRMLogo() {
		boolean flag = loginPage.validatCRMlogo();
		Assert.assertTrue(flag);

	}

	@Test(priority = 3)
	public void loginTest() {
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("userpassword"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
