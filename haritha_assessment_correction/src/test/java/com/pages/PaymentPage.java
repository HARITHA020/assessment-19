package com.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends MainPage {
	WebDriverWait wait;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(css = ".btn.btn-default.check_out")
	WebElement placeorder;
	
	@FindBy(xpath="//form[@id=\"payment-form\"]/div[1]/div/input")
	WebElement cardname;
	
	@FindBy(xpath="//form[@id=\"payment-form\"]/div[2]/div/input")
	WebElement cardnumber;
	 
	@FindBy(xpath="//form[@id=\"payment-form\"]/div[3]/div[1]/input")
	WebElement cvc;
	
	@FindBy(xpath="//form[@id=\"payment-form\"]/div[3]/div[2]/input")
	WebElement month;
	
	@FindBy(xpath="//form[@id=\"payment-form\"]/div[3]/div[3]/input")
	WebElement year;
	
	@FindBy(xpath="//*[@id=\"cart_items\"]/div/div[2]/h2")
	WebElement paymenttitle;
	@FindBy(id="submit")
	WebElement confirm;
	
	@FindBy(css="h2[class='title text-center'] b")
	WebElement ordertext;
	
	@FindBy(css=".btn.btn-primary")
	WebElement continuebtn;
	
	public void waitforplacebtn() {
		wait.until(ExpectedConditions.visibilityOf(placeorder));
	}
	
	public void clickorder() {
		placeorder.click();
	}
	
	public void waitforpaymenttittle() {
		wait.until(ExpectedConditions.visibilityOf(paymenttitle));
	}
	public void payment(String card, String number, String CVC, String Month,String Year) {
		cardname.sendKeys(card);
		cardnumber.sendKeys(number);
		cvc.sendKeys(CVC);
		month.sendKeys(Month);
		year.sendKeys(Year);

	    wait.until(ExpectedConditions.elementToBeClickable(confirm));

	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", confirm);
	}
	
	public String orderplaced() {
		return ordertext.getText();
	}
	
	public void clickcontinue() {
		continuebtn.click();
	}

}
