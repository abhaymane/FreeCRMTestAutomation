package com.FreeCRM.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCRM.qa.Baseclass.TestBase;
import com.FreeCRM.qa.Pages.ContactsPage;
import com.FreeCRM.qa.Pages.HomePage;
import com.FreeCRM.qa.Pages.LoginPage;
import com.FreeCRM.qa.Utility.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		inialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("userpassword"));

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUsername());
	}

	@Test(priority = 3)
	public void clickOnContactsLink() {
		testUtil.switchToFrame();
		contactPage = homePage.clickOnContactsLink();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
