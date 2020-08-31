package com.myStore.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.myStore.pageObject.*;
import com.myStore.utils.ExtentManager;

@Listeners(ExtentManager.class)

public class TshirtTest extends Tshirts{

	BasePage bp;
	Tshirts ts;
	IndexPage ip;
	CartPage cp;
	
	@BeforeSuite
    public void setup() throws IOException{
        initialization();
        bp=new BasePage();
        ts=new Tshirts();
        ip=new IndexPage();
        cp=new CartPage();
       }
	
	@AfterSuite
	public void teardown(){
		driver.close();
	}
	
	@AfterMethod 
	public void screenShot(ITestResult result){
	try{
	TakesScreenshot screenshot=(TakesScreenshot)driver;
	File src=screenshot.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\TestReport\\Screenshots\\"+result.getName()+bp.time+".png"));
	System.out.println("Successfully captured a screenshot");
	}catch (Exception e){
	System.out.println("Exception while taking screenshot "+e.getMessage());
	}
	}
	
	@Test(priority=1)
	public void orderTshirt(){
		ip.chooseTabTshirts();
		ts.addToCart("Faded Short Sleeve T-shirts");
		cp.openCart();
//		cp.deleteProductfromCart();
	}
}
