package com.myStore.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.myStore.pageObject.BasePage;

public class ExtentManager extends BasePage implements ITestListener{
	private static ExtentReports report;
	private static ExtentTest test;
	private static String reportFileName="MyReport"+time()+".html";
	private static String reportPath=System.getProperty("user.dir")+"\\TestReport\\"+reportFileName;
	
	public static ExtentReports getInstance(){
	if(report==null)
		createInstance();
		return report;
	
	}
	
	public static ExtentReports createInstance(){
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(reportPath);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Test Report");
		htmlReporter.config().setAutoCreateRelativePathMedia(true);
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		return report;
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log(reportPath);
		this.getInstance().flush();
		
	}

	@Override
	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test=ExtentManager.getInstance().createTest(result.getTestClass().getRealClass().getSimpleName()).log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.RED));
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test=ExtentManager.getInstance().createTest(result.getTestClass().getRealClass().getSimpleName()).log(Status.SKIP, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.ORANGE));
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(System.getProperty("user.dir")+"\\TestReport\\Screenshots\\"+result.getName()+time()+".png");
		test=ExtentManager.getInstance().createTest(result.getTestClass().getRealClass().getSimpleName()).log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.GREEN));
		try {
			test.pass("Details", MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"\\TestReport\\Screenshots\\"+result.getName()+time+".png").build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
