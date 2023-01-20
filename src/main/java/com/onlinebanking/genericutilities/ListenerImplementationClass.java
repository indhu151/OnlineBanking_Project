package com.onlinebanking.genericutilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) 
	{
		//Execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"----->Testscript Execution started");
	}

	public void onTestSuccess(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"----->Passed" );
		Reporter.log(MethodName+"----->testscript execution successful");
	}

	public void onTestFailure(ITestResult result)
	{
		String FailedScript = result.getMethod().getMethodName();
		//String name=result.getName()+new JavaUtility().getSysDateAndTime();
		String FS=FailedScript+new JavaUtility().getSysDateAndTime();
		EventFiringWebDriver sdriver=new EventFiringWebDriver(BaseClass.edriver);
		File src = sdriver.getScreenshotAs(OutputType.FILE);
		String path="./Screenshot/"+FS+".png";
		File dst=new File(path);
		String filepath = dst.getAbsolutePath();
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		test.addScreenCaptureFromPath(filepath);
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("testscript execution failed");
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,MethodName+"----->Skipped" );
		Reporter.log("testscript execution skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		//Configure the report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-45 Extent Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("OnlineBanking Report");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Online_Banking_System/");
		report.setSystemInfo("Reporter Name", "Indhu");
		
	}

	public void onFinish(ITestContext context)
	{
		
		//consolidate the report
		report.flush();
	}
	

}
