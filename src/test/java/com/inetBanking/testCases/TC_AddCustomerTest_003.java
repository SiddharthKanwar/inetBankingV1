package com.inetBanking.testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
    public void addNewCustomer() throws InterruptedException, IOException
    {
    	LoginPage lp= new LoginPage(driver);
    	lp.setUserName(username);
    	logger.info("User name is provided");
    	lp.setPassword(password);
    	logger.info("Password is provided");
    	lp.clickSubmit();
    	
    	Thread.sleep(3000);
    	
    	AddCustomerPage addcust= new AddCustomerPage(driver);
    	
    	addcust.clickAddNewCustomer();
    	
    	logger.info("providing customer details....");
    	
    	addcust.custName("Siddharth");
    	addcust.custgender("male");
    	addcust.custdob("16","12","1989");
    	Thread.sleep(3000);
        addcust.custaddress("INDIA");
    	addcust.custcity("Bhakra Nangal");
    	addcust.custstate("Punjab");
    	addcust.custpinno("140126");
    	addcust.custtelephoneno("7507093772");
    	
    	String email= randomstring()+"@gmail.com";
    	addcust.custemailid(email);
    	addcust.custpassword("abcdef");
    	addcust.custsubmit();
    	
    	Thread.sleep(3000);
    	
    	logger.info("validation started....");
    	boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
    	if(res==true)
    	{
    		Assert.assertTrue(true);
    		logger.info("test case passed....");
    	}
    	else
    	{
    		logger.info("test case failed....");
    		captureScreen(driver, "addNewCustomer");
    		Assert.assertTrue(false);
    	}
    }
    
    
}
