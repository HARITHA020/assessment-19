package com.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.pages.SignupPage;
import com.pages.SigupDetailsPage;
import com.pages.UserHomePage;
@Listeners(com.test.listener.class)
public class CommonTest extends MainTest {
  @Test(priority=2)
  public void signupTestExist() {

	  signup=new SignupPage(driver);
	  signup.link();
	  signup.waitfortext(wait);
	  signup.signup("haritha", "haritha@gmail.com"); 
	  Assert.assertEquals(signup.error(), "Email Address already exist!");
  }
  
  @Test(priority=1)
  public void signupTest() {
	  signup=new SignupPage(driver);
	  signup.link();
	  signup.waitfortext(wait);
	  signup.signup("haritha", "haritha11@gmail.com"); 
  }
  
  @Test(dependsOnMethods="signupTest")
  public void SigupDetails() {
	  details=new SigupDetailsPage(driver);
	  details.waitfordetailtittle();
	  details.details("haritha@20", "haritha", "D", "ZZZZ", "YYYY", "TamilNadu", "Salem", "223344", "5469874526");
  }
  
  @Test(dependsOnMethods="SigupDetails")
  public void accountcreated() {
	  account=new AccountPage(driver);
	  account.waitfortext(wait);
	  Assert.assertEquals(account.accounttittle(), "Account Created!");
	  account.waitforcontinue(wait);
  }
  
  @Test(dependsOnMethods="accountcreated")
  public void homePage() {
	  home=new UserHomePage(driver);
	  System.out.println( home.loginas());
	  home.clicklogout();
  }
  
  
  @Test(priority=3)
  public void loginpage() {
	  login=new LoginPage(driver);
	  login.waitforlogintext(wait);
	  login.login("haritha11@gmail.com", "haritha@20");
  }
  
  
  
  
  
}
