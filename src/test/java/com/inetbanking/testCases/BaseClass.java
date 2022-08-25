package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig rc = new ReadConfig();

	public String baseURL = rc.getApplicationURL();
	public String username = rc.getUserName();
	public String password = rc.getPassword();

	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String brw) {
		
		if(brw.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", rc.getChromePath());
		driver = new ChromeDriver();
		}
		else if(brw.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", rc.getEdgePath());
			driver = new EdgeDriver();
		}
		driver.get(baseURL);
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
	}

	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir") +"/screenshots/" + tname + ".png" );
		FileUtils.copyFile(src, trg);
		System.out.println("Screenshot taken");
		
	}
	
	
}
