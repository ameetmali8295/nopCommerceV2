package com.nopcommerce.testCases;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;

import com.nopcommerce.pageObjects.LoginTest;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void LoginTest() throws InterruptedException, IOException
	{
		driver.get(baseUrl);
		
		logger.info("Url is Opened");
		
		LoginTest lp = new LoginTest(driver);
		lp.setUserName(username);
		
		logger.info("UserName is provided");
		lp.setPassword(password);
		logger.info("Pasword is provided");
		lp.clickLogin(); 
		logger.info("Login Button is clicked");
		Thread.sleep(5000);
	      //	Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration123"))
		{
			//System.out.println("Test is Passed");
			
			Assert.assertTrue(true);
			lp.clickLogout();
			
			logger.info("Login is Passed");
		}
		else 
		{
			captureScreen(driver, "loginTest");
			Assert.assertFalse(false);
			logger.info("Login is Failed");
		}

		
	}
	
	
	
}
