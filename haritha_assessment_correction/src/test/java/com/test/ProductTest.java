package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;
import com.pages.CartPage;
import com.pages.LoginPage;
import com.pages.PaymentPage;
import com.pages.SearchPage;
import com.pages.SignupPage;
import com.pages.UserHomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ProductTest extends MainTest {
	private static final Logger log = LogManager.getLogger(ProductTest.class);
  @Test
  public void Search() {
	  log.info("Starting Search Test");
	  signup=new SignupPage(driver);
	  signup.link();
	  login=new LoginPage(driver);
	  home=new UserHomePage(driver);
	  login.waitforlogintext(wait);
	  log.info("Logging into application");
	  login.login("haritha27@gmail.com", "haritha@20");
	  log.info( "The user name is:"+ home.loginas(wait));
	  search=new SearchPage(driver);
	  search.clickProductLink();
	  search.waitforSearch();
	  search.product("top");
	  search.clicklogo();
	  Assert.assertTrue(search.waitforSearchTest());
	  Assert.assertTrue(search.isProductDisplayed());
	  Assert.assertTrue(search.getFirstProductName().toLowerCase().contains("top"));
	  log.info("the searched product item:"+search.getFirstProductName());
  }
  @Test(dependsOnMethods="Search")
  public void cart() {
	  cart=new CartPage(driver);
	  cart.clickviewProduct();
	  cart.waitforcart();
	  Assert.assertEquals(cart.cartsuccessful(), "Your product has been added to cart.");
	  log.info(cart.cartsuccessful());
	  cart.clickcontinue();
	  cart.clickcartlink();
	  Assert.assertTrue(cart.cartProductText().contains("Blue Top"));
	  cart.clickcheckout();  
  }
  

  @Test(dependsOnMethods="cart")
  public void payment() {
      payment = new PaymentPage(driver);
      payment.waitforplacebtn();
      payment.clickorder();
      payment.waitforpaymenttittle();
      payment.payment("aaaa", "11111", "311", "09", "2025");
      SoftAssert soft = new SoftAssert();
      soft.assertEquals(payment.orderplaced(), "ORDER PLACED!");
      log.info(payment.orderplaced());
      payment.clickcontinue();
      soft.assertAll(); 
  }
  
  
}
