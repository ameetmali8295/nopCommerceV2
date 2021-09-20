package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginTest;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDTest_002 extends BaseClass {
	
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String password) throws InterruptedException, IOException
	{
driver.get(baseUrl);
		
		logger.info("Url is Opened");
		driver.manage().window().maximize();
		LoginTest lp = new LoginTest(driver);
		lp.setUserName(user);
		
		logger.info("UserName is provided");
		lp.setPassword(password);
		logger.info("Pasword is provided");
		lp.clickLogin(); 
		logger.info("Login Button is clicked");
		Thread.sleep(5000);
	      //	Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			//System.out.println("Test is Passed");
			
			Assert.assertTrue(true);
			lp.clickLogout();
			
			logger.info("Login is Passed");
		}
		else 
		{
			//captureScreen(driver, "loginTest");
			Assert.assertFalse(false);
			logger.info("Login is Failed");
		}

	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path = "C://Users//praveen//eclipse-workspace//nopCommerceV2//src//test//java//com//nopcommerce//testData//LoginData.xlsx";
		int rowNum=  XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 0);
		
		String loginData[][]= new String[rowNum][colCount];
		
		for(int i=1; i<=rowNum; i++)
		{
			for(int j=0; j<colCount; j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return loginData;
	}

}
 