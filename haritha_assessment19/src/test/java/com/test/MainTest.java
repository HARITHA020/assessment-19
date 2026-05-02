package com.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.pages.AccountPage;
import com.pages.LoginPage;
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
	 @BeforeClass
	    public void start() {
	        System.out.println("Start the test ");

	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");

	        driver = new ChromeDriver(options);
	        driver.get("https://automationexercise.com/");

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    @AfterClass
	    public void stop() {
	        driver.quit();
	    }
  
}
