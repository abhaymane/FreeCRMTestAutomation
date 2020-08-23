package com.FreeCRM.qa.TestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FreeCRM.qa.Baseclass.TestBase;
import com.FreeCRM.qa.Pages.ContactsPage;
import com.FreeCRM.qa.Pages.HomePage;
import com.FreeCRM.qa.Pages.LoginPage;
import com.FreeCRM.qa.Utility.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;
    String sheetName="sheet1";
	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		inialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("userpassword"));
		testUtil.switchToFrame();
		contactPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsLabel() {

		Assert.assertTrue(contactPage.verifyContactslabel(), "contacts label is missing");
	}

	@Test(priority = 2)
	public void selectContacts() {
		contactPage.selectContacts("Aishwarya kadam");
	}

	@Test(priority = 3)
	public void selectMultipleContacts() {
		contactPage.selectContacts("Aishwarya kadam");
		contactPage.selectContacts("Aishwarya kadam");
	}
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
		
	}
	@Test(priority=4,dataProvider = "getCRMTestData")
	public void createNewContactTest(String title,String fname,String lname,String company) {
		homePage.clickOnNewContactLink();
		//contactPage.createNewContacts("Mr.","Ravi","Kumar","Google");
		contactPage.createNewContacts(title, fname, lname, company);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
