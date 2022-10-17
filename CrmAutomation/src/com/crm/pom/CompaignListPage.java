package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompaignListPage {
	
	@FindBy(xpath="//input[@value='New Campaign']")
	private WebElement newCompaign;
	
	@FindBy(name="property(Campaign Name)")
	private WebElement cmpgntxtbx;
	
	@FindBy(name="property(Expected Revenue)")
	private WebElement expRevenueTxtbx;
	
	@FindBy(name="property(Actual Cost)")
	private WebElement actcostTxtbx;
	
	@FindBy(name="property(Num sent)")
	private WebElement numsendTxtbx;
	
	@FindBy(name="property(Budgeted Cost)")
	private WebElement budgCostTxtbx;
	
	@FindBy(name="property(Expected Response)")
	private WebElement exptRespTxtbx;
	
	@FindBy(name="property(Description)")
	private WebElement descpTxtbx;
	
	@FindBy(xpath="(//input[@value='Save'])[2]")
	private WebElement saveBtn;
	
	public CompaignListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getNewCompaign() {
		return newCompaign;
	}

	public WebElement getCmpgntxtbx() {
		return cmpgntxtbx;
	}

	public WebElement getExpRevenueTxtbx() {
		return expRevenueTxtbx;
	}

	public WebElement getActcostTxtbx() {
		return actcostTxtbx;
	}

	public WebElement getNumsendTxtbx() {
		return numsendTxtbx;
	}

	public WebElement getBudgCostTxtbx() {
		return budgCostTxtbx;
	}

	public WebElement getExptRespTxtbx() {
		return exptRespTxtbx;
	}

	public WebElement getDescpTxtbx() {
		return descpTxtbx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}	
	
}
