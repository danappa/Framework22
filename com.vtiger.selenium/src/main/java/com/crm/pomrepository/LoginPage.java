package com.crm.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Initialization
	public LoginPage(WebDriver drver)
	{
		PageFactory.initElements(drver, this);
	}
	
	
	//Declaration
	@FindBy(name="user_name")
	private WebElement usernameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;

	
	//Getters methods
	public WebElement getUsernameTextField()
	{
		return usernameTextField;
	}

	public WebElement getPasswordTextField() 
	{
		return passwordTextField;
	}

	public WebElement getSubmitButton()
	{
		return submitButton;
	}
	
	
	/**
	 * business logic
	 * this method is used to login application
	 * @param un
	 * @param pw
	 * @author santhosh
	 */
	
	public void login(String un,String pw)
	{
		usernameTextField.sendKeys(un);
		passwordTextField.sendKeys(pw);
		submitButton.click();
	}
	
	
}
