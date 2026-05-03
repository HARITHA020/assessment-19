package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CartPage extends MainPage {
	WebDriverWait wait;
	public CartPage(WebDriver driver) {
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(css="a[href='/product_details/1']")
	WebElement productsview;
	
	@FindBy(css = ".btn.btn-default.cart")
	WebElement addtocart;
	
	@FindBy(xpath="//p[normalize-space()='Your product has been added to cart.']")
	WebElement carttext;
	
	@FindBy(css=".btn.btn-success.close-modal.btn-block")
	WebElement continuebtn;
	
	@FindBy(xpath="(//div[@class=\"row\"])[1]/div[2]/div/ul/li[3]/a")
	WebElement cartlink;
	
	@FindBy(css="a[href='/product_details/1']")
	WebElement cartproduct;
	
	@FindBy(css=".btn.btn-default.check_out")
	WebElement checkoutbtn;
	
	public void clickviewProduct() {
		productsview.click();
	}
	public void waitforcart() {
		wait.until(ExpectedConditions.visibilityOf(addtocart));
		addtocart.click();
	}
	
	public String cartsuccessful() {
	    wait.until(ExpectedConditions.visibilityOf(carttext));
	    return carttext.getText();
	}
	
	public void clickcontinue() {
		continuebtn.click();
	}
	
	public void clickcartlink() {
		cartlink.click();
	}
	
	public String cartProductText() {
		return cartproduct.getText();
	}
	
	public void clickcheckout() {
		checkoutbtn.click();
	}
}
