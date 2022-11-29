package com.OrangeHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.OrangeHRM.AppUtilities.BaseClassUtils;
import com.OrangeHRM.Library.LoginPage;

public class AdminLoginValidData extends BaseClassUtils {
	@Parameters({ "uid", "pwd" })
	@Test(enabled=false)
	public void adminlogin(String username, String password) throws InterruptedException {
		LoginPage log = new LoginPage(driver);
		logger.info("Page is opened"); // log info
		log.getUserName(username);
		logger.info("Username is passed"); // log info
		log.getPassword(password);
		logger.info("Password is passed"); // log info
		log.clickLogin();
		logger.info("LogIN is Clicked"); // log info
		boolean res = log.isAdminDisplayed();
		Assert.assertTrue(res);
		logger.info("Admin link is visible"); // log info
		log.clickLogOutLink();
		logger.info("LogOut Link is Clicked");
		Thread.sleep(1000);
		log.clickLogOut();
		logger.info("LogOut is Clicked");// log info

		

	}
}
