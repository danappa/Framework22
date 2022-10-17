package com.crm.generic_utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result)
	{
		String testName = result.getMethod().getMethodName();
		System.out.println(testName+"----Executing listening---");
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sDriver);
		File srcFile=edriver.getScreenshotAs(OutputType.FILE);
		
		File dest=new File("./com.vtiger.selenium/Screenshot/"+testName+".png");
		try {
			FileUtils.copyFile(srcFile, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	
	

}
