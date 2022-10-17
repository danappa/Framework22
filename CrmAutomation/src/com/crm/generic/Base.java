package com.crm.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.crm.pom.HomePage;
import com.crm.pom.LoginPage;

public class Base {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("openBrowser",true);

	}
	
	@AfterTest
	public void closeBrowser() {
		Reporter.log("closeBrowser",true);
		driver.close();
		
	}
	
	@BeforeMethod
	public void login() throws IOException {
		Reporter.log("Login",true);
		FileInputStream fis=new FileInputStream("./data/crmcommondata.property");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String un=p.getProperty("username");
		String pw=p.getProperty("password");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.setLogin(un, pw);
		
	}
	@AfterMethod
	public void logout() throws InterruptedException {
		Reporter.log("Logou",true);
		HomePage h=new HomePage(driver);
		Thread.sleep(4000);
		h.setLogout();
	}

}
