package com.FreeCRM.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FreeCRM.qa.Baseclass.TestBase;

public class LoginPage extends TestBase {
	// PageFactory-OR
	@FindBy(name = "username")
	WebElement user;
	@FindBy(name = "password")
	WebElement pass;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn; 
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/a/img")
	WebElement crmlogo;

	// Initializing page object:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validatCRMlogo() {
		return crmlogo.isDisplayed();
	}

	public HomePage login(String un, String pw) {
		user.sendKeys(un);
		pass.sendKeys(pw);
		loginBtn.click();
		driver.getTitle();
		return new HomePage();
	}
}
