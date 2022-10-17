package com.crm.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VerificationAndValidation {
	
	//initialization
	public VerificationAndValidation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement actualOrganizationData;
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement actualProductData;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement actualCampaignData;

	//getter methods
	public WebElement getActualOrganizationData() {
		return actualOrganizationData;
	}

	public WebElement getActualProductData() {
		return actualProductData;
	}

	public WebElement getActualCampaignData() {
		return actualCampaignData;
	}
	
	
	//Business logic
	
	public void organizationValidation(WebDriver driver,String data)
	{
		String actData=actualOrganizationData.getText();
		
		if(actData.contains(data))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
	}
	
	
	public void productValidation(WebDriver driver,String data)
	{
		String actData=actualProductData.getText();
		
		if(actData.contains(data))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
	}
	
	public void campaignValidation(WebDriver driver,String data)
	{
		String actData=actualCampaignData.getText();
		
		if(actData.contains(data))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
	}

}
