package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver l_driver;

	public LoginPage(WebDriver r_driver) {
		l_driver = r_driver;
		PageFactory.initElements(r_driver, this);
	}

	@FindBy(name = "uid")
	WebElement txt_Username;

	@FindBy(name = "password")
	WebElement txt_Password;

	@FindBy(name = "btnLogin")
	WebElement buttonLogin;
	
	@FindBy(xpath = "//a[normalize-space()='Log out']")
	WebElement btnlogout;

	public void setUserName(String uname) {
		txt_Username.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txt_Password.sendKeys(pwd);
	}

	public void clickonLogin() {
		buttonLogin.click();
	}
	public void clickLogout() {
		btnlogout.click();
	}
	
}
 