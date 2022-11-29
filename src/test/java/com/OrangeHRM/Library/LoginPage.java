package com.OrangeHRM.Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.AppUtilities.BaseClassUtils;

public class LoginPage extends BaseClassUtils {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txtUsername")
	WebElement txtusername;
	@FindBy(id = "txtPassword")
	WebElement txtpassword;
	@FindBy(id = "btnLogin")
	WebElement btnlogin;

	@FindBy(partialLinkText = "Welcome")
	WebElement lnklogoutwelcome;

	@FindBy(linkText = "Logout")
	WebElement lnklogout;

	@FindBy(linkText = "Admin")
	WebElement lnkAdmin;

	@FindBy(id = "spanMessage")
	WebElement errmessage;

	// Action Methods
	public void getUserName(String username) {
		txtusername.sendKeys(username);
	}

	public void getPassword(String password) {
		txtpassword.sendKeys(password);
	}

	public void clickLogin() {
		btnlogin.click();
	}

	public void clickLogOutLink() {
		lnklogoutwelcome.click();
		// lnklogout.click();

	}

	public void clickLogOut() {

		lnklogout.click();

	}

	public boolean isAdminDisplayed() {
		if (lnkAdmin.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isEmpDisplayed() {

		try {
			lnkAdmin.isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean getErrorMessage() {
		if (errmessage.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

}
