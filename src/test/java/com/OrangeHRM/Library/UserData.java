package com.OrangeHRM.Library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserData {
	WebDriver driver;

	public UserData(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Admin")
	WebElement lnkadmin;

	@FindBy(linkText = "User Management")
	WebElement lnkusermanagement;

	@FindBy(linkText = "Users")
	WebElement lnkusers;

	@FindBy(id = "btnAdd")
	WebElement btnadd;

	@FindBy(id = "systemUser_userType")
	WebElement drpsystemuserrole;

	@FindBy(id = "systemUser_employeeName_empName")
	WebElement txtsysemployeename;

	@FindBy(id = "systemUser_userName")
	WebElement txtsysusername;

	@FindBy(id = "systemUser_status")
	WebElement drpsysstatus;

	@FindBy(id = "systemUser_password")
	WebElement txtsyspassword;

	@FindBy(id = "systemUser_confirmPassword")
	WebElement txtsysconfirmpassword;

	@FindBy(id = "btnSave")
	WebElement btnSave;

	// Search Functionality
	@FindBy(id = "searchSystemUser_userName")
	WebElement txtsearchusername;

	@FindBy(id = "searchBtn")
	WebElement btnsearchuser;

	public void getSearchUser(String username) {
		txtsearchusername.sendKeys(username);
	}

	public boolean clickSearchUser(String username) {
		btnsearchuser.click();
		WebElement datatable = driver.findElement(By.id("resultTable"));
		List<WebElement> rows, cols;
		boolean isuser = false;

		rows = datatable.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) {
			cols = rows.get(i).findElements(By.tagName("td"));

			if (cols.get(1).getText().equalsIgnoreCase(username)) {
				isuser = true;
				break;
			}

		}
		if (isuser) {
			return true;
		}

		return false;

	}

	// Action Methods

	public void clickAdmin() {
		lnkadmin.click();
	}

	public void clickUserManagement() {
		lnkusermanagement.click();
	}

	public void clickUsers() {
		lnkusers.click();
	}

	public void clickAddUser() {
		btnadd.click();
	}

	public void clickuserrole() {
		Select se = new Select(drpsystemuserrole);
		se.selectByVisibleText("Admin");
	}

	public void getEmployeeName(String empname) {
		txtsysemployeename.sendKeys(empname);
	}

	public void getUserName(String username) {
		txtsysusername.sendKeys(username);
	}

	public void clicksysStatus() {
		Select se1 = new Select(drpsysstatus);
		se1.selectByVisibleText("Enabled");
	}

	public void getSysPassword(String password) {
		txtsyspassword.sendKeys(password);
	}

	public void getSysConfirmPassword(String password) {
		txtsysconfirmpassword.sendKeys(password);
	}

	public void clickSaveUser() {
		btnSave.click();

	}

}
