package com.myStore.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager implements ITestListener{
	private static ExtentReports report;
	private static ExtentTest test;
	private static String reportFileName="My_Report"+(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()))+".html";
	private static String reportPath=System.getProperty("user.dir")+"\\TestReport"+reportFileName;
	
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
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		return report;
	}

	@Override
	public void onFinish(ITestContext arg0) {
		Reporter.log(reportPath);
		ExtentManager.getInstance().flush();
		
	}

	@Override
	public void onStart(ITestContext arg0) {
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
		test=ExtentManager.getInstance().createTest(result.getTestClass().getRealClass().getSimpleName()).log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.GREEN));
		
	}
}
