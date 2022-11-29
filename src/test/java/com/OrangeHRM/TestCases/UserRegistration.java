package com.OrangeHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.OrangeHRM.AppUtilities.BaseClassUtils;
import com.OrangeHRM.Library.LoginPage;
import com.OrangeHRM.Library.UserData;

public class UserRegistration extends BaseClassUtils {

	@Parameters({ "uid", "pwd", "empfullname", "username", "password" })
	@Test
	public void userRegCreation(String username, String password, String ename, String username1, String password1)
			throws InterruptedException {

		LoginPage log = new LoginPage(driver);
		log.getUserName(username);
		log.getPassword(password);
		log.clickLogin();
		logger.info("Admin is logged IN");
		UserData user = new UserData(driver);
		user.clickAdmin();
		user.clickUserManagement();
		user.clickUsers();
		user.clickAddUser();
		user.clickuserrole();
		user.getEmployeeName(ename);
		
		user.getUserName(username1);
		Thread.sleep(2000);
		user.clicksysStatus();
		user.getSysPassword(password1);
		user.getSysConfirmPassword(password1);
		Thread.sleep(2000);
		logger.info("Confirm password is matched");
		user.clickSaveUser();
		logger.info("New User is Created");
		Thread.sleep(2000);
		user.getSearchUser(username1);
		boolean res=user.clickSearchUser(username1);
		Assert.assertTrue(res);
		logger.info("User is Found in the Table");
		

	}

}
