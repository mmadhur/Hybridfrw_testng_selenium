package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	
	// Test Method
	// Data Provider Method
	
	
	@Test(dataProvider ="create")
	public void loginDDT(String u_name,String pwd) 
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(u_name);
		lp.setPassword(pwd);
		lp.clickonLogin();
		
		if(isAlertdisplaying()==true)
		{
			driver.switchTo().alert().accept(); // close the alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{	
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	public boolean isAlertdisplaying() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	
	@DataProvider(name ="create")
	String [][] getData() throws IOException
	{
	
		//	String path= "C:\\Users\\madhu\\eclipse-workspace\\inetBanking_V1\\src\\test\\java\\com\\inetbanking\\testData\\LoginData.xlsx";
		
		String path= System.getProperty("user.dir") +"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		int row_count = XLUtils.getRowCount(path, "Sheet1");
		int Col_count = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[row_count][Col_count];
		
		for(int i=1; i<=row_count; i++)
		{
			for(int j= 0;j<Col_count; j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
		}
		
		return logindata;
				
	}
	
}
