package com.OrangeHRM.AppUtilities;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassUtils {
	public String url="http://orangehrm.qedgetech.com/"; 
	public WebDriver driver;
	public Logger logger;
	
	@BeforeTest
	public void LunchApplication() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		/*logger = Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("Log4j.properties");*/
		logger=Logger.getLogger("OrangeHRM_Maven");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Browser is Opened");
		
		

	}
	@AfterTest
	public void CloseAppication() {
		driver.quit();
		
	}

}
