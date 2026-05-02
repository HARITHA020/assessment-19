package com.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SigupDetailsPage extends MainPage {
	WebDriverWait wait;

	public SigupDetailsPage(WebDriver driver) {
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(css = "label[for='id_gender2']")
	WebElement gender;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(css = "#days")
	WebElement days;

	@FindBy(css = "#days > option:nth-child(5)")
	WebElement dayoption;

	@FindBy(css = "#months")
	WebElement months;

	@FindBy(css = "#months > option:nth-child(6)")
	WebElement monthoption;

	@FindBy(css = "#years")
	WebElement years;

	@FindBy(css = "#years > option:nth-child(6)")
	WebElement yearoption;

	@FindBy(id = "first_name")
	WebElement firstname;

	@FindBy(id = "last_name")
	WebElement lastname;

	@FindBy(id = "company")
	WebElement company;

	@FindBy(id = "address1")
	WebElement address;

	@FindBy(id = "country")
	WebElement country;

	@FindBy(css = "#country > option:nth-child(1)")
	WebElement countryoption;

	@FindBy(id = "state")
	WebElement state;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "zipcode")
	WebElement zipcode;

	@FindBy(id = "mobile_number")
	WebElement number;

	@FindBy(css = "button[data-qa='create-account']")
	WebElement createaccount;

	@FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
	WebElement detailtext;

	@FindBy(css = "#uniform-months")
	WebElement monthchoice;

	@FindBy(css = "#uniform-years")
	WebElement yearchoice;

	public void waitfordetailtittle() {
		wait.until(ExpectedConditions.visibilityOf(detailtext));
	}


	public void details(String userpass, String first, String last, String usercompany, String useraddress,
			String userstate, String usercity, String code, String mobile) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait.until(ExpectedConditions.elementToBeClickable(gender)).click();
		password.sendKeys(userpass);
		wait.until(ExpectedConditions.elementToBeClickable(days)).click();
		wait.until(ExpectedConditions.elementToBeClickable(dayoption)).click();
		js.executeScript("arguments[0].scrollIntoView(true);", months);
		wait.until(ExpectedConditions.elementToBeClickable(months)).click();
		wait.until(ExpectedConditions.elementToBeClickable(monthoption)).click();
		wait.until(ExpectedConditions.elementToBeClickable(years)).click();
		wait.until(ExpectedConditions.elementToBeClickable(yearoption)).click();
		firstname.sendKeys(first);
		lastname.sendKeys(last);
		company.sendKeys(usercompany);
		address.sendKeys(useraddress);
		js.executeScript("arguments[0].scrollIntoView(true);", country);
		wait.until(ExpectedConditions.elementToBeClickable(country)).click();
		wait.until(ExpectedConditions.elementToBeClickable(countryoption)).click();
		state.sendKeys(userstate);
		city.sendKeys(usercity);
		zipcode.sendKeys(code);
		number.sendKeys(mobile);
		wait.until(ExpectedConditions.elementToBeClickable(createaccount)).click();
	}

}
