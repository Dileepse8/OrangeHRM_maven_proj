package com.OrangeHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.OrangeHRM.AppUtilities.BaseClassUtils;
import com.OrangeHRM.Library.LoginPage;

public class AdminLoginInValidData extends BaseClassUtils {
	@Parameters({"uid","pwd"})
	@Test(enabled=false)
	public void AdminLoginInvalidData(String username,String password) {
		

		LoginPage log=new LoginPage(driver);
		log.getUserName(username);
		log.getPassword(password);
		log.clickLogin();
		logger.info("LogIn is clicked");
		boolean res=log.getErrorMessage();
		
		Assert.assertTrue(res);
		logger.info("error msg is displayed");
		
		
		
	}
	
}
