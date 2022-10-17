package com.crm.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.Base;
import com.crm.generic.FileLibCls;
import com.crm.pom.CompaignListPage;
import com.crm.pom.HomePage;

@Listeners(com.crm.generic.ListenerImplementation.class)
public class CompaignModule extends Base {
	
	@Test
	public void createCompaign() throws InterruptedException, EncryptedDocumentException, IOException {
		FileLibCls f=new FileLibCls();
		  String cmpgnName = f.getExcelData("CreateCompaign", 1, 1);
		  String exptRevenue = f.getExcelData("CreateCompaign", 1, 3);
		String actCost = f.getExcelData("CreateCompaign", 1, 4);
		String numSent = f.getExcelData("CreateCompaign", 1, 5);
		String budgCost = f.getExcelData("CreateCompaign", 1, 7);
		String expResponse = f.getExcelData("CreateCompaign", 1, 8);
		String description = f.getExcelData("CreateCompaign", 1, 9);
		
		HomePage h=new HomePage(driver);
		h.setCmpgnMdl();
		
		CompaignListPage c=new CompaignListPage(driver);
		c.getNewCompaign().click();
		c.getCmpgntxtbx().sendKeys(cmpgnName);
		c.getExpRevenueTxtbx().sendKeys(exptRevenue);
		c.getActcostTxtbx().sendKeys(actCost);
		// c.getNumsendTxtbx().sendKeys(numSent);
		c.getBudgCostTxtbx().sendKeys(budgCost);
		//c.getExptRespTxtbx().sendKeys(expResponse);
		c.getDescpTxtbx().sendKeys(description);
		c.getSaveBtn().click();
		Thread.sleep(5000);
			
		Reporter.log("Compaigncreated successfully",true);
		
	}

}
