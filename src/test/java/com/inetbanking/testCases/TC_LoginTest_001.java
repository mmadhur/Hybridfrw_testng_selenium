package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		
		
		logger.info("URL IS OPENING");
		
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		
		logger.info("ENTERED USERNAME");
		lp.setPassword(password);
		
		logger.info("ENTERED PASSWORD");
		lp.clickonLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{ 
			// only if test case fails screenshot will be taken 
			captureScreen(driver,"loginTest");
			logger.info("Login Test Failed");
			Assert.assertTrue(false);
			
		}
		
		
	}

}
