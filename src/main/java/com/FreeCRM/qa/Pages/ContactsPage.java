package com.FreeCRM.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.FreeCRM.qa.Baseclass.TestBase;

public class ContactsPage extends TestBase {
	//Contacts page layer
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	@FindBy(id="first_name")
	WebElement fname;
	@FindBy(name="surname")
	WebElement lname;
	@FindBy(name="client_lookup")
	WebElement company;
	@FindBy(xpath="//input[@type='submit'and@value='Save']")
	WebElement saveBtn;
	
	

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactslabel() {
		return contactsLabel.isDisplayed();
	}

	public void selectContacts(String name) {
		driver.findElement(
				By.xpath("//form[@id='vContactsForm']/table/tbody/tr[4]/td[2]//a[contains(text(),'" + name + "')]"))
				.click();
	}
	public void createNewContacts(String title,String ftname,String stname,String comp) {
		Select sel=new Select(driver.findElement(By.name("title")));
		sel.selectByVisibleText(title);
		fname.sendKeys(ftname);
		lname.sendKeys(stname);
		company.sendKeys(comp);
		saveBtn.click();
		
		
	}

}
