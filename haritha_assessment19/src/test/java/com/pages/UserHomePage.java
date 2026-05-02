package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UserHomePage extends MainPage {

	public UserHomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="ul[class='nav navbar-nav'] li a b")
	WebElement loginname;
	
	@FindBy(css="a[href='/logout']")
	WebElement logoutbtn;
	public String loginas() {
		return loginname.getText();	
	}
	
	public void clicklogout() {
		logoutbtn.click();
	}
	
}
