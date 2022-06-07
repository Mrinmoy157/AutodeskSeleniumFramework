package com.crm.autodesk.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener{
	
	ExtentTest test;
	ExtentReports report;
	public void onTestStart(ITestResult result) {
//		String methodName=result.getMethod().getMethodName();
//		System.out.println(methodName+" started");
		
		
		//Step3: Create a test method during the test execution starts
		test=report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
//		String methodName=result.getMethod().getMethodName();
//		System.out.println(methodName+" success");
		
		//Step4: log the pass method
		test.log(Status.PASS,result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
//		String methodName=result.getMethod().getMethodName();
//		System.out.println(methodName+" failed");
//		System.out.println(result.getThrowable());
//		try {
//			String path=new WebDriverUtility().takeScreenshot(BaseClass.sDriver, methodName);
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//Step6: log the fail method, take screenshot, attach to extent report, add exception log
		
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL,result.getThrowable());
		String path=null;
		WebDriverUtility wutility= new WebDriverUtility();
		try {
			path=wutility.takeScreenshot(BaseClass.sDriver,result.getMethod().getMethodName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
//		String methodName=result.getMethod().getMethodName();
//		System.out.println(methodName+" skipped");
//		System.out.println(result.getThrowable());
		
		//Step5: log the skip method
		test.log(Status.SKIP,result.getMethod().getMethodName());
		test.log(Status.SKIP,result.getThrowable());
	}

	public void onStart(ITestContext context) {
		//System.out.println("execution started");
		
		//Step1: Extent report configuration
		ExtentSparkReporter htmlReporter= new ExtentSparkReporter("./extentReport"+new JavaUtility().getSystemDateWithFormat()+".html");
		htmlReporter.config().setReportName("Regression execution report");
		htmlReporter.config().setDocumentTitle("comcast automation execution report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		//Step2: Attach the physical report and do system configuration
		
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS","Windows 10");
		report.setSystemInfo("Environment","Testing Environment");
		report.setSystemInfo("URL","http://localhost:8888");
		report.setSystemInfo("Reporter Name","Mrinmoy");
		
	}

	public void onFinish(ITestContext context) {
		//System.out.println("execution finished");
		
		report.flush();
	}
	

}
