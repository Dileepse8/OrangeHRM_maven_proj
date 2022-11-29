package com.OrangeHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.OrangeHRM.AppUtilities.BaseClassUtils;
import com.OrangeHRM.Library.LoginPage;

public class CheckEmpModule extends BaseClassUtils {
	@Parameters({"uid","pwd"})
	@Test(enabled=false)
	public void checkEmpModule(String username,String password) {
		
		LoginPage log=new LoginPage(driver);
		log.getUserName(username);
		log.getPassword(password);
		log.clickLogin();
		boolean res=log.isEmpDisplayed();
		Assert.assertTrue(res);
		logger.info("Emp Module is displayed");
		
		
	}
	

}
