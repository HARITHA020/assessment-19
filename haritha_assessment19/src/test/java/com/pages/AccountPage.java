package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage  extends MainPage{

	  public AccountPage(WebDriver driver) {
		super(driver);
	}

      @FindBy(xpath="//b[text()='Account Created!']")
      WebElement accounttext;
	  @FindBy(css=".btn.btn-primary")
	  WebElement continuebtn;
	  

	  public String accounttittle() {
		  return accounttext.getText();
	  }
	  
	  public void waitfortext(WebDriverWait wait) {
		  wait.until(ExpectedConditions.visibilityOf(accounttext));
		  
	  }
	  
	  public void waitforcontinue(WebDriverWait wait) {
		  wait.until(ExpectedConditions.visibilityOf(continuebtn));
		  continuebtn.click();
	  }
}
