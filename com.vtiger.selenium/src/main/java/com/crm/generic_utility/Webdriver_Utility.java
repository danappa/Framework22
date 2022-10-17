package com.crm.generic_utility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver_Utility 

{
	/**
	 * wait for page load
	 * @author Santhosh
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	/**
	 * this is generic method for Explictwait
	 * @param driver
	 * @param element
	 * @author Santhosh
	 */	
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	/**
	 * This method for window maximize
	 * @param driver
	 */
	public void maximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}


	/**
	 * To select the options from the listbox using visible text
	 * @param element
	 * @param text
	 * @author Santhosh
	 */
	public void selectOptionText(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}


	/**
	 * To select the option from listbox using by value
	 * @param element
	 * @param value
	 * @author Santhosh
	 */	
	public void selectOptionValue(WebElement element,String value)
	{
		Select s=new Select(element);
		s.deselectByValue(value);
	}


	/**
	 * To select the option from listbox using Index
	 * @param element
	 * @param index
	 * @author Santhosh
	 */
	public void selectOptionIndex(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}


	/**
	 * This method for right click on the elemenet
	 * @param driver
	 * @param element
	 * @author Santhosh
	 */
	public void rightClickOption(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}


	/**
	 * This method for double click on the element
	 * @param driver
	 * @param element
	 * @author Santhosh
	 */
	public void doubleClickonElement(WebDriver driver,WebElement element) 
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}


	/**
	 * This method for drag and drop
	 * @param driver
	 * @param src
	 * @param targ
	 * @author Santhosh
	 */
	public void dragAndDropOption(WebDriver driver,WebElement src,WebElement targ) 
	{
		Actions act2=new Actions(driver);
		act2.dragAndDrop(src, targ);
	}


	/**
	 * This method for move the cursor to particular element
	 * @param driver
	 * @param target
	 * @author Santhosh
	 */
	public void moveElementOption(WebDriver driver,WebElement target)
	{
		Actions act=new Actions(driver);
		act.moveToElement(target).perform();;
	}


	/**
	 * This method for switch to particular window
	 * @param driver
	 * @param windowTitle
	 * @author Santhosh
	 */
	public void switchToWindow(WebDriver driver,String partialwindowTitle)
	{
		Set<String> allwh = driver.getWindowHandles();
		Iterator<String> itr = allwh.iterator();
		while(itr.hasNext())
		{
			String wh = itr.next();
			driver.switchTo().window(wh);
			if(driver.getTitle().contains(partialwindowTitle)) 
			{
				break;
			}
		}

	}


	/**
	 * This method for accept the alert popup
	 * @param driver
	 * @author Santhosh
	 */
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}


	/**
	 * This method for dismiss the alert popup
	 * @param driver
	 * @author Santhosh
	 */
	public void switchToAlertAndDismiss(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}

	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver , int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver , String name) 
	{
		driver.switchTo().frame(name);
	}
}






