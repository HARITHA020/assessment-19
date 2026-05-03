package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends MainPage {
	WebDriverWait wait;

	public SearchPage(WebDriver driver) {
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(css = "a[href='/products']")
	WebElement productlink;

	@FindBy(css = "#search_product")
	WebElement searchbox;

	@FindBy(css = "#submit_search")
	WebElement searchlogo;

	@FindBy(css = ".title.text-center")
	WebElement searchedtext;

	@FindBy(css = ".productinfo p")
	List<WebElement> productNames;

	public void clickProductLink() {
		productlink.click();
	}

	public void waitforSearch() {
		wait.until(ExpectedConditions.visibilityOf(searchbox));
	}

	public void product(String product) {
		searchbox.sendKeys(product);
	}

	public String productSearch() {
	    return searchbox.getAttribute("value");   
	}

	public void clicklogo() {
		searchlogo.click();
	}

	public boolean waitforSearchTest() {
		wait.until(ExpectedConditions.visibilityOf(searchedtext));
		return searchedtext.isDisplayed();
	}

	public boolean isProductDisplayed() {
		return productNames.size() > 0;
	}

	public String getFirstProductName() {
		return productNames.get(0).getText();
	}
}
