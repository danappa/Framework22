package com.crm.compaign;

import org.testng.annotations.Test;

import com.crm.generic_utility.BaseClass;
import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.Java_Utility;
import com.crm.pomrepository.CampaignPage;
import com.crm.pomrepository.HomePage;
import com.crm.pomrepository.VerificationAndValidation;

public class CreateCampaignTest extends BaseClass
{

	@Test(groups = {"regressionTest"})
	public void createCampaignmethodTest() throws Throwable {

		//create generic library objects
		
		Excel_Utility eLib=new Excel_Utility();
		Java_Utility jLib=new Java_Utility();

		//Read test data
		String data = eLib.getExcellData("Campaign", 0, 0)+jLib.getRandomNum();

		//Navigating to Campaign page
		HomePage home=new HomePage(driver);
		home.moveToMoreLink(driver);
		home.clickCampaignLink();

		//Create campaign and save
		CampaignPage camp=new CampaignPage(driver);
		camp.clickOnCreateCampaignImg();
		camp.setCampaignName(data);
	//	Assert.assertEquals(true, false);
		camp.clickOnSaveButton();

		//validation
		VerificationAndValidation validate=new VerificationAndValidation(driver);
        validate.campaignValidation(driver, data);
		
		//Verify
	/*	String actData = camp.getActualResult();
		if(actData.contains(data))
		{
			System.out.println("Compaign created and pass");
		}
		else 
		{
			System.out.println("Compaign not created and fail");
		}
		          */
		
		
	}
	
}

