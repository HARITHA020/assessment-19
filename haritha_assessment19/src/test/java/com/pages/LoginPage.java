package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends MainPage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="input[data-qa='login-email']")
	WebElement loginemail;
	
	@FindBy(css="input[placeholder='Password']")
	WebElement loginpass;
	
	@FindBy(css="button[data-qa='login-button']")
	WebElement logbtn;
	
	@FindBy(css="div[class='login-form'] h2")
	WebElement logintext;
	
	@FindBy(xpath="//p[text()='Your email or password is incorrect!']")
	WebElement loginerr;
	public void login(String userlogemail,String userlogpass) {
		loginemail.sendKeys(userlogemail);
		loginpass.sendKeys(userlogpass);
		logbtn.click();
	}
	
	public void loginerror() {
		logintext.getText();
	}
	
	public void waitforlogintext(WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(logintext));
	}
}
