package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserHomePage extends MainPage {

	public UserHomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="ul[class='nav navbar-nav'] li a b")
	WebElement loginname;
	
	@FindBy(css="a[href='/logout']")
	WebElement logoutbtn;
	@FindBy(css = "ul.nav.navbar-nav li a b")
	WebElement username;

	public String loginas(WebDriverWait wait) {
	    wait.until(ExpectedConditions.visibilityOf(username));
	    return username.getText();
	}
	
	public void clicklogout() {
		logoutbtn.click();
	}
}
