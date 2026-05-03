package com.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.pages.AccountPage;
import com.pages.CartPage;
import com.pages.LoginPage;
import com.pages.PaymentPage;
import com.pages.SearchPage;
import com.pages.SignupPage;
import com.pages.SigupDetailsPage;
import com.pages.UserHomePage;


public class MainTest {
	WebDriver driver;
	WebDriverWait wait;
	SignupPage signup;
	SigupDetailsPage details;
	UserHomePage home;
	AccountPage account;
	LoginPage login;
	SearchPage search;
	CartPage cart;
	PaymentPage payment;
	 @BeforeClass
	    public void start() {
	        System.out.println("Start the test ");

	        EdgeOptions options = new EdgeOptions(); 
	        options.addArguments("--start-maximized");
	        options.addArguments("--disable-notifications");
	        options.addArguments("--disable-extensions");

	        options.addArguments("--disable-save-password-bubble");
	        options.addArguments("--disable-autofill-keyboard-accessory-view[8]");
	        options.addArguments("--disable-features=AutofillServerCommunication");
	        options.addArguments("--guest");

	        driver = new EdgeDriver(options);
	        driver.get("https://automationexercise.com/");

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    @AfterClass
	    public void stop() {
	        driver.quit();
	    }
  
}
