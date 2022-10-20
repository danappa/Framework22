package com.crm.generic_utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.pomrepository.HomePage;
import com.crm.pomrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 
	public WebDriver driver;
	public static WebDriver sDriver;
	File_Utility fLib=new File_Utility();
	Webdriver_Utility wLib=new Webdriver_Utility();
	
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void bS()
	{
		System.out.println("DataBase Connection");
	}

	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void bT()
	{
		System.out.println("Execute in parallel mode");
	}

//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
//	public void bC(String BROWSER) throws IOException
	public void bC() throws IOException
	{
		
		String Url = fLib.getPropertykey("url");
		String BROWSER = fLib.getPropertykey("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
			
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}

		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}

		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}

		else 
		{
			driver=new ChromeDriver();
		}
		
		sDriver=driver;
		
		driver.get(Url);
		wLib.maximizeTheWindow(driver);
		wLib.waitForPageLoad(driver);
		System.out.println("Launching the browser");
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void bM() throws IOException
	{

		LoginPage log=new LoginPage(driver);
		String Un = fLib.getPropertykey("un");
		String Pw = fLib.getPropertykey("pw");
		log.login(Un, Pw);
		System.out.println("Login to the application");
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void aM()
	{ 
		HomePage home=new HomePage(driver);
		home.moveTosignoutImg(driver);
		home.clickSignoutLink();
		System.out.println("Logout to the application");
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void aC()
	{
		driver.quit();
		System.out.println("close the browser");
	}
	
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void aT()
	{
		System.out.println("Executed successfully");
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void aS()
	{
		System.out.println("Database closed");
	}
}
