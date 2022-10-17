package com.crm.compaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.generic_utility.BaseClass;
import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.File_Utility;
import com.crm.generic_utility.Java_Utility;
import com.crm.generic_utility.Webdriver_Utility;
import com.crm.pomrepository.CampaignPage;
import com.crm.pomrepository.HomePage;
import com.crm.pomrepository.LoginPage;
import com.crm.pomrepository.ProductAndActionPage;
import com.crm.pomrepository.ProductsPage;
import com.crm.pomrepository.VerificationAndValidation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCompaignWithProductTest extends BaseClass {

	@Test
	public void campaignWithProductTest() throws Throwable{

		//create generic library objects
		Java_Utility jLib=new Java_Utility();
		Excel_Utility eLib=new Excel_Utility();
		Webdriver_Utility wLib=new Webdriver_Utility();

		//read test data
		String productdata = eLib.getExcellData("Product", 0, 0)+jLib.getRandomNum();
		String data = eLib.getExcellData("Product", 0, 0)+jLib.getRandomNum();

		//Navigating to Products page
		HomePage home=new HomePage(driver);
		home.clickProductionLink();

		//Create product and save
		ProductsPage prod=new ProductsPage(driver);
		prod.clickOnCreateProductIcon();
		prod.setproductName(productdata);
		prod.clickOnSaveButton1();

		//Navigating to campaign page
		home.moveToMoreLink(driver);
		home.clickCampaignLink(); 

		//Create campaign and  add product
		CampaignPage camp=new CampaignPage(driver);
		camp.clickOnCreateCampaignImg();
		camp.setCampaignName(data);
		camp.clickOnAddProductImg();

		//Switch to Products&action window and add the product name
		ProductAndActionPage ProdAct=new ProductAndActionPage(driver);
		wLib.switchToWindow(driver, "Products&action");
		ProdAct.setProductName(data);
		ProdAct.clickOnSearchButton();
		ProdAct.clickProductNametextLink();

		//Switch to Campaigns&action window and save it
		wLib.switchToWindow(driver, "Campaigns&action");
		camp.clickOnSaveButton();

		//validation
		VerificationAndValidation validate=new VerificationAndValidation(driver);
        validate.campaignValidation(driver, data);
		
  /*		//Verify
		String actData=camp.getActualResult();
		if(actData.contains(data))
		{
			System.out.println("Test case Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		*/
	}
}
