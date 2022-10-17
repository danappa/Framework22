package com.crm.product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
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
import com.crm.pomrepository.HomePage;
import com.crm.pomrepository.LoginPage;
import com.crm.pomrepository.ProductsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteProductTest extends BaseClass {

	@Test
	public void deleteProductMethodTest()throws Throwable {

		//create generic library objects
		File_Utility fLib=new File_Utility();
		Java_Utility jLib=new Java_Utility();
		Excel_Utility eLib=new Excel_Utility();
		Webdriver_Utility wLib=new Webdriver_Utility();

		//read test data
		String data = eLib.getExcellData("Product", 0, 0)+ jLib.getRandomNum();

		//Navigating to products page
		HomePage home=new HomePage(driver);
		home.clickProductionLink();

		//Create product and save
		ProductsPage prod=new ProductsPage(driver);		
		prod.clickOnCreateProductIcon();
		prod.setproductName(data);
		prod.clickOnSaveButton1();

		//Delete product
		prod.clickOnDeleteButton();
		wLib.switchToAlertAndAccept(driver);
		System.out.println("Product is deleted");
	}
}
