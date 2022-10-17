package com.crm.organization;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.generic_utility.BaseClass;
import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.File_Utility;
import com.crm.generic_utility.Java_Utility;
import com.crm.generic_utility.Webdriver_Utility;
import com.crm.pomrepository.HomePage;
import com.crm.pomrepository.LoginPage;
import com.crm.pomrepository.OrganizationPage;
import com.crm.pomrepository.VerificationAndValidation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest extends BaseClass {

	//@Test(retryAnalyzer = com.crm.generic_utility.RetryAnalyser.class)
	@Test(groups = "smokeTest")
	public void organizationsTest()throws IOException, Throwable  {
		//create generic library objects
		Java_Utility jLib=new Java_Utility();
		Excel_Utility eLib=new Excel_Utility();

		//read the test data
		String data = eLib.getExcellData("QSP", 0, 0)+jLib.getRandomNum();

		// Navigating to organizations page
		HomePage home=new HomePage(driver);
		home.clickOrganizationLink();

		//Create organization and save
		OrganizationPage org=new OrganizationPage(driver);  
		org.clickOnCreateOrganizion();
		//	SoftAssert soft=new SoftAssert();
		//	soft.assertEquals("A", "B");
		//	Assert.assertEquals(false, true);
		org.setAccountName(data);
		org.clickOnSaveButton();
		String actText = org.getActualResult();
		VerificationAndValidation validate=new VerificationAndValidation(driver);
		validate.organizationValidation(driver, data);
  //  soft.assertAll();
	}


}
