package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignupPage extends MainPage{
	public SignupPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="a[href='/login']")
	WebElement loginlink;
	
	@FindBy(css="input[placeholder='Name']")
	WebElement name;
	
	@FindBy(css="input[data-qa='signup-email']")
	WebElement email;
	
	@FindBy(css="div[class='signup-form'] h2")
	WebElement text;
	
	@FindBy(css="button[data-qa='signup-button']")
	WebElement signupbtn;
	
	@FindBy(xpath="//p[text()='Email Address already exist!']")
	WebElement errormsg;
	
	public void link() {
		loginlink.click();
	}
	
	public String error() {
		return errormsg.getText();
	}
	public void waitfortext(WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(text));
		
	}
	public void signup(String username, String useremail) {
		name.sendKeys(username);
		email.sendKeys(useremail);
		signupbtn.click();
	}
}
