package com.OrangeHRM.Library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Employee {
	public WebDriver driver;

	public Employee(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "PIM")
	WebElement lnkPIM;

	@FindBy(linkText = "Add Employee")
	WebElement lnkaddemployee;

	/*
	 * @FindBy(id="btnAdd") WebElement btnadd;
	 */

	@FindBy(id = "firstName")
	WebElement txtfirstname;

	@FindBy(id = "lastName")
	WebElement txtlastname;

	@FindBy(id = "employeeId")
	WebElement txtemployeeid;

	@FindBy(id = "btnSave")
	WebElement btnSave;

	// Checking Emp present in table or not

	@FindBy(linkText = "Employee List")
	WebElement lnkEmployeeList;

	@FindBy(id = "empsearch_id")
	WebElement txtemployeeSearchid;

	@FindBy(id = "searchBtn")
	WebElement btnEmpSearch;

	public void clickEmpList() {
		lnkEmployeeList.click();
	}

	public void setEmpSearchId(String empID) {
		// String empID = txtemployeeid.getAttribute("value");

		txtemployeeSearchid.sendKeys(empID);

	}

	public boolean SearchEmpDetails(String empID) {
		btnEmpSearch.click();

		WebElement Datatable = driver.findElement(By.id("resultTable"));
		Boolean isEmp = false;
		List<WebElement> rows, cols;
		rows = Datatable.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) {

			cols = rows.get(i).findElements(By.tagName("td"));
			if (cols.get(1).getText().equals(empID)) {
				isEmp = true;
				break;
			}
		}
		if (isEmp) {
			return true;
		}else {
			return false;
		}
		

	}

	// Actions Methods
	public void clickPIM() {
		lnkPIM.click();

	}

	public void clickAddEmpLink() {
		lnkaddemployee.click();

	}

	public void getEmployeefName(String fname) {
		txtfirstname.sendKeys(fname);

	}

	public void getEmployeelName(String lname) {

		txtlastname.sendKeys(lname);

	}

	public String getEmpID() {
		String empID = txtemployeeid.getAttribute("value");

		return empID;

	}

	public void clickSaveEmp() {
		btnSave.click();

	}

}
