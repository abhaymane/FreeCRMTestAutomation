package com.FreeCRM.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FreeCRM.qa.Baseclass.TestBase;

public class HomePage extends TestBase {
	// PageFactory ObjectRepository:
	@FindBy(xpath = "//td[contains(text(),'User: Mayuri Deshmukh')]")
	WebElement userlable;
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealLink;
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement taskLink;
	
	// Initialization of PageObjects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUsername() {
		return userlable.isDisplayed();
	}

	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealPage clickOnDealLink() {
		dealLink.click();
		return new DealPage();
	}

	public TaskPage clickOnTaskLink() {
		taskLink.click();
		return new TaskPage();
	}
	public void clickOnNewContactLink() {
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}

}
