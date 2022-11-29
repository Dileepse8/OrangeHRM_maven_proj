package com.OrangeHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.OrangeHRM.AppUtilities.BaseClassUtils;
import com.OrangeHRM.Library.Employee;
import com.OrangeHRM.Library.LoginPage;

public class EmployeeRegistration extends BaseClassUtils {

	@Parameters({ "uid", "pwd", "fname", "lname" })
	@Test
	public void employeeRegistration(String username, String password, String fname, String lname) throws InterruptedException {

		LoginPage log = new LoginPage(driver);
		log.getUserName(username);
		log.getPassword(password);
		log.clickLogin();
		logger.info("Login is clicked");
		Employee emp = new Employee(driver);
		emp.clickPIM();
		emp.clickAddEmpLink();
		// emp.clickAddEmp();
		emp.getEmployeefName(fname);
		emp.getEmployeelName(lname);
		String empID=emp.getEmpID();

		emp.clickSaveEmp();
		logger.info("Employee add button is clicked");

		emp.clickEmpList();
		Thread.sleep(3000);
		logger.info("Employee link clicked");
		emp.setEmpSearchId(empID);
		logger.info("Emp ID is typed");
		Boolean res=emp.SearchEmpDetails(empID);
		Assert.assertTrue(res);
		logger.info("Emp Search button isClicked");
		logger.info("Emp is present in the table");
	}

}
